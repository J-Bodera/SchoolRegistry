package pl.edu.agh.to2.dao;

import pl.edu.agh.to2.model.*;

import javax.persistence.PersistenceException;
import java.util.Date;

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

}
