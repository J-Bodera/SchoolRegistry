package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.*;
import pl.edu.agh.to2.session.SessionService;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class RemarkDAO extends GenericDAO<Remark> {

    public boolean create(Student student, Teacher teacher, String text, Date date) {
        try {
            save(new Remark(student, teacher, text, date));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int remarkId, Student student, Teacher teacher, String text, Date date){
        SessionService.getSession().createQuery("UPDATE Remark r set r.student = :student "
                + "WHERE r.remarkId = :remarkId").setParameter("remarkId", remarkId).setParameter("student", student).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Remark r set r.teacher = :teacher "
                + "WHERE r.remarkId = :remarkId").setParameter("remarkId", remarkId).setParameter("teacher", teacher).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Remark r set r.text = :text "
                + "WHERE r.remarkId = :remarkId").setParameter("remarkId", remarkId).setParameter("text", text).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Remark r set r.date = :date "
                + "WHERE r.remarkId = :remarkId").setParameter("remarkId", remarkId).setParameter("date", date).executeUpdate();
    }

    public int delete(int remarkId){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Remark WHERE remark_id = :remarkId")
                .setParameter("remarkId", remarkId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<?> findAll(){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Remark r");
        return query.list();
    }

    public List<?> findAllForStudent(Student student){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Remark r WHERE r.student = :student")
                .setParameter("student", student);
        return query.list();
    }

}
