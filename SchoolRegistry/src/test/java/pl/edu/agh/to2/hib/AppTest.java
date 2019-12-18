package pl.edu.agh.to2.hib;

import org.hibernate.AssertionFailure;
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

    @org.junit.Test
    public void createAndFindTeacherTest() {

        teacherDao.create("Anna", "Nowak", "123456789", "anowak@gmail.com", "abcd12345");
        Teacher teacher = teacherDao.findByTeacherName("Anna", "Nowak");
        Assert.assertNotNull(teacher);
    }

    @org.junit.Test
    public void createAndFindStudentGroup() {

        teacherDao.create("Julia ", "Witkowska", "123456789", "anowak@gmail.com", "abcd12345");
        studentGroupDao.create("3C", teacherDao.findByTeacherName("Julia ", "Witkowska"));
        StudentGroup studentGroup = studentGroupDao.findByName("3C");
        Assert.assertNotNull(studentGroup);
    }

    @org.junit.Test
    public void createAndFindStudentTest() {
        teacherDao.create("Magdalena", "Zielińska", "123456789", "anowak@gmail.com", "abcd12345");
        studentGroupDao.create("1A", teacherDao.findByTeacherName("Magdalena", "Zielińska"));
        studentDao.create("Jan", "Kowalski", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDao.findByName("1A"), 1);
        Student student = studentDao.findByStudentName("Jan", "Kowalski");
        Assert.assertNotNull(student);
    }

    @org.junit.Test
    public void createAndFindCourse() {
        courseDao.create("Fizyka");
        Course course = courseDao.findByName("Fizyka");
        Assert.assertNotNull(course);
    }

}
