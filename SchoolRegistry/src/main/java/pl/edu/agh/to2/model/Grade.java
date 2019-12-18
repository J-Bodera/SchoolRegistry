package pl.edu.agh.to2.model;

import javafx.beans.property.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Grade")
@Access(AccessType.PROPERTY)
public class Grade {

    private IntegerProperty gradeId = new SimpleIntegerProperty();
    private IntegerProperty grade;
    private ObjectProperty<Student> student;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Course> course;
    private StringProperty comment;
    private ObjectProperty<Date> date;

    public Grade(){}

    public Grade(int grade, Student student, Teacher teacher, Course course, String comment, Date date){
        this.grade = new SimpleIntegerProperty(grade);
        this.student = new SimpleObjectProperty<>(student);
        this.teacher = new SimpleObjectProperty<>(teacher);
        this.course = new SimpleObjectProperty<>(course);
        this.comment = new SimpleStringProperty(comment);
        this.date = new SimpleObjectProperty<>(date);
    }

    public static class Columns {
        public static final String GRADE_ID = "grade_id";
        public static final String GRADE = "grade";
        public static final String COMMENT = "comment";
        public static final String DATE = "date";
    }

    @Id
    @GeneratedValue
    @Column(name = Columns.GRADE_ID)
    public int getGradeId() {
        return gradeId.get();
    }

    public IntegerProperty gradeIdProperty() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId.set(gradeId);
    }

    @Column(name = Columns.GRADE)
    public int getGrade() {
        return grade.get();
    }

    public IntegerProperty gradeProperty() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    @ManyToOne
    public Student getStudent() {
        return student.get();
    }

    public ObjectProperty<Student> studentProperty() {
        return student;
    }

    public void setStudent(Student student) {
        this.student.set(student);
    }

    @ManyToOne
    public Teacher getTeacher() {
        return teacher.get();
    }

    public ObjectProperty<Teacher> teacherProperty() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher.set(teacher);
    }

    @ManyToOne
    public Course getCourse() {
        return course.get();
    }

    public ObjectProperty<Course> courseProperty() {
        return course;
    }

    public void setCourse(Course course) {
        this.course.set(course);
    }

    @Column(name = Columns.COMMENT)
    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
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
