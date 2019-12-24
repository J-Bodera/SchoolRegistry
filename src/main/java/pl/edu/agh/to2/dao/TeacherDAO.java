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

    public boolean create(Teacher teacher) {
        try {
            save(teacher);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int teacherId, String firstName, String lastName, String phone, String email, String password){
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set first_name = :firstName "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set last_name = :lastName "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set phone = :phone "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("phone", phone).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set email = :email "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("email", email).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set password = :password "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("password", password).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    public void update(Teacher teacher){
        SessionService.getEntityTransaction().begin();

        int teacherId = teacher.getTeacherId();
        String firstName = teacher.getFirstName();
        String lastName = teacher.getLastName();
        String phone = teacher.getPhone();
        String email = teacher.getEmail();
        String password = teacher.getPassword();

        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set first_name = :firstName "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set last_name = :lastName "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set phone = :phone "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("phone", phone).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set email = :email "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("email", email).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Teacher set password = :password "
                + "WHERE teacher_id = :teacherId").setParameter("teacherId", teacherId).setParameter("password", password).executeUpdate();
        SessionService.getEntityTransaction().commit();
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

    public List<Teacher> findAll(){
        return (List<Teacher>) SessionService.getSession().createQuery("SELECT t FROM Teacher t")
                .list();
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
