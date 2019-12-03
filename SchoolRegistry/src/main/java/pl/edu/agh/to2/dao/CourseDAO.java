package pl.edu.agh.to2.dao;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;


public class CourseDAO extends GenericDAO<Course> {

    public boolean create(String name) {
        try {
            save(new Course(name));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Course findByName(String name){
        EntityManager em = SessionService.getEntityManager();
        EntityTransaction etx = SessionService.getEntityTransaction();
        etx.begin();
        Course course = em.createQuery("SELECT c FROM Course c WHERE c.courseName = :name", Course.class)
                .setParameter("name", name).getSingleResult();
        etx.commit();
        return course;
    }

}
