package pl.edu.agh.to2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;

public class AdminStudentsController {
    private AppController appController;

    public AdminStudentsController(){}

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private void handlePrevAction(){
        appController.showAdminLayout();
    }
}
