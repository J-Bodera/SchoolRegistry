package pl.edu.agh.to2.model.generator;

import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;

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



}
