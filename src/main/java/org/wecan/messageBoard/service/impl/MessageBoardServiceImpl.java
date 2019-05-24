package org.wecan.messageBoard.service.impl;

import org.wecan.messageBoard.dao.Impl.MessageBoardDaoImpl;
import org.wecan.messageBoard.dao.MessageBoardDao;
import org.wecan.messageBoard.model.Message;
import org.wecan.messageBoard.model.User;
import org.wecan.messageBoard.service.MessageBoardService;

import java.util.List;

public class MessageBoardServiceImpl implements MessageBoardService {
    private static MessageBoardService instance = null;
    private MessageBoardDao messageBoardDao = null;

    public MessageBoardServiceImpl() {
        messageBoardDao = MessageBoardDaoImpl.getInstance();
    }

    public static MessageBoardService getInstance() {
        if (instance == null) {
            synchronized (MessageBoardServiceImpl.class) {
                if (instance == null) {
                    instance = new MessageBoardServiceImpl();
                }
            }
        }
        return instance;
    }

    private List<Message> findContentChild(Message content) {
        List<Message> list = messageBoardDao.findMessagesByPid(content.getId());

        for (Message message : list) {
            List<Message> childList = findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }

    private String createJson(Message message) {
        StringBuffer sb = new StringBuffer();

        sb.append("{\"id\":").append(message.getId())
                .append(",\"username\":\"").append(message.getUsername())
                .append("\",\"text\":\"").append(message.getText())
                .append("\"").append(",\"child\":[");

        List<Message> child = message.getChildContent();

        for (Message content : child) {
            String json = createJson(content);
            sb.append(json).append(",");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]}");
        return sb.toString();
    }

    private String createJson2(Message message) {
        StringBuffer sb = new StringBuffer();

        sb.append("{\"id\":").append(message.getId())
                .append(",\"username\":\"").append(message.getUsername())
                .append("\",\"text\":\"").append(message.getText())
                .append("\"");

        if (sb.charAt(sb.length() - 1) == ',') {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("}");
        return sb.toString();
    }
    @Override
    public List<Message> findAllMessages() {
        List<Message> list = messageBoardDao.findMessagesByPid(0);

        for (Message message : list) {
            List<Message> childList = findContentChild(message);
            message.setChildContent(childList);
        }
        return list;
    }

    @Override
    public String messagesToJson(List<Message> messageList) {
        StringBuffer sb = new StringBuffer();

        sb.append("{\"status\":10000,\"data\":[");

        if (messageList != null && messageList.size() != 0) {
            for (Message content : messageList) {
                sb.append(createJson(content));
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public String messagesToJson2(List<Message> messageList) {
        StringBuffer sb = new StringBuffer();

        sb.append("{\"status\":10000,\"data\":[");

        if (messageList != null && messageList.size() != 0) {
            for (Message content : messageList) {
                sb.append(createJson2(content));
                sb.append(",");
            }
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean insertMessage(Message message) {
        if (message.getUsername() != null && message.getText() != null) {
            messageBoardDao.insertMessage(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMessage(int id) {
        if (messageBoardDao.checkId(id)) {
            messageBoardDao.deleteMessage(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMessage(Message message) {
        if(messageBoardDao.checkId(message.getId())){
            messageBoardDao.updateMessage(message);
            return true;
        }
        return false;
    }

    @Override
    public List<Message> findNeededMessages(String content) {
        List<Message> list = messageBoardDao.findMessagesByContent(content);
        return list;
    }

    @Override
    public boolean insertUser(User user) {
        if (messageBoardDao.checkUser(user.geteMail())) {
                messageBoardDao.insertUser(user);
                return true;
        }
        return false;
    }

    @Override
    public User checkLogin(String eMail, String password) {
        return messageBoardDao.checkLogin(eMail,password);
    }
}
