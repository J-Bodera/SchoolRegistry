package pl.edu.agh.to2.model.generator;

import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.session.SessionService;

public class DataGenerator {

    public final static void generateTeacherData() {
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.create("Anna", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");
        teacherDAO.create("Jan", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");
        teacherDAO.create("Maria", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");
        teacherDAO.create("Marek", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");
    }

    public final static void generateStudentData() {
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        studentDAO.create("Anna", "Nowak", "122456789", "an@xx.com", "abc", studentGroupDAO.findByName("1a"), 3);
        studentDAO.create("Jakub", "Miernik", "543654324", "jm@xx.com", "abc123", studentGroupDAO.findByName("1a"), 2);
        studentDAO.create("Ula", "Bar", "573947156", "ub@xx.com", "abc123", studentGroupDAO.findByName("1a"), 1);

    }

    public final static void generateStudentGroupData() {
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        studentGroupDAO.create("1a", teacherDAO.findByTeacherName("Anna", "Nowak"));
    }



}
