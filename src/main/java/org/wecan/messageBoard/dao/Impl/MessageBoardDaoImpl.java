package org.wecan.messageBoard.dao.Impl;

import org.wecan.messageBoard.dao.JDBCUtil;
import org.wecan.messageBoard.dao.MessageBoardDao;
import org.wecan.messageBoard.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageBoardDaoImpl implements MessageBoardDao {
    private static MessageBoardDao instance = null;

    public static MessageBoardDao getInstance() {
        if (instance == null) {
            synchronized (MessageBoardDao.class) {
                if (instance == null) {
                    instance = new MessageBoardDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Message> findMessagesByPid(int pid) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM message_board WHERE pid = ?";
        List<Message> list = new ArrayList<Message>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setPid(rs.getInt("pid"));
                message.setText(rs.getString("text"));
                message.setUsername(rs.getString("username"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, con);
        }
        return list;
    }

    @Override
    public void insertMessage(Message message) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO message_board(username,text,pid) VALUE(?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, message.getUsername());
            pstmt.setString(2, message.getText());
            pstmt.setInt(3, message.getPid());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, pstmt, con);
        }
    }

    @Override
    public void deleteMessage(int id) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM message_board WHERE id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, pstmt, con);
        }
    }

    @Override
    public void updateMessage(Message message) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "UPDATE message_board SET text = ? WHERE id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,message.getText());
            pstmt.setInt(2, message.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, pstmt, con);
        }
    }

    @Override
    public List<Message> findMessagesByContent(String content) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql = "SELECT * FROM message_board WHERE text LIKE ?";
        List<Message> list = new ArrayList<Message>();
        String str = "%" + content + "%";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, str);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setPid(rs.getInt("pid"));
                message.setText(rs.getString("text"));
                message.setUsername(rs.getString("username"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(rs, pstmt, con);
        }
        return list;
    }

    @Override
    public boolean checkId(int id) {
        Connection con = JDBCUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql = "SELECT * FROM message_board WHERE id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            //查的到, 返回true ; 查不到, 返回false
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JDBCUtil.close(rs, pstmt, con);
        }
    }
}
