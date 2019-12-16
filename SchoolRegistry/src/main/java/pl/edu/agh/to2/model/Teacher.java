package pl.edu.agh.to2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = Columns.TEACHER_ID)
    private int teacherId;

    @Column(name = Student.Columns.FIRST_NAME, nullable = false, length = 40)
    private String firstName;

    @Column(name = Student.Columns.LAST_NAME, nullable = false, length = 40)
    private String lastName;

    @Column(name = Student.Columns.PHONE, length = 9)
    private String phone;

    @Column(name = Student.Columns.EMAIL, nullable = false, length = 40)
    private String email;

    @Column(name = Student.Columns.PASSWORD, nullable = false, length = 20)
    private String password;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public static class Columns {
        public static final String TEACHER_ID = "teacher_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}