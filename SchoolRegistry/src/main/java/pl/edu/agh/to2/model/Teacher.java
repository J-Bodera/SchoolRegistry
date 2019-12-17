package pl.edu.agh.to2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Table(name="Teacher")
@Access(AccessType.PROPERTY)
public class Teacher {

    private IntegerProperty teacher_id = new SimpleIntegerProperty();
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String phone, String email, String password)
    {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public static class Columns
    {
        public static final String TEACHER_ID = "teacher_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="teacherId")
    public int getId(){
        return teacher_id.get();
    }

    public IntegerProperty idProperty()
    {
        return teacher_id;
    }

    public void setId(int id)
    {
        this.teacher_id.set(id);
    }

    @Column(name="firstName")
    public String getFirstName()
    {
        return firstName.get();
    }

    public StringProperty firstNameProperty()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }

    @Column(name="lastName")
    public String getLastName()
    {
        return lastName.get();
    }

    public StringProperty lastNameProperty()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }

    @Column(name="phone")
    public String getPhone()
    {
        return phone.get();
    }

    public StringProperty phoneProperty()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone.set(phone);
    }

    @Column(name="email")
    public final String getEmail()
    {
        return email.get();
    }

    public StringProperty emailProperty()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email.set(email);
    }

    @Column(name="password")
    public String getPassword()
    {
        return password.get();
    }

    public StringProperty passwordProperty()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password.set(password);
    }
}