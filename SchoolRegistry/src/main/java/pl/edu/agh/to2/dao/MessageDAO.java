package pl.edu.agh.to2.dao;


import pl.edu.agh.to2.model.*;

import javax.persistence.PersistenceException;
import java.util.Date;

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

}
