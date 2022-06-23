package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCUntil {

    public static Connection getConnection() {
        Connection c = null;

        try {
            //Đăng ký MySQL Driver với DriverManager
            //B1: Đăng ký MySQL Driver với Driver Manager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //B2: Các thông số
            String URL = "jdbc:mySQL://localhost:3306/ManageStudent";
            String user = "root";
            String password = "";

            //B3: Tạo kêt nối
            c = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtd = c.getMetaData();
                System.out.println(mtd.getDatabaseProductName());
                System.out.println(mtd.getDatabaseProductVersion());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
