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
                //保存session
                session.setAttribute("user", user);
                request.getRequestDispatcher("/message.do?action=queryList").forward(request, response);
                //登录成功
//            response.sendRedirect(request.getContextPath()+"/list.jsp");
            } else {
                //登录失败
                response.sendRedirect(request.getContextPath() + "/index.html");
            }
        } else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().println("验证码输入有误");
        }

    }

    //通过用户名查询用户
    public void queryUserByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //金句：防止中文乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        if (username.isEmpty()) {
            String message3 = "<font color=\"red\">不能为空</font>";
            response.getWriter().write(message3);
        } else {
            User user = userService.queryUserByUsername(username);
            String message = (user == null) ? "<font color=\"green\">用户名可用</font>" : "<font color=\"red\">用户名不可用</font>";
            response.getWriter().write(message);
        }
    }

    public void queryUserByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //金句：防止中文乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        if (email.isEmpty()) {
            String message2 = "<font color=\"red\">不能为空</font>";
            response.getWriter().write(message2);
        } else {
            User user = userService.queryUserByEmail(email);
            String message = (user == null) ? "<font color=\"green\">邮箱能用</font>" : "<font color=\"red\">邮箱不可用</font>";
            response.getWriter().write(message);
        }

    }

}
