package pl.edu.agh.to2.dao;

import org.hibernate.Query;
import pl.edu.agh.to2.model.Grade;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAO extends GenericDAO<Student> {

    public boolean create(String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup, int number) {
        try {
            save(new Student(firstName, lastName, phone, email, password, studentGroup, number));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int studentId, String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup, int number){
        SessionService.getSession().createQuery("UPDATE Student s set s.firstName = :firstName "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.lastName = :lastName "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.phone = :phone "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("phone", phone).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.email = :email "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("email", email).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.password = :password "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("password", password).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.studentGroup = :studentGroup "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("studentGroup", studentGroup).executeUpdate();
        SessionService.getSession().createQuery("UPDATE Student s set s.number = :number "
                + "WHERE s.studentId = :studentId").setParameter("studentId", studentId).setParameter("number", number).executeUpdate();
    }

    public int delete(int id){
        Query query = SessionService.getSession().createQuery("DELETE FROM Student s WHERE s.studentId = :id")
                .setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        return result;
    }

    public List<Teacher> findAll(){
        Query query = SessionService.getSession().createQuery("FROM Student s");
        return query.list();
    }

    public List<Teacher> findAllFromStudentGroup(StudentGroup studentGroup){
        Query query = SessionService.getSession().createQuery("FROM Student s WHERE s.studentGroup = :studentGroup")
                .setParameter("studentGroup", studentGroup);
        return query.list();
    }

    public Student findByStudentId(int studentId){
        Student student = (Student) SessionService.getSession().createQuery("SELECT s FROM Student s WHERE s.studentId = :id")
                .setParameter("id", studentId).list().get(0);
        return student;
    }

}
