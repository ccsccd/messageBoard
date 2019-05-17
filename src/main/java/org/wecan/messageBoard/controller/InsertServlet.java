package org.wecan.messageBoard.controller;

import org.wecan.messageBoard.model.Message;
import org.wecan.messageBoard.service.MessageBoardService;
import org.wecan.messageBoard.service.impl.MessageBoardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    private static final String ERROR= "{\"status\":\"10001\",\"data\":\"fail!!\"}";
    private static final String OK="{\"status\":\"10000\",\"data\":\"succeed!!\"}";
    private MessageBoardService messageBoardService;

    @Override
    public void init() {
        messageBoardService = MessageBoardServiceImpl.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        String text = req.getParameter("text");
        int pid = Integer.parseInt(req.getParameter("pid"));

        Message message = new Message(username, text, pid);

        String res = ERROR;

        if (messageBoardService.insertMessage(message)) {
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
