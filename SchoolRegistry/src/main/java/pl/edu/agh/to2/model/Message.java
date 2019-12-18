package pl.edu.agh.to2.model;

import javafx.beans.property.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Message")
@Access(AccessType.PROPERTY)
public class Message {

    private IntegerProperty messageId = new SimpleIntegerProperty();
    private ObjectProperty<Teacher> sender;
    private ObjectProperty<StudentGroup> receiver;
    private StringProperty text;
    private ObjectProperty<Date> date;


    public Message(){}

    public Message(Teacher sender, StudentGroup receiver, String text, Date date){
        this.sender = new SimpleObjectProperty<>(sender);
        this.receiver = new SimpleObjectProperty<>(receiver);
        this.text = new SimpleStringProperty(text);
        this.date = new SimpleObjectProperty<>(date);
    }

    public static class Columns {
        public static final String ID = "message_id";
        public static final String TEXT = "text";
        public static final String DATE = "date";
    }

    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    public int getMessageId() {
        return messageId.get();
    }

    public IntegerProperty messageIdProperty() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId.set(messageId);
    }

    @ManyToOne
    public Teacher getSender() {
        return sender.get();
    }

    public ObjectProperty<Teacher> senderProperty() {
        return sender;
    }

    public void setSender(Teacher sender) {
        this.sender.set(sender);
    }

    @ManyToOne
    public StudentGroup getReceiver() {
        return receiver.get();
    }

    public ObjectProperty<StudentGroup> receiverProperty() {
        return receiver;
    }

    public void setReceiver(StudentGroup receiver) {
        this.receiver.set(receiver);
    }

    @Column(name = Columns.TEXT)
    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    @Column(name = Columns.DATE)
    public Date getDate() {
        return date.get();
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }
}