package pl.edu.agh.to2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.model.Teacher;

public class AdminController {
    private AppController appController;

    public AdminController() {}

    @FXML
    private TableView<Teacher> teachersTable;



    @FXML
    private void initialize() {
    }

    @FXML
    private void handleLogoutAction() {
        appController.initLoginLayout();
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}