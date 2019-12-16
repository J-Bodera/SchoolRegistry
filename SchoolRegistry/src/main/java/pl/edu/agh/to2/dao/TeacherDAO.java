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

        Teacher teacher = (Teacher) SessionService.getSession().createQuery("SELECT t FROM Teacher t WHERE t.teacherId = :id")
                .setParameter("id", teacherId).list().get(0);
        return teacher;
    }


}