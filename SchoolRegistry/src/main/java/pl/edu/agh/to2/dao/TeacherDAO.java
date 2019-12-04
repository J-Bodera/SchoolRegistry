package pl.edu.agh.to2.dao;

import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Date;

public class TeacherDAO extends GenericDAO<Teacher> {

    public boolean create(String firstName, String lastName, String phone, String email, String password) {
        try {
            save(new Teacher(firstName, lastName, phone, email, password));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Teacher findByTeacherId(int teacherId){
        EntityManager em = SessionService.getEntityManager();
        EntityTransaction etx = SessionService.getEntityTransaction();
        etx.begin();
        Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.teacherId = :id", Teacher.class)
                .setParameter("id", teacherId).getSingleResult();
        etx.commit();
        return teacher;
    }

    public Teacher findByName(String firstName, String lastName){
        EntityManager em = SessionService.getEntityManager();
        EntityTransaction etx = SessionService.getEntityTransaction();
        etx.begin();
        Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.lastName = :lastName and t.firstName = :firstName", Teacher.class)
                .setParameter("lastName", lastName).setParameter("firstName", firstName).getSingleResult();
        etx.commit();
        return teacher;
    }


}
