package com.msgsys.servlet;

import com.msgsys.entity.User;
import com.msgsys.service.UserService;
import com.msgsys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 17:49
 * 描述:注册
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {//继承BaseServlet 调用指定方法
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);
        int result = userService.register(user);
        System.out.println(result);
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String code = request.getParameter("code");
        if (token != null && token.equalsIgnoreCase(code)) {
            User user = userService.login(new User(username, password, null));
            if (user != null) {
                //将登录的信息传给message，去查邮件
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("/message.do?action=queryList").forward(request, response);
                //登录成功
//            response.sendRedirect(request.getContextPath()+"/list.jsp");
            } else {
                //登录失败
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().println("验证码输入有误");
        }

    }
}
