package edu.school21.chat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Program {

    static final String DB_URL = "jdbc:postgresql://localhost/postgres";;
    static final String USER = "eoddish";
    static final String PASS = "";


    private static String readFile(String fileName) {

        String result = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + '\n';
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    private static void postgres() {

        try {
            String sql = readFile("target/classes/schema.sql");
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);
            //sql = readFile("../resources/data.sql");
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        postgres();
        System.out.println("Done");
    }
}
