package pl.edu.agh.to2.dao;

import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Date;

public class StudentGroupDAO extends GenericDAO<StudentGroup> {

    public boolean create(String name, Teacher tutor) {
        try {
            save(new StudentGroup(name, tutor));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public StudentGroup findByName(String name){
        EntityManager em = SessionService.getEntityManager();
        EntityTransaction etx = SessionService.getEntityTransaction();
        etx.begin();
        StudentGroup studentGroup = em.createQuery("SELECT s FROM StudentGroup s WHERE s.name = :name", StudentGroup.class)
                .setParameter("name", name).getSingleResult();
        etx.commit();
        return studentGroup;
    }


}
