package org.wecan.messageBoard.dao;

import org.wecan.messageBoard.model.Message;
import org.wecan.messageBoard.model.User;

import java.util.List;

public interface MessageBoardDao {
    /**
     * 找pid为${pid}的留言的集合
     *
     * @param pid 留言的父节点
     * @return 父节点为pid的留言的集合
     */
    List<Message> findMessagesByPid(int pid);

    /**
     * 插入一条留言
     *
     * @param message 留言
     */
    void insertMessage(Message message);

    /**
     * 删除一条留言
     *
     * @param id 留言id
     */
    void deleteMessage(int id);

    /**
     * 更新一条留言
     *
     * @param message 留言
     */
    void updateMessage(Message message);

    /**
     * 找content含${content}的留言的集合
     *
     * @param content 留言的内容
     * @return 内容含content的留言的集合
     */
    List<Message> findMessagesByContent(String content);

    /**
     * 查询留言id是否存在
     *
     * @param id 留言id
     * @return 是否存在
     */
    boolean checkId(int id);

    /**
     * 插入用户
     *
     * @param user 用户
     */
    void insertUser(User user);

    /**
     * 查询邮箱是否已被注册
     *
     * @param eMail e-mail
     * @return 是否已被注册
     */
    boolean checkUser(String eMail);

    /**
     * 登录
     *
     * @param eMail,password e-mail,密码
     * @return 成功返回User类
     */
    User checkLogin(String eMail,String password);

}
