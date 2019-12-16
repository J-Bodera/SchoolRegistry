package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    private int messageId;

    @ManyToOne
    private Teacher sender;

    @ManyToOne
    private StudentGroup receiver;

    @Column(name = Columns.TEXT, nullable = false)
    private String text;

    @Column(name = Columns.DATE)
    private Date date;


    public Message(){}

    public Message(Teacher sender, StudentGroup receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = new Date();
    }

    public Message(Teacher sender, StudentGroup receiver, String text, Date date){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = date;
    }

    public static class Columns {
        public static final String ID = "message_id";
        public static final String TEXT = "first_name";
        public static final String DATE = "last_name";
    }

    public int getMessage_id() {
        return messageId;
    }

    public void setMessage_id(int messageId) {
        this.messageId = messageId;
    }

    public Teacher getSender() {
        return sender;
    }

    public void setSender(Teacher sender) {
        this.sender = sender;
    }

    public StudentGroup getReceiver() {
        return receiver;
    }

    public void setReceiver(StudentGroup receiver) {
        this.receiver = receiver;
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
}