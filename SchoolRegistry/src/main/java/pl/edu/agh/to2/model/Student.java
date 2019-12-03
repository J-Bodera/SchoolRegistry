package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends Person {

    @GeneratedValue
    @Column(name = Columns.STUDENT_ID)
    private int studentId;

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
        super();
        this.studentGroup = studentGroup;
        this.number = number;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setEmail(email);
        this.setPassword(password);
    }

    public static class Columns {
        public static final String STUDENT_ID = "student_id";
        public static final String NUMBER = "number";
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
}
