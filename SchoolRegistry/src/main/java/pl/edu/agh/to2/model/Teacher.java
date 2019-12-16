package pl.edu.agh.to2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
public class Teacher {

    private IntegerProperty teacherId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public static class Columns {
        public static final String TEACHER_ID = "teacher_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    public int getTeacherId()
    {
        return teacherId.get();
    }

    public void setTeacherId(int teacherId)
    {
        this.teacherId.set(teacherId);
    }

    public String getFirstName()
    {
        return firstName.get();
    }

    public StringProperty getFirstNameProperty()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }

    public String getLastName()
    {
        return lastName.get();
    }

    public StringProperty getLastNameProperty()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }

    public String getPhone()
    {
        return phone.get();
    }

    public StringProperty getPhoneProperty()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone.set(phone);
    }

    public String getEmail()
    {
        return email.get();
    }

    public StringProperty getEmailProperty()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email.set(email);
    }

    public String getPassword()
    {
        return password.get();
    }

    public StringProperty getPasswordProperty()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password.set(password);
    }
}