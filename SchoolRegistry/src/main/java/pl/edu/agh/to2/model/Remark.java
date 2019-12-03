package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Remark {
    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    private int remarkId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;

    @Column(name = Columns.TEXT, nullable = false, length = 100)
    private String text;

    @Column(name = Columns.DATE)
    private Date date;

    public Remark(){}

    public Remark(Student student, Teacher teacher, String text){
        this.student = student;
        this.teacher = teacher;
        this.text = text;
        this.date = new Date();
    }

    public Remark(Student student, Teacher teacher, String text, Date date){
        this.student = student;
        this.teacher = teacher;
        this.text = text;
        this.date = date;
    }

    public static class Columns {
        public static final String ID = "remark_id";
        public static final String TEXT = "text";
        public static final String DATE = "date";
    }

    public int getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(int remarkId) {
        this.remarkId = remarkId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
