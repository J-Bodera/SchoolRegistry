package pl.edu.agh.to2.dao;
import org.hibernate.Query;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;


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

    public void update(int courseId, String courseName){
        SessionService.getSession().createQuery("UPDATE Course c set c.courseName = :courseName "
                + "WHERE c.courseId = :courseId").setParameter("courseId", courseId).setParameter("courseName", courseId).executeUpdate();
    }

    public int delete(String name){
        Query query = SessionService.getSession().createQuery("DELETE FROM Course c WHERE c.courseName = :name")
                .setParameter("name", name);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return result;
    }

    public List<Course> findAll(){
        Query query = SessionService.getSession().createQuery("FROM Course c");
        return query.list();
    }

    public Course findById(int courseId){
        Course course = (Course) SessionService.getSession().createQuery("SELECT c FROM Course c WHERE c.courseId = :courseId")
                .setParameter("courseId", courseId).list().get(0);
        return course;
    }

    public Course findByName(String name){
        Course course = (Course) SessionService.getSession().createQuery("SELECT c FROM Course c WHERE c.courseName = :name")
                .setParameter("name", name).list().get(0);
        return course;
    }

}
