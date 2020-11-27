package com.msgsys.servlet;



import com.msgsys.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        String firename=request.getParameter("name");
        FileUtils fileUtils=new FileUtils();
        try {
            //调用包装类的方法，加载头像
            fileUtils.singleDownload(request,response,path,firename);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        download(request, response, path);
    }
}
