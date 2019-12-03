package pl.edu.agh.to2.dao;

import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.model.Grade;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;

import javax.persistence.PersistenceException;

public class GradeDAO extends GenericDAO<Grade> {

    public boolean create(int grade, Student student, Teacher teacher, Course course, String comment) {
        try {
            save(new Grade(grade, student, teacher,  course, comment));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

}
