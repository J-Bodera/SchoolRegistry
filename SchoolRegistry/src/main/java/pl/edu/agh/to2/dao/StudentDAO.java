package pl.edu.agh.to2.dao;

import pl.edu.agh.to2.model.Grade;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.HashSet;
import java.util.Set;

public class StudentDAO extends GenericDAO<Student> {

    public boolean create(String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup, int number) {
        try {
            save(new Student(firstName, lastName, phone, email, password, studentGroup, number));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student findByStudentId(int studentId){
        Student student = (Student) SessionService.getSession().createQuery("SELECT s FROM Student s WHERE s.studentId = :id")
                .setParameter("id", studentId).list().get(0);
        return student;
    }

}