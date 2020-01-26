package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.model.Grade;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class GradeDAO extends GenericDAO<Grade> {

    public boolean create(int grade, Student student, Teacher teacher, Course course, String comment, Date date) {
        try {
            save(new Grade(grade, student, teacher,  course, comment, date));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int gradeId, int grade, Student student, Teacher teacher, Course course, String comment){
        SessionService.getEntityTransaction().begin();
        SessionService. getEntityManager().createNativeQuery("UPDATE Grade set grade = :grade "
                + "WHERE grade_id = :gradeId").setParameter("gradeId", gradeId).setParameter("grade", grade).executeUpdate();
        SessionService. getEntityManager().createNativeQuery("UPDATE Grade set student_student_id = :student "
                + "WHERE grade_id = :gradeId").setParameter("gradeId", gradeId).setParameter("student", student).executeUpdate();
        SessionService. getEntityManager().createNativeQuery("UPDATE Grade set teacher_teacher_id = :teacher "
                + "WHERE grade_id = :gradeId").setParameter("gradeId", gradeId).setParameter("teacher", teacher).executeUpdate();
        SessionService. getEntityManager().createNativeQuery("UPDATE Grade set course_course_id = :course "
                + "WHERE grade_id = :gradeId").setParameter("gradeId", gradeId).setParameter("course", course).executeUpdate();
        SessionService. getEntityManager().createNativeQuery("UPDATE Grade set comment = :comment "
                + "WHERE grade_id = :gradeId").setParameter("gradeId", gradeId).setParameter("comment", comment).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    public int delete(int gradeId){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Grade WHERE grade_id = :gradeId")
                .setParameter("gradeId", gradeId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<Grade> findAll(){
        return (List<Grade>) SessionService.getSession().createQuery("SELECT g FROM Grade g").list();
    }

    public List<Grade> findAllForStudent(Student student){
        return (List<Grade>) SessionService.getSession().createQuery("FROM Grade g WHERE g.student = :student").setParameter("student", student).list();

    }

}