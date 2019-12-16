package pl.edu.agh.to2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Teacher;

public class AdminController {
    private AppController appController;

    public AdminController() {}

    @FXML
    private TableView<Teacher> teachersTable;

    @FXML
    private TableColumn<Teacher, String> first_nameColumn;

    @FXML
    private TableColumn<Teacher, String> last_nameColumn;

    @FXML
    private TableColumn<Teacher, String> phoneColumn;

    @FXML
    private TableColumn<Teacher, String> emailColumn;

    @FXML
    private TableColumn<Teacher, String> passwordColumn;



    @FXML
    private void initialize() {
        teachersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        first_nameColumn.setCellValueFactory(data -> data.getValue().getFirstNameProperty());
        last_nameColumn.setCellValueFactory(data -> data.getValue().getLastNameProperty());
        phoneColumn.setCellValueFactory(data -> data.getValue().getPhoneProperty());
        emailColumn.setCellValueFactory(data -> data.getValue().getEmailProperty());
        passwordColumn.setCellValueFactory(data -> data.getValue().getPasswordProperty());

        teachersTable.setItems(teachers);
    }

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(
            new Teacher("a", "b", "c", "d", "e"));

    @FXML
    private void handleLogoutAction() {
        appController.initLoginLayout();
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}