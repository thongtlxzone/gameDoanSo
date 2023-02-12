package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig {
    private static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/db_gameDoanSo";
    private static String USER_NAME = "root";
    private static String PASSWORD = "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            // Dang ky su dung driver cho database MYSQL
            Class.forName(DRIVER_NAME);
            // Mo ket noi toi CSDL theo driver da chi dinh
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (Exception e){
            System.out.println("Loi ket noi toi csdl: " + e.getMessage());
        }

        return connection;
    }
}
