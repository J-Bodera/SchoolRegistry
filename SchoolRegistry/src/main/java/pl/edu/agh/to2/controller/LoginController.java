package pl.edu.agh.to2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class LoginController {
    private AppController appController;

    public LoginController() {}

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

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
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}