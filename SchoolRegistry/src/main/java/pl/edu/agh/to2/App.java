package pl.edu.agh.to2;

import java.util.Properties;

import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.edu.agh.to2.controller.AppController;
import pl.edu.agh.to2.dao.CourseDAO;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.*;
import pl.edu.agh.to2.session.SessionService;

import static javafx.application.Application.launch;

public class App extends Application {
    private Stage primaryStage;
    private AppController appController;
	private static SessionFactory sessionFactory = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("First");

        this.appController = new AppController(primaryStage);
        this.appController.initLoginLayout();
    }

	public static void main(String[] args) {
	    //SessionService.openSession();
//        StudentDAO studentDAO = new StudentDAO();
//        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        //TeacherDAO teacherDAO = new TeacherDAO();
     //  CourseDAO courseDAO = new CourseDAO();
//
 //       teacherDAO.create("Jan", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");
        //courseDAO.create("Historia");
       //courseDAO.create("Matematyka");
//        studentGroupDAO.create("1A", teacherDAO.findByTeacherId(0));
//        studentDAO.create("Jan", "Kowalski", "123456789", "jkowalski@gmail.com", "qwerty123", studentGroupDAO.findByName("1A"), 1);
   //     SessionService.closeSession();
        launch(args);
	}

}
