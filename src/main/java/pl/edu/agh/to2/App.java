package pl.edu.agh.to2;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.agh.to2.controller.AppController;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.generator.DataGenerator;
import pl.edu.agh.to2.session.SessionService;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("First");

        AppController appController = new AppController(primaryStage);
        appController.initLoginLayout();
    }

	public static void main(String[] args) {
	    SessionService.openSession();

        DataGenerator.generateTeacherData();
        DataGenerator.generateStudentGroupData();
        DataGenerator.generateStudentData();


        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.update(1, "Magdalena", "Nowak", "122456789", "jnowak@gmail.com", "abcd12345");

        launch(args);

        SessionService.closeSession();

    }

}
