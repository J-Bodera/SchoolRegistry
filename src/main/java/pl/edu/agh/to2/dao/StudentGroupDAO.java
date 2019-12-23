package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;
import javax.persistence.PersistenceException;
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
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student_group set student_group_name = :name "
                + "WHERE student_group_id = :studentGroupId").setParameter("studentGroupId", studentGroupId)
                .setParameter("name", name).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student_group set tutor_teacher_id = :tutor "
                + "WHERE student_group_id = :studentGroupId").setParameter("studentGroupId", studentGroupId)
                .setParameter("tutor", tutor).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    public int delete(int studentGroupId){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Student_group WHERE student_group_id = :studentGroupId")
                .setParameter("studentGroupId", studentGroupId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<?> findAll(){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM StudentGroup s");
        return query.list();
    }

    public StudentGroup findByName(String name){
        return (StudentGroup) SessionService.getSession().createQuery("SELECT s FROM StudentGroup s WHERE s.name = :name")
                .setParameter("name", name).list().get(0);
    }


}
