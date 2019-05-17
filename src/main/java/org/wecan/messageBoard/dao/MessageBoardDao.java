package org.wecan.messageBoard.dao;

import org.wecan.messageBoard.model.Message;

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
}
