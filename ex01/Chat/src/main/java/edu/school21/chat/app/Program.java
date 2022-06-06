package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.Scanner;

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
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();

            String sql = readFile("ex01/Chat/target/classes/schema.sql");
            statement.executeUpdate(sql);
            sql = readFile("ex01/Chat/target/classes/data.sql");
            statement.executeUpdate(sql);

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(DB_URL);
            config.setUsername(USER);
            config.setPassword(PASS);
            DataSource dataSource = new HikariDataSource( config );
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a message ID");
            long id = 0;
            id = scanner.nextLong();
            scanner.close();

            Optional<Message> message = messagesRepository.findById(id);
            if (message.isPresent()) {
                System.out.println(message.get().toString());
            } else {
                System.out.println("Error: No such message!");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        postgres();
    }
}
