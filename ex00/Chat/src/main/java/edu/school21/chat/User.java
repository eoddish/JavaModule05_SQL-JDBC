package edu.school21.chat;

import java.util.*;

public class User {
    private int userId;
    private int login;
    private int password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> socializingRooms;

    public User(int userId, int login, int password, List<Chatroom> createdRooms, List<Chatroom> socializingRooms) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializingRooms = socializingRooms;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
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
        return userId;
    }

    public String toString() {
        return "id: " + userId +  ", login: " + login + ", password: " + password;
    }
}
