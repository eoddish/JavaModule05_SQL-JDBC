package edu.school21.chat.models;

import java.sql.Timestamp;
import java.time.*;
import java.util.Optional;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime date;

    public Message() {

    }

    public Message(Long id, User author, Chatroom room, String text, LocalDateTime date) {

        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date.toLocalDateTime();
    }
    public boolean equals(Chatroom other) {
        return (this.id == other.getId());
    }

    public int hashCode() {
        return id.intValue();
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
