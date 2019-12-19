package pl.edu.agh.to2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.*;

@Entity
@Table(name = "Course")
@Access(AccessType.PROPERTY)
public class Course {

    private IntegerProperty courseId = new SimpleIntegerProperty();
    private StringProperty courseName;

    public Course(){}

    public Course(String courseName){
        this.courseName = new SimpleStringProperty(courseName);
    }

    public static class Columns {
        public static final String COURSE_ID = "course_id";
        public static final String COURSE_NAME = "course_name";
    }

    @Id
    @GeneratedValue
    @Column(name = Columns.COURSE_ID)
    public int getCourseId() {
        return courseId.get();
    }

    public IntegerProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId.set(courseId);
    }

    @Column(name = Columns.COURSE_NAME)
    public String getCourseName() {
        return courseName.get();
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }
}
