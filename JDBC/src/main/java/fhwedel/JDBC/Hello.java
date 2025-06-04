package fhwedel.JDBC;

import java.sql.Connection;
import java.sql.*;


public class Hello {
    public static void main(String[] args) {
        System.out.println("Maxi du kleiner!");

        selectStatement();

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/firma",
                "root", "password");

        return conn;
    }

    public static void selectStatement() {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM personal";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Personalnummer: " + rs.getInt("pnr") + ", Name: " + rs.getString("name") + ", Vorname: " + rs.getString("vorname") + ", GH_Stufe: " + rs.getString("geh_stufe") +
                 ", Abteilungsnummer" + rs.getString("abt_nr") + ", Krankenkasse: " + rs.getString("krankenkasse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}