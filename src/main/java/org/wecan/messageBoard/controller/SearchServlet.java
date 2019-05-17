package org.wecan.messageBoard.controller;

import org.wecan.messageBoard.model.Message;
import org.wecan.messageBoard.service.MessageBoardService;
import org.wecan.messageBoard.service.impl.MessageBoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private MessageBoardService messageBoardService;

    @Override
    public void init() {
        messageBoardService = MessageBoardServiceImpl.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = req.getParameter("content");
        List<Message> messageList = messageBoardService.findNeededMessages(content);
        String res = messageBoardService.messagesToJson2(messageList);

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
