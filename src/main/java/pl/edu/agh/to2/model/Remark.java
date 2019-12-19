package pl.edu.agh.to2.model;

import javafx.beans.property.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Remark")
@Access(AccessType.PROPERTY)
public class Remark {

    private IntegerProperty remarkId = new SimpleIntegerProperty();
    private ObjectProperty<Student> student;
    private ObjectProperty<Teacher> teacher;
    private StringProperty text;
    private ObjectProperty<Date> date;

    public Remark(){}

    public Remark(Student student, Teacher teacher, String text, Date date){
        this.student = new SimpleObjectProperty<>(student);
        this.teacher = new SimpleObjectProperty<>(teacher);
        this.text = new SimpleStringProperty(text);
        this.date = new SimpleObjectProperty<>(date);
    }

    public static class Columns {
        public static final String ID = "remark_id";
        public static final String TEXT = "text";
        public static final String DATE = "date";
    }


    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    public int getRemarkId() {
        return remarkId.get();
    }

    public IntegerProperty remarkIdProperty() {
        return remarkId;
    }

    public void setRemarkId(int remarkId) {
        this.remarkId.set(remarkId);
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

    @Column(name = Columns.TEXT)
    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
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
