package pl.edu.agh.to2.dao;


import org.hibernate.Query;
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
        SessionService.getSession().createQuery("UPDATE Message m set m.sender = :sender "
                + "WHERE m.messageId = :messageId").setParameter("messageId", messageId).setParameter("sender", sender).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Message m set m.receiver = :receiver "
                + "WHERE m.messageId = :messageId").setParameter("messageId", messageId).setParameter("receiver", receiver).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Message m set m.text = :text "
                + "WHERE m.messageId = :messageId").setParameter("messageId", messageId).setParameter("text", text).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Message m set m.date = :date "
                + "WHERE m.messageId = :messageId").setParameter("messageId", messageId).setParameter("date", date).executeUpdate();
    }

    public int delete(int messageId){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("DELETE FROM Message m WHERE m.messageId = :messageId")
                .setParameter("messageId", messageId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
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
