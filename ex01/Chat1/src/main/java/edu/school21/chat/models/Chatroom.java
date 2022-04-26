package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private long id;
    private String name;
    private User owner;
    private List<Message> chatroomMessages;

    public Chatroom() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
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
        return (int)id;
    }

    public String toString() {
        return "{id=" + id  + ",name=\"" + name +"\",creator=" + owner +",messages=" + chatroomMessages + "}\n";
    }
}
