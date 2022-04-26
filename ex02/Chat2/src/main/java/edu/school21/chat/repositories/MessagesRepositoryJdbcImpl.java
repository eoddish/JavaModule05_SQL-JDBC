package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.*;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    DataSource dataSource;
    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<Message> findById(Long id) {
        String SQL_QUERY = "select * from messages where ID=" + id;
        Optional<Message> opt = Optional.empty();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);
        ResultSet rs = preparedStatement.executeQuery();) {
            Message message;
            while (rs.next()) {
            message = new Message();
            message.setId(rs.getLong("ID"));

            SQL_QUERY = "select * from users where ID=" + rs.getLong("AUTHOR");
                try (Connection connectionUsers = dataSource.getConnection();
                     PreparedStatement preparedStatementUsers = connection.prepareStatement(SQL_QUERY);
                     ResultSet rsu = preparedStatementUsers.executeQuery();) {
                     while (rsu.next()) {
                         User user = new User();
                         user.setUserId(rsu.getLong("ID"));
                         user.setPassword(rsu.getString("PASSWORD"));
                         user.setLogin(rsu.getString("LOGIN"));
                         message.setAuthor(user);
                     }
                } catch (Exception e) {
                    System.out.println(e);
                }
                SQL_QUERY = "select * from chatrooms where ID=" + rs.getLong("ROOM");
                try (Connection connectionUsers = dataSource.getConnection();
                     PreparedStatement preparedStatementUsers = connection.prepareStatement(SQL_QUERY);
                     ResultSet rsu = preparedStatementUsers.executeQuery();) {
                    while (rsu.next()) {
                        Chatroom room = new Chatroom();
                        room.setId(rsu.getLong("ID"));
                        room.setName(rsu.getString("NAME"));
                        //room.set(rsu.getString("LOGIN"));
                        message.setRoom(room);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }


            message.setDate(rs.getTimestamp("DATE"));
            message.setText(rs.getString("TEXT"));
            opt = Optional.of(message);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        return opt;
    }

    public void save(Message message) {

        class NotSavedSubEntityException extends RuntimeException {
                public NotSavedSubEntityException(String errorMessage) {
                    super(errorMessage);
                }
        }

        String DB_URL = "jdbc:postgresql://localhost/postgres";;
        String USER = "eoddish";
        String PASS = "";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String text = message.getText();
            String sql = "INSERT INTO MESSAGES(AUTHOR, ROOM, TEXT) VALUES((SELECT ID FROM USERS WHERE ID='" + message.getAuthor().getUserId() + "'), (SELECT ID FROM CHATROOMS WHERE ID='" + message.getRoom().getId() + "'), '" + text + "') RETURNING ID;";
            try {
                ResultSet rs = statement.executeQuery(sql);
                rs.next();
                message.setId(rs.getLong(1));
            } catch (Exception e) {
                throw new NotSavedSubEntityException("Error: No saved subentity!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
