package com.msgsys.servlet;

import com.msgsys.entity.Message;
import com.msgsys.entity.User;
import com.msgsys.service.MessageService;
import com.msgsys.service.UserService;
import com.msgsys.service.impl.MessageServiceImpl;
import com.msgsys.service.impl.UserServiceImpl;
import com.msgsys.utils.ConstData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 19:04
 * 描述:
 */
@WebServlet("/message.do")
public class MessageServlet extends BaseServlet {
    UserService userService = null;
    MessageService messageService = null;

    public MessageServlet() {
        messageService = new MessageServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    public void queryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Message> messages = messageService.queryMessageByToUid(user.getId());
        request.setAttribute("messages", messages);
        System.out.println(messages);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer messageId = Integer.valueOf(id);
        int result = messageService.delete(messageId);
//刷新
        queryList(request, response);

    }

    public void send(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("mtitle");
        String email = request.getParameter("email");
        String mcontent = request.getParameter("mcontent");
//接收方user
        User toUser = userService.queryUserByEmail(email);
        String msg = null;
        if (toUser == null) {
            //email 不存在
            msg = "email不存在";
//            response.getWriter().write("email不存在！！ ");
//            response.sendRedirect(getServletContext().getContextPath() + "/send.jsp");
        } else {
            Message message = new Message();
            message.setmTitle(title);
            //发送方user
            User fromuser = (User) request.getSession().getAttribute("user");
            message.setFromUid(fromuser.getId());
            message.setToUid(toUser.getId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstData.DATE_FORMAT_STR);

            message.setCreateTime(simpleDateFormat.format(new Date()));
            message.setmContent(mcontent);
            message.setReadFlag(ConstData.MESSAGE_ISREAD_NOT);
            int result = messageService.insert(message);

            if (result > 0) {
                msg = "发送成功！";

            } else {
                msg = "发送失败！";
            }

        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    //查看详情
    public void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer messageId = Integer.valueOf(id);
        Message message = messageService.queryMessageByid(messageId);
        //查看消息
        message.setReadFlag(ConstData.MESSAGE_ISREAD_YES);
        messageService.update(message);
        Integer fromId = message.getFromUid();
        User user = userService.queryUserById(fromId);
        request.setAttribute("message", message);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/details.jsp").forward(request, response);

    }

}
