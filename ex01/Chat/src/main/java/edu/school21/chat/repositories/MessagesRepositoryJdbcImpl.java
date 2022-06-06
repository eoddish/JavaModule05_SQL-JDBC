package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.*;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


                //message.setRoom((Chatroom) rs.getObject("ROOM"));
            message.setDate(rs.getDate("DATE"));
            message.setText(rs.getString("TEXT"));
            opt = Optional.of(message);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        return opt;
    }
}
