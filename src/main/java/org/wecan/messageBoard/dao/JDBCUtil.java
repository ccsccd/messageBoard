package org.wecan.messageBoard.dao;

import java.sql.*;

public class JDBCUtil {
    static {
        try {
            String diverName = "com.mysql.jdbc.Driver";
            Class.forName(diverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/message_board"
                            + "? serverTimezone=GMT%2B8" +
                            "?useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true",
                    "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs, Statement stmt, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

