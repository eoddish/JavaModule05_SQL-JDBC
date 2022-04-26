package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private int id;
    private int name;
    private int owner;
    private List<Message> chatroomMessages;

    public Chatroom(int id, int name, int owner, List<Message> chatroomMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.chatroomMessages = chatroomMessages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public List<Message> getChatroomMessages() {
        return chatroomMessages;
    }

    public void setChatroomMessages(List<Message> chatroomMessages) {
        this.chatroomMessages = chatroomMessages;
    }

    public boolean equals(Chatroom other) {
        return (this.id == other.getId());
    }

    public int hashCode() {
        return id;
    }

    public String toString() {
        return "id : " + id + ", name: " + name + ", owner: " + owner;
    }
}
