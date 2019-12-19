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

    public boolean create(int grade, Student student, Teacher teacher, Course course, String comment) {
        try {
            save(new Grade(grade, student, teacher,  course, comment, new Date()));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int gradeId, int grade, Student student, Teacher teacher, Course course, String comment){
        SessionService.getSession().createQuery("UPDATE Grade g set g.grade = :grade "
                + "WHERE g.gradeId = :gradeId").setParameter("gradeId", gradeId).setParameter("grade", grade).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Grade g set g.student = :student "
                + "WHERE g.gradeId = :gradeId").setParameter("gradeId", gradeId).setParameter("student", student).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Grade g set g.teacher = :teacher "
                + "WHERE g.gradeId = :gradeId").setParameter("gradeId", gradeId).setParameter("teacher", teacher).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Grade g set g.course = :course "
                + "WHERE g.gradeId = :gradeId").setParameter("gradeId", gradeId).setParameter("course", course).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Grade g set g.comment = :comment "
                + "WHERE g.gradeId = :gradeId").setParameter("gradeId", gradeId).setParameter("comment", comment).executeUpdate();
    }

    public int delete(int gradeId){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("DELETE FROM Grade g WHERE g.gradeId = :gradeId")
                .setParameter("gradeId", gradeId);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return result;
    }

    public List<?> findAll(){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Grade g");
        return query.list();
    }

    public List<?> findAllForStudent(Student student){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Grade g WHERE g.student = :student")
                .setParameter("student", student);
        return query.list();
    }

}