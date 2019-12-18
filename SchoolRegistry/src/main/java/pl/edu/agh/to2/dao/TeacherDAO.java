package pl.edu.agh.to2.dao;

import org.hibernate.Query;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

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

    public void update(int teacherId, String firstName, String lastName, String phone, String email, String password){
        SessionService.getSession().createQuery("UPDATE Teacher t set t.firstName = :firstName "
                + "WHERE t.teacherId = :teacherId").setParameter("teacherId", teacherId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.lastName = :lastName "
                + "WHERE t.teacherId = :teacherId").setParameter("teacherId", teacherId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.phone = :phone "
                + "WHERE t.teacherId = :teacherId").setParameter("teacherId", teacherId).setParameter("phone", phone).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.email = :email "
                + "WHERE t.teacherId = :teacherId").setParameter("teacherId", teacherId).setParameter("email", email).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.password = :password "
                + "WHERE t.teacherId = :teacherId").setParameter("teacherId", teacherId).setParameter("password", password).executeUpdate();
    }

    public int delete(int id){
        Query query = SessionService.getSession().createQuery("DELETE FROM Teacher t WHERE t.teacherId = :id")
                .setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return result;
    }

    public List<Teacher> findAll(){
        Query query = SessionService.getSession().createQuery("FROM Teacher t");
        return query.getResultList();
    }

    public Teacher findByTeacherId(int teacherId){

        Teacher teacher = (Teacher) SessionService.getSession().createQuery("SELECT t FROM Teacher t WHERE t.teacherId = :id")
                .setParameter("id", teacherId).list().get(0);
        return teacher;
    }

    public Teacher findByTeacherName(String firstName, String lastName){

        Teacher teacher = (Teacher) SessionService.getSession().createQuery("SELECT t FROM Teacher t WHERE t.firstName = :firstName AND t.lastName = :lastName")
                .setParameter("firstName", firstName).setParameter("lastName", lastName).list().get(0);
        return teacher;
    }


}
