package org.wecan.messageBoard.controller;



import org.wecan.messageBoard.model.User;
import org.wecan.messageBoard.service.MessageBoardService;
import org.wecan.messageBoard.service.impl.MessageBoardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String ERROR= "{\"status\":\"10001\",\"data\":\"fail!!\"}";
    private static final String OK="{\"status\":\"10000\",\"data\":\"succeed!!\"}";
    private MessageBoardService messageBoardService;

    @Override
    public void init() {
        messageBoardService = MessageBoardServiceImpl.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String eMail = req.getParameter("e-mail");
        String password = req.getParameter("passowrd");

        HttpSession session = req.getSession();
        User user = null;

        String res = ERROR;

        user = messageBoardService.checkLogin(eMail, password);
        if (user != null) {
            session.setAttribute("user", user);
            res = OK;
        }

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        resp.getOutputStream(),"UTF-8"
                )
        );
        writer.write(res);
        writer.flush();
        writer.close();
    }

}
