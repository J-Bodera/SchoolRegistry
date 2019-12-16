package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = Columns.STUDENT_ID)
    private int studentId;

    @Column(name = Columns.FIRST_NAME, nullable = false, length = 40)
    private String firstName;

    @Column(name = Columns.LAST_NAME, nullable = false, length = 40)
    private String lastName;

    @Column(name = Columns.PHONE, length = 9)
    private String phone;

    @Column(name = Columns.EMAIL, nullable = false, length = 40)
    private String email;

    @Column(name = Columns.PASSWORD, nullable = false, length = 20)
    private String password;

    @ManyToOne
    private StudentGroup studentGroup;

    @Column(name = Columns.NUMBER)
    private int number;

    @OneToMany(mappedBy = "student")
    private Set<Grade> grades = new HashSet();

    @OneToMany(mappedBy = "student")
    private Set<Remark> remarks = new HashSet();

    public Student(){}

    public Student(String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup, int number){
        this.studentGroup = studentGroup;
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Set<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(Set<Remark> remarks) {
        this.remarks = remarks;
    }
}