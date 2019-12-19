package pl.edu.agh.to2.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Student_group")
@Access(AccessType.PROPERTY)
public class StudentGroup {
    private IntegerProperty studentGroupId = new SimpleIntegerProperty();
    private StringProperty name;
    private SimpleObjectProperty<Teacher> tutor;
    private Set<Course> courses;

    public StudentGroup(){}

    public StudentGroup(String name, Teacher tutor) {
        this.name = new SimpleStringProperty(name);
        this.tutor = new SimpleObjectProperty<>(tutor);
    }

    public static class Columns {
        public static final String ID = "student_group_id";
        public static final String NAME = "student_group_name";
    }

    @Id
    @GeneratedValue
    @Column(name = Columns.ID)
    public int getStudentGroupId() {
        return studentGroupId.get();
    }

    public IntegerProperty studentGroupIdProperty() {
        return studentGroupId;
    }

    public void setStudentGroupId(int studentGroupId) {
        this.studentGroupId.set(studentGroupId);
    }

    @Column(name = Columns.NAME)
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @ManyToOne
    public Teacher getTutor() {
        return tutor.get();
    }

    public SimpleObjectProperty<Teacher> tutorProperty() {
        return tutor;
    }

    public void setTutor(Teacher tutor) {
        this.tutor.set(tutor);
    }

    @ManyToMany
    public Set<Course> getCourses() {
        return courses;
    }

    public SetProperty<Course> coursesProperty() {
        return new SimpleSetProperty<>(FXCollections.observableSet(courses));
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
