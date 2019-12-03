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
        EntityManager em = SessionService.getEntityManager();
        EntityTransaction etx = SessionService.getEntityTransaction();
        etx.begin();
        Student student = em.createQuery("SELECT s FROM Student s WHERE s.studentId = :id", Student.class)
                .setParameter("id", studentId).getSingleResult();
        etx.commit();
        return student;
    }

}
