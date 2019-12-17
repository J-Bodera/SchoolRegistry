package pl.edu.agh.to2.dao;

import org.hibernate.Query;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

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

    public void update(int studentGroupId, String name, Teacher tutor){
        SessionService.getSession().createQuery("UPDATE StudentGroup s set s.name = :name "
                + "WHERE s.studentGroupId = :studentGroupId").setParameter("studentGroupId", studentGroupId)
                .setParameter("name", name).executeUpdate();
        SessionService.getSession().createQuery("UPDATE StudentGroup s set s.tutor = :tutor "
                + "WHERE s.studentGroupId = :studentGroupId").setParameter("studentGroupId", studentGroupId)
                .setParameter("tutor", tutor).executeUpdate();
    }

    public int delete(int studentGroupId){
        Query query = SessionService.getSession().createQuery("DELETE FROM StudentGroup s WHERE s.studentGroupId = :studentGroupId")
                .setParameter("studentGroupId", studentGroupId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return result;
    }

    public List<StudentGroup> findAll(){
        Query query = SessionService.getSession().createQuery("FROM StudentGroup s");
        return query.list();
    }

    public StudentGroup findByName(String name){
        StudentGroup studentGroup = (StudentGroup) SessionService.getSession().createQuery("SELECT s FROM StudentGroup s WHERE s.name = :name")
                .setParameter("name", name).list().get(0);
        return studentGroup;
    }


}
