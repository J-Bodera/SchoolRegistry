package pl.edu.agh.to2.model;

import javafx.beans.property.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Attendance")
@Access(AccessType.PROPERTY)
public class Attendance {

    private IntegerProperty attendanceId = new SimpleIntegerProperty();
    private ObjectProperty<Date> date;
    private ObjectProperty<Course> course;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Student> student;
    private IntegerProperty attendance;

    public Attendance(){}


    public Attendance(Date date, Course course, Teacher teacher, Student student, int attendance) {
        this.date = new SimpleObjectProperty<>(date);
        this.course = new SimpleObjectProperty<>(course);
        this.teacher = new SimpleObjectProperty<>(teacher);
        this.student = new SimpleObjectProperty<>(student);
        this.attendance = new SimpleIntegerProperty(attendance);
    }

    /*public String getAttendanceType(){
        if(this.attendance.get().equals(AttendanceType.ABSENCE)){
            return "Nieobecność nieusprawiedliwiona";
        } else if (this.attendance.get().equals(AttendanceType.EXCUSED_ABSENCE)){
            return "Nieobecność usprawiedliwiona";
        } else {
            return "Obecność";
        }
    }*/

    public static class Columns {
        public static final String ATTENDANCE_ID = "attendance_id";
        public static final String DATE = "date";
        public static final String COURSE = "course";
        public static final String TEACHER = "teacher";
        public static final String STUDENT = "student";
        public static final String ATTENDANCE = "attendance";
    }

    @Id
    @GeneratedValue
    @Column(name = Columns.ATTENDANCE_ID)
    public int getAttendanceId() {
        return attendanceId.get();
    }

    public IntegerProperty attendanceIdProperty() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId.set(attendanceId);
    }

    @Column(name = Columns.DATE)
    public Date getDate() {
        return date.get();
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public StringProperty dateStringProperty() {
        return new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(date.get()));
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    @ManyToOne
    public Course getCourse() {
        return course.get();
    }

    public ObjectProperty<Course> courseProperty() {
        return course;
    }

    public StringProperty courseStringProperty() { return new SimpleStringProperty(course.get().getCourseName()); }

    public void setCourse(Course course) {
        this.course.set(course);
    }

    @ManyToOne
    public Teacher getTeacher() {
        return teacher.get();
    }

    public ObjectProperty<Teacher> teacherProperty() {
        return teacher;
    }

    public StringProperty teacherStringProperty() {
        return new SimpleStringProperty(teacher.get().getFirstName() + " " + teacher.get().getLastName());
    }

    public void setTeacher(Teacher teacher) {
        this.teacher.set(teacher);
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

    @Column(name = Columns.ATTENDANCE)
    public int getAttendance() {
        return attendance.get();
    }

    public IntegerProperty attendanceProperty() {
        return attendance;
    }

    public StringProperty attendanceStringProperty() {
        if(attendance.get() == 0){
            return new SimpleStringProperty("Obecność");
        }else if(attendance.get() == 1){
            return new SimpleStringProperty("Nieobecność usprawiedliwiona");
        }else{
            return new SimpleStringProperty("Nieobecność nieusprawiedliwiona");
        }
    }

    public void setAttendance(int attendance) {
        this.attendance.set(attendance);
    }

}
