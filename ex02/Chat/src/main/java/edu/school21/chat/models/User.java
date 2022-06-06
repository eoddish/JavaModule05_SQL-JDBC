package edu.school21.chat.models;

import java.util.List;

public class User {
    private Long userId;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> socializingRooms;

    public User() {
    }

    public User(Long userId, String login, String password, List<Chatroom> createdRooms, List<Chatroom> socializingRooms) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializingRooms = socializingRooms;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getSocializingRooms() {
        return socializingRooms;
    }

    public void setSocializingRooms(List<Chatroom> socializingRooms) {
        this.socializingRooms = socializingRooms;
    }

    public boolean equals(Chatroom other) {
        return (this.userId == other.getId());
    }

    public int hashCode() {
        return userId.intValue();
    }

    public String toString() {
        String result = "";
        result += "{id=" + userId + ",login=\"" + login + "\",password=\"" + password + "\",createdRooms=" + createdRooms + ",rooms=" + socializingRooms + "}\n";
        return result;
    }
}
