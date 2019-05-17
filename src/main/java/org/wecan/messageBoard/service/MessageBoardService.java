package org.wecan.messageBoard.service;

import org.wecan.messageBoard.model.Message;

import java.util.List;

public interface MessageBoardService {
    /**
     * 查找所有的留言
     *
     * @return 留言的集合
     */
    List<Message> findAllMessages();

    /**
     * 将留言组装成A型json
     *
     * @param messageList 留言的集合
     * @return json
     */
    String messagesToJson(List<Message> messageList);

    /**
     * 将留言组装成B型json
     *
     * @param messageList 留言的集合
     * @return json
     */
    String messagesToJson2(List<Message> messageList);

    /**
     * 插入一条留言
     *
     * @param message 留言
     * @return 成功与否
     */
    boolean insertMessage(Message message);

    /**
     * 删除一条留言
     *
     * @param id 留言id
     * @return 成功与否
     */
    boolean deleteMessage(int id);

    /**
     * 修改一条留言
     *
     * @param message 留言
     * @return 成功与否
     */
    boolean updateMessage(Message message);

    /**
     * 搜索特定内容的留言
     *
     * @param content 留言内容
     * @return 留言的集合
     */
    List<Message> findNeededMessages(String content);
}
