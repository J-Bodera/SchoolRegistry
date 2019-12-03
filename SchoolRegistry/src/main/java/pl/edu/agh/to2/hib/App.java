package pl.edu.agh.to2.hib;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.edu.agh.to2.dao.CourseDAO;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.*;
import pl.edu.agh.to2.session.SessionService;

public class App {
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
	    SessionService.openSession();
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        CourseDAO courseDAO = new CourseDAO();

        teacherDAO.create("Anna", "Nowak", "123456789", "anowak@gmail.com", "abcd12345");
        courseDAO.create("Fizyka");
        studentGroupDAO.create("1A", teacherDAO.findByTeacherId(0));
        studentDAO.create("Jan", "Kowalski", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDAO.findByName("1A"), 1);

	}

}
