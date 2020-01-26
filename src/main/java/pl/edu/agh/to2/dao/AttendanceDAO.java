package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.*;
import pl.edu.agh.to2.session.SessionService;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

public class AttendanceDAO extends GenericDAO<Attendance> {

    public boolean create(Date date, Course course, Teacher teacher, Student student, int attendance) {
        try {
            save(new Attendance(date, course, teacher, student, attendance));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int attendanceId, Date date, Course course, Teacher teacher, Student student, int attendance){
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Attendance set date = :date "
                + "WHERE attendance_id = :attendanceId").setParameter("attendanceId", attendanceId).setParameter("date", date).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Attendance set course = :course "
                + "WHERE attendance_id = :attendanceId").setParameter("attendanceId", attendanceId).setParameter("course", course).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Attendance set teacher = :teacher "
                + "WHERE attendance_id = :attendanceId").setParameter("attendanceId", attendanceId).setParameter("teacher", teacher).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Attendance set student = :student "
                + "WHERE attendance_id = :attendanceId").setParameter("attendanceId", attendanceId).setParameter("student", student).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Attendance set attendance = :attendance "
                + "WHERE attendance_id = :attendanceId").setParameter("attendanceId", attendanceId).setParameter("attendance", attendance).executeUpdate();


        SessionService.getEntityTransaction().commit();
    }

    public int delete(int id){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Attendance WHERE attendance_id = :id")
                .setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<Attendance> findAll(){
        return (List<Attendance>) SessionService.getSession().createQuery("SELECT a FROM Attendance a").list();

    }

    public List<Attendance> findAllForStudent(Student student){
        return (List<Attendance>) SessionService.getSession().createQuery("FROM Attendance "
                + "WHERE student = :student").setParameter("student", student).list();

    }

}
