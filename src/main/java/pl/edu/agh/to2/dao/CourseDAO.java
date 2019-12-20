package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.session.SessionService;
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
        SessionService.getSession().createNativeQuery("UPDATE Course c set c.courseName = :courseName "
                + "WHERE c.courseId = :courseId").setParameter("courseId", courseId).setParameter("courseName", courseId).executeUpdate();
    }

    public int delete(int id){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Course WHERE course_id = :id")
                .setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<?> findAll(){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Course c");
        return query.list();
    }

    public Course findById(int courseId){
        return (Course) SessionService.getSession().createQuery("SELECT c FROM Course c WHERE c.courseId = :courseId")
                .setParameter("courseId", courseId).list().get(0);
    }

    public Course findByName(String name){
        return (Course) SessionService.getSession().createQuery("SELECT c FROM Course c WHERE c.courseName = :name")
                .setParameter("name", name).list().get(0);
    }

}
