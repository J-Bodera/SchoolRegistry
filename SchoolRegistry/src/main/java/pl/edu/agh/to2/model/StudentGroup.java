package pl.edu.agh.to2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    private int studentGroupId;

    @Column(name = Columns.NAME, nullable = false)
    private String name;

    @ManyToOne
    private Teacher tutor;

    @ManyToMany
    private Set<Course> courses = new HashSet();

    public StudentGroup(){}

    public StudentGroup(String name, Teacher tutor) {
        this.name = name;
        this.tutor = tutor;
    }

    public static class Columns {
        public static final String ID = "student_group_id";
        public static final String NAME = "student_group_name";
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(int studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTutor() {
        return tutor;
    }

    public void setTutor(Teacher tutor) {
        this.tutor = tutor;
    }
}
