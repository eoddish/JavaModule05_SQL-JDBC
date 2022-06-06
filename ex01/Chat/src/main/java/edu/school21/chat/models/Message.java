package edu.school21.chat.models;

import java.util.Date;

public class Message {
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private Date date;

    public Message() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return (int)id;
    }

    public String toString() {
        String result = "";
        result += ("Message : {\n");
        result += ("id=" + id + ",\n");
        result += ("author=" + author);
        result += ("room=" + room);
        result += ("text=\"" + text + "\",\n");
        result += ("dateTime=" + date + "\n}");
        return result;
    }
}
