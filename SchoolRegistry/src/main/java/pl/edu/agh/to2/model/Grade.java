package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    @Column(name = Columns.GRADE_ID)
    private int gradeId;

    @Column(name = Columns.GRADE, nullable = false)
    private int grade;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Course course;

    @Column(name = Columns.COMMENT, length = 100)
    private String comment;

    @Column(name = Columns.DATE)
    private Date date;

    public Grade(){}

    public Grade(int grade, Student student, Teacher teacher, Course course, String comment){
        this.grade = grade;
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.comment = comment;
        this.date = new Date();
    }

    public Grade(int grade, Student student, Teacher teacher, Course course, String comment, Date date){
        this.grade = grade;
        this.student = student;
        this.teacher = teacher;
        this.course = course;
        this.comment = comment;
        this.date = date;
    }

    public static class Columns {
        public static final String GRADE_ID = "grade_id";
        public static final String GRADE = "grade";
        public static final String COMMENT = "comment";
        public static final String DATE = "date";
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int grade_id) {
        this.gradeId = grade_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
