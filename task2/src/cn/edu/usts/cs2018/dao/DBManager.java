package cn.edu.usts.cs2018.dao;

import java.sql.*;

public class DBManager {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 获得连接, 三个参数分别为：url，用户名，密码
        return DriverManager.getConnection("jdbc:mysql://localhost/javaee?useSSL=false&serverTimezone=GMT%2B8", "root", "12345678");
    }

    // 先打开，后关闭
    public static void closeAll(Connection connection, PreparedStatement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 先打开，后关闭
    public static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection, statement);
        }
    }

}

