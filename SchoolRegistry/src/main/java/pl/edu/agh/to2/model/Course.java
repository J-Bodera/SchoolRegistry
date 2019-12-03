package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(name = Columns.COURSE_ID)
    private int courseId;

    @Column(name = Columns.COURSE_NAME, nullable = false, length = 40)
    private String courseName;


    public Course(){}

    public Course(String courseName){
        this.courseName = courseName;
    }

    public static class Columns {
        public static final String COURSE_ID = "course_id";
        public static final String COURSE_NAME = "course_name";
    }

    public int getCourseId() { return courseId; }

    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
