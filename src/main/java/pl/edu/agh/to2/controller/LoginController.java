package pl.edu.agh.to2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;

public class LoginController {
    private AppController appController;

    public LoginController() {}

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        authorize(loginTextField.getText(), passwordTextField.getText());
    }

    private void authorize(String login, String password) {
        if (login.equals("admin") && password.equals("admin")) {
            appController.showAdminLayout();
        }
        if (login.equals("nauczyciel1") && password.equals("n1")) {
            appController.showTeacherLayout();
        }
        //if (login.equals("uczen1") && password.equals("u1")) {
        //    appController.showStudentLayout();
        //}
        String tmpLogin = login;
        if(login.contains("gmail.com")) {
            TeacherDAO tmpTeacher = new TeacherDAO();
            Teacher t1 = tmpTeacher.findByTeacherEmail(tmpLogin);

            if(password.equals(t1.getPassword())) {
                appController.showTeacherLayout();
            }
        } else if (login.contains("xx")) {
            StudentDAO tmpStudent = new StudentDAO();
            Student s1 = tmpStudent.findByEmail(login);

            if(password.equals(s1.getPassword())) {
                appController.showStudentLayout(s1);
            }
        }


    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}