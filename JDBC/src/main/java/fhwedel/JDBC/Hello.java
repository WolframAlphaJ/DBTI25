package fhwedel.JDBC;

import java.sql.Connection;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Maxi du kleiner!");
    }

    public Connection getConnection() {
        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/firma",
                "root", "password");

        return conn;
    }
}