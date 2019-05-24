package org.wecan.messageBoard.controller;

import org.wecan.messageBoard.model.Message;
import org.wecan.messageBoard.model.User;
import org.wecan.messageBoard.service.MessageBoardService;
import org.wecan.messageBoard.service.impl.MessageBoardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet {
    private static final String ERROR2= "{\"status\":\"10002\",\"data\":\"fail, maybe your e-mail has existed!!\"}";
    private static final String ERROR= "{\"status\":\"10001\",\"data\":\"fail, maybe your form is not illegal!!\"}";
    private static final String OK="{\"status\":\"10000\",\"data\":\"succeed!!\"}";
    private MessageBoardService messageBoardService;

    @Override
    public void init() {
        messageBoardService = MessageBoardServiceImpl.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        String eMail = req.getParameter("e-mail");
        String password = req.getParameter("passowrd");

        User user=new User(username,eMail,password);

        String res = ERROR;

        String regex1 ="^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
        String regex2 ="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String regex3 = "^[a-zA-Z]\\w{5,17}$";
        if(user.getUsername().matches(regex1) && user.geteMail().matches(regex2)&& user.getPassword().matches(regex3)){
            if (messageBoardService.insertUser(user)) {
                res = OK;
            }else{
                res=ERROR2;
            }
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
