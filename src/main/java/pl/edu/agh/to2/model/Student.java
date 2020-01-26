package pl.edu.agh.to2.model;

import javafx.beans.property.*;
import javax.persistence.*;

@Entity
@Table(name="Student")
@Access(AccessType.PROPERTY)
public class Student {

    private IntegerProperty studentId = new SimpleIntegerProperty();
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;
    private Property<StudentGroup> studentGroup;
//    private IntegerProperty number;

    public Student() {
    }

    public Student(String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup) {
        this.studentGroup = new SimpleObjectProperty<>(studentGroup);
//        this.number = new SimpleIntegerProperty(number);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public Student(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.studentGroup = new SimpleObjectProperty<>();
    }

    public static class Columns {
        public static final String STUDENT_ID = "student_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String NUMBER = "number";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Columns.STUDENT_ID)
    public int getStudentId() {
        return studentId.get();
    }

    public IntegerProperty studentIdProperty() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId.set(id);
    }

    @Column(name = Columns.FIRST_NAME)
    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @Column(name = Columns.LAST_NAME)
    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @Column(name = Columns.PHONE)
    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Column(name = Columns.EMAIL)
    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Column(name = Columns.PASSWORD)
    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @ManyToOne
    public StudentGroup getStudentGroup() {
        return studentGroup.getValue();
    }

    public Property<StudentGroup> studentGroupProperty() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup.setValue(studentGroup);
    }

//    @Column(name = Columns.NUMBER)
//    public int getNumber() {
//        return number.get();
//    }
//
//    public IntegerProperty numberProperty() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number.set(number);
//    }

    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}