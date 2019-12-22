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

    public void update(int  remarkId, Student student, Teacher teacher, String text, Date date){
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Remark  set student_student_id = :student "
                + "WHERE  remark_id = :remarkId").setParameter("remarkId", remarkId).setParameter("student", student).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Remark  set teacher_teacher_id = :teacher "
                + "WHERE  remark_id = :remarkId").setParameter("remarkId", remarkId).setParameter("teacher", teacher).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Remark  set text = :text "
                + "WHERE  remark_id = :remarkId").setParameter("remarkId", remarkId).setParameter("text", text).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Remark  set date = :date "
                + "WHERE  remark_id = :remarkId").setParameter("remarkId", remarkId).setParameter("date", date).executeUpdate();
        SessionService.getEntityTransaction().begin();
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
