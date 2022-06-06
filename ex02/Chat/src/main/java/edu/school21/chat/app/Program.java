package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

            String sql = readFile("ex02/Chat/target/classes/schema.sql");
            statement.executeUpdate(sql);
            sql = readFile("ex02/Chat/target/classes/data.sql");
            statement.executeUpdate(sql);

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(DB_URL);
            config.setUsername(USER);
            config.setPassword(PASS);

            User creator = new User(1L, "Alice", "hello", new ArrayList(), new ArrayList());
            User author = creator;
            Chatroom room = new Chatroom(1L, "Java", creator, new ArrayList());
            Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
            DataSource dataSource = new HikariDataSource( config );
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
            messagesRepository.save(message);
            System.out.println(message.getId());

            creator = new User(7L, "user", "user", new ArrayList(), new ArrayList());
            author = creator;
            room = new Chatroom(8L, "room", creator, new ArrayList());
            message = new Message(null, author, room, "Hello!", LocalDateTime.now());
            messagesRepository.save(message);
            System.out.println(message.getId());

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
