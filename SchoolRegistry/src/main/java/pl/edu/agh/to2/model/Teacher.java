package pl.edu.agh.to2.model;

import pl.edu.agh.to2.model.Person;

import javax.persistence.*;

@Entity
public class Teacher extends Person {

    @GeneratedValue
    @Column(name = Columns.TEACHER_ID)
    private int teacherId;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String phone, String email, String password) {
        super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setEmail(email);
        this.setPassword(password);
    }

    public static class Columns {
        public static final String TEACHER_ID = "teacher_id";
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int teacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
