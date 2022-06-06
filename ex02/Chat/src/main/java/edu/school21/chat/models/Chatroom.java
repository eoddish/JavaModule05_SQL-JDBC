package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> chatroomMessages;

    public Chatroom() {
    }

    public Chatroom(Long id, String name, User owner, List<Message> chatroomMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.chatroomMessages = chatroomMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return id.intValue();
    }

    public String toString() {
        return "{id=" + id  + ",name=\"" + name +"\",creator=" + owner +",messages=" + chatroomMessages + "}\n";
    }
}
