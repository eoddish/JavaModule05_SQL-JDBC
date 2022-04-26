package edu.school21.chat.models;

import java.util.Date;

public class Message {
    private int id;
    private User author;
    private Chatroom room;
    private String text;
    private Date date;

    public Message(int id, User author, Chatroom room, String text, Date date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public boolean equals(Chatroom other) {
        return (this.id == other.getId());
    }

    public int hashCode() {
        return id;
    }

    public String toString() {
        return "id: " + id + "date: " + date + ", author: " + author.getLogin() + ", room: " + room.getName() + ", text: " + text;
    }
}
