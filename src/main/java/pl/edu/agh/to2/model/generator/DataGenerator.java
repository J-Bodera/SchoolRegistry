package pl.edu.agh.to2.model.generator;

import pl.edu.agh.to2.dao.*;
import pl.edu.agh.to2.model.Course;
import pl.edu.agh.to2.model.Teacher;

import java.util.Date;

public class DataGenerator {

    /**
     *
     */
    public final static void generateTeacherData() {
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.create("Anna", "Nowak", "122456789", "jnowak@gmail.com", "an");
        teacherDAO.create("Jan", "Noc", "122456789", "jnoc@gmail.com", "jn");
        teacherDAO.create("Maria", "Miernik", "122456789", "mmiernik@gmail.com", "mm");
        teacherDAO.create("Marek", "Kowalski", "122456789", "mkowalski@gmail.com", "mk");
    }

    public final static void generateStudentData() {
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        studentDAO.create("Anna", "Nowak", "122456789", "an@xx.com", "abc");
        studentDAO.create("Jakub", "Miernik", "543654324", "jm@xx.com", "abc123");
        studentDAO.create("Ula", "Bar", "573947156", "ub@xx.com", "abc123");

    }

    public final static void generateStudentGroupData() {
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        studentGroupDAO.create("1a", teacherDAO.findByTeacherName("Anna", "Nowak"));
    }

    public final static void generateCourseData() {
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.create("Matematyka");
        courseDAO.create("Polski");
        courseDAO.create("Fizyka");
        courseDAO.create("Angielski");
        courseDAO.create("Historia");
        courseDAO.create("Biologia");
        courseDAO.create("Chemia");

    }

    public final static void generateAttendanceData() {
        CourseDAO courseDAO = new CourseDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        StudentDAO studentDAO = new StudentDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();

        attendanceDAO.create(new Date(2020, 1, 10), courseDAO.findByName("Matematyka"),
                teacherDAO.findByTeacherName("Anna", "Nowak"),
                studentDAO.findByStudentName("Jakub", "Miernik"),
                0);

        attendanceDAO.create(new Date(2020,1,10), courseDAO.findByName("Biologia"),
                teacherDAO.findByTeacherName("Anna", "Nowak"),
                studentDAO.findByStudentName("Anna", "Nowak"),
                1);
        attendanceDAO.create(new Date(2020,1,10), courseDAO.findByName("Angielski"),
                teacherDAO.findByTeacherName("Anna", "Nowak"),
                studentDAO.findByStudentName("Anna", "Nowak"),
                2);
        attendanceDAO.create(new Date(2020,1,10), courseDAO.findByName("Polski"),
                teacherDAO.findByTeacherName("Anna", "Nowak"),
                studentDAO.findByStudentName("Ula", "Bar"),
                2);
    }

    public final static void generateGradesData(){
        GradeDAO gradeDAO = new GradeDAO();
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        CourseDAO courseDAO = new CourseDAO();
        gradeDAO.create(5, studentDAO.findByStudentName("Anna", "Nowak"), teacherDAO.findByTeacherName("Marek", "Kowalski"), courseDAO.findByName("Matematyka"), "Sprawdzian 1", new Date(2020, 1, 1));
        gradeDAO.create(4, studentDAO.findByStudentName("Anna", "Nowak"), teacherDAO.findByTeacherName("Maria", "Miernik"), courseDAO.findByName("Polski"), "Kartkówka 1", new Date(2020, 1, 12));
        gradeDAO.create(5, studentDAO.findByStudentName("Anna", "Nowak"), teacherDAO.findByTeacherName("Marek", "Kowalski"), courseDAO.findByName("Matematyka"), "Sprawdzian 2", new Date(2020, 1, 2));
        gradeDAO.create(3, studentDAO.findByStudentName("Anna", "Nowak"), teacherDAO.findByTeacherName("Jan", "Noc"), courseDAO.findByName("Angielski"), "Zadanie domowe 1", new Date(2020, 2, 12));
        gradeDAO.create(5, studentDAO.findByStudentName("Anna", "Nowak"), teacherDAO.findByTeacherName("Maria", "Miernik"), courseDAO.findByName("Historia"), "Kartkówka 1", new Date(2020, 2, 23));

    }


}
