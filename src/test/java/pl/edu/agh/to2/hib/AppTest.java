package pl.edu.agh.to2.hib;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to2.dao.CourseDAO;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.session.SessionService;

public class AppTest {

    private final TeacherDAO teacherDao = new TeacherDAO();
    private final StudentDAO studentDao = new StudentDAO();
    private final CourseDAO courseDao = new CourseDAO();
    private final StudentGroupDAO studentGroupDao = new StudentGroupDAO();

    @Before
    public void before() {
        SessionService.openSession();
    }

    @After
    public void after() {
        SessionService.closeSession();
    }

    @Test
    public void createAndFindTeacherTest() {

        teacherDao.create("Anna", "Nowak", "123456789", "anowak@gmail.com", "abcd12345");
        Teacher teacher = teacherDao.findByTeacherName("Anna", "Nowak");
        Assert.assertNotNull(teacher);
    }

    @Test
    public void createAndFindStudentGroupTest() {
        teacherDao.create("Julia ", "Witkowska", "123456789", "anowak@gmail.com", "abcd12345");
        studentGroupDao.create("3C", teacherDao.findByTeacherName("Julia ", "Witkowska"));
        StudentGroup studentGroup = studentGroupDao.findByName("3C");
        Assert.assertNotNull(studentGroup);
    }

    @Test
    public void createAndFindStudentTest() {
        teacherDao.create("Magdalena", "Zielińska", "123456789", "anowak@gmail.com", "abcd12345");
        studentGroupDao.create("1A", teacherDao.findByTeacherName("Magdalena", "Zielińska"));
        studentDao.create("Jan", "Kowalski", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDao.findByName("1A"), 1);
        Student student = studentDao.findByStudentName("Jan", "Kowalski");
        Assert.assertNotNull(student);
    }

    @Test
    public void createAndFindCourseTest() {
        courseDao.create("Fizyka");
        Course course = courseDao.findByName("Fizyka");
        Assert.assertNotNull(course);
    }

    @Test
    public void updateTeacherTest(){
        teacherDao.create("Magdalena", "Ardanowska", "123456789", "ard@gmail.com", "abcd12345");
        Teacher teacher = teacherDao.findByTeacherName("Magdalena", "Ardanowska");
        int id = teacher.getTeacherId();
        teacherDao.update(id, "Natalia", "Ardanowska", "987654321", "ard@gmail.com", "abcd12345");
        Assert.assertNotNull(teacherDao.findByTeacherName("Natalia", "Ardanowska" ));
    }

    @Test
    public void updateStudentTest(){
        teacherDao.create("Katarzyna", "Lesniewska", "123456789", "anowak@gmail.com", "abcd12345");
        studentGroupDao.create("2A", teacherDao.findByTeacherName("Katarzyna", "Lesniewska"));
        studentDao.create("Andrzej", "Kowalski", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDao.findByName("2A"), 2);
        studentDao.update(studentDao.findByStudentName("Andrzej", "Kowalski").getStudentId(), "Marcin", "Nowak", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDao.findByName("2A"), 2);
        Assert.assertNotNull(studentDao.findByStudentName("Marcin", "Nowak"));
    }

    @Test
    public void updateStudentGroupTest(){
        teacherDao.create("Anna ", "Witkowska", "123456789", "awitkowska@gmail.com", "abcd12345");
        teacherDao.create("Dorota", "Lewandowska", "123456789", "dlewandowska@gmail.com", "xyz123");
        studentGroupDao.create("2D", teacherDao.findByTeacherName("Anna ", "Witkowska"));
        int id = studentGroupDao.findByName("2D").getStudentGroupId();
        studentGroupDao.update(id, "3D", teacherDao.findByTeacherName("Dorota", "Lewandowska"));
        Assert.assertNotNull(studentGroupDao.findByName("3D"));
    }

}
