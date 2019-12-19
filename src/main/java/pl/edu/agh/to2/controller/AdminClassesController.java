package pl.edu.agh.to2.controller;

import javafx.fxml.FXML;

public class AdminClassesController {
    private AppController appController;

    public AdminClassesController() {}

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void handlePrevAction(){
        appController.showAdminLayout();
    }
}
