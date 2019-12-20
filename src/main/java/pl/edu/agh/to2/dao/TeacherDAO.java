package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;
import javax.persistence.PersistenceException;
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
                + "WHERE t.id = :teacherId").setParameter("teacherId", teacherId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.lastName = :lastName "
                + "WHERE t.id = :teacherId").setParameter("teacherId", teacherId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.phone = :phone "
                + "WHERE t.id = :teacherId").setParameter("teacherId", teacherId).setParameter("phone", phone).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.email = :email "
                + "WHERE t.id = :teacherId").setParameter("teacherId", teacherId).setParameter("email", email).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Teacher t set t.password = :password "
                + "WHERE t.id = :teacherId").setParameter("teacherId", teacherId).setParameter("password", password).executeUpdate();
    }

    public int delete(int id){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Teacher WHERE teacher_id = :id")
                .setParameter("id", id);

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;

    }

    public List<?> findAll(){
        NativeQuery<?>  query = SessionService.getSession().createNativeQuery("FROM Teacher t");
        return query.list();
    }

    public Teacher findByTeacherId(int teacherId){

        return (Teacher) SessionService.getSession().createQuery("SELECT t FROM Teacher t WHERE t.id = :id")
                .setParameter("id", teacherId).list().get(0);
    }

    public Teacher findByTeacherName(String firstName, String lastName){

        return (Teacher) SessionService.getSession().createQuery("SELECT t FROM Teacher t WHERE t.firstName = :firstName AND t.lastName = :lastName")
                .setParameter("firstName", firstName).setParameter("lastName", lastName).list().get(0);
    }


}
