package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {


    public static Connection connection;
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama_case_study?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12345678";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
