package pl.edu.agh.to2.dao;

import org.hibernate.query.NativeQuery;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.session.SessionService;
import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDAO extends GenericDAO<Student> {

    public boolean create(String firstName, String lastName, String phone, String email, String password) {
        try {
            save(new Student(firstName, lastName, phone, email, password));
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(int studentId, String firstName, String lastName, String phone, String email, String password, StudentGroup studentGroup, int number){
        SessionService.getEntityTransaction().begin();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set first_name = :firstName "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set last_name = :lastName "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set phone = :phone "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("phone", phone).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set email = :email "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("email", email).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set password = :password "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("password", password).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set studentGroup_student_group_id = :studentGroup "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("studentGroup", studentGroup).executeUpdate();
//        SessionService.getEntityManager().createNativeQuery("UPDATE Student set number = :number "
//                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("number", number).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    public void update(Student student){
        SessionService.getEntityTransaction().begin();

        int studentId = student.getStudentId();
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String phone = student.getPhone();
        String email = student.getEmail();
        String password = student.getPassword();

        SessionService.getEntityManager().createNativeQuery("UPDATE Student set first_name = :firstName "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("firstName", firstName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set last_name = :lastName "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("lastName", lastName).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set phone = :phone "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("phone", phone).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set email = :email "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("email", email).executeUpdate();
        SessionService.getEntityManager().createNativeQuery("UPDATE Student set password = :password "
                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("password", password).executeUpdate();
//        SessionService.getEntityManager().createNativeQuery("UPDATE Student set studentGroup_student_group_id = :studentGroup "
//                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("studentGroup", studentGroup).executeUpdate();
//        SessionService.getEntityManager().createNativeQuery("UPDATE Student set number = :number "
//                + "WHERE student_id = :studentId").setParameter("studentId", studentId).setParameter("number", number).executeUpdate();
        SessionService.getEntityTransaction().commit();
    }

    /**
     * @param id
     * @return
     */
    public int delete(int id){
        SessionService.getEntityTransaction().begin();
        NativeQuery<?> query = (NativeQuery<?>) SessionService.getEntityManager().createNativeQuery("DELETE FROM Student WHERE student_id = :id")
                .setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        SessionService.getEntityTransaction().commit();
        return result;
    }

    public List<Student> findAll(){
        return (List<Student>) SessionService.getSession().createQuery("SELECT s FROM Student s")
                .list();
    }

    public List<?> findAllFromStudentGroup(StudentGroup studentGroup){
        NativeQuery<?> query = SessionService.getSession().createNativeQuery("FROM Student s WHERE s.studentGroup = :studentGroup")
                .setParameter("studentGroup", studentGroup);
        return query.list();
    }

    public Student findByStudentId(int studentId){
        return (Student) SessionService.getSession().createQuery("SELECT s FROM Student s WHERE s.studentId = :id")
                .setParameter("id", studentId).list().get(0);
    }

    public Student findByStudentName(String firstName, String lastName){
        return (Student) SessionService.getSession()
                .createQuery("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName")
                .setParameter("firstName", firstName).setParameter("lastName", lastName).list().get(0);
    }

    public Student findByEmail(String email){
        return (Student) SessionService.getSession()
                .createQuery("SELECT s FROM Student s WHERE s.email = :email")
                .setParameter("email", email).list().get(0);
    }
}
