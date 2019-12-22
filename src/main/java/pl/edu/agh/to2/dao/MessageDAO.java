package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.*;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class MessageDAO extends GenericDAO<Message> {

    public boolean create(Teacher sender, StudentGroup receiver, String text, Date date) {
        try {
            save(new Message(sender, receiver, text, date));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int messageId, Teacher sender, StudentGroup receiver, String text, Date date){
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Message set sender_teacher_id = :sender "
                + "WHERE  message_id = :messageId").setParameter("messageId", messageId).setParameter("sender", sender).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Message set receiver_student_group_id = :receiver "
                + "WHERE  message_id = :messageId").setParameter("messageId", messageId).setParameter("receiver", receiver).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Message set text = :text "
                + "WHERE  message_id = :messageId").setParameter("messageId", messageId).setParameter("text", text).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Message set date = :date "
                + "WHERE  message_id = :messageId").setParameter("messageId", messageId).setParameter("date", date).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    public int delete(int messageId){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Message WHERE message_id = :messageId")
                .setParameter("messageId", messageId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<?> findAll(){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Message m");
        return query.list();
    }

    public List<?> findAllForStudentGroup(StudentGroup receiver){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Message m WHERE m.receiver = :receiver")
                .setParameter("receiver", receiver);
        return query.list();
    }

}
