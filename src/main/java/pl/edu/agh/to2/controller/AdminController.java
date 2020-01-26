package pl.edu.agh.to2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Teacher;

public class AdminController {
    private AppController appController;

    public AdminController() {
    }

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
        //     teachersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //   first_nameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        // last_nameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        //      phoneColumn.setCellValueFactory(data -> data.getValue().phoneProperty());
        //    emailColumn.setCellValueFactory(data -> data.getValue().emailProperty());
        //  passwordColumn.setCellValueFactory(data -> data.getValue().passwordProperty());

        //teachersTable.setItems(teachers);
    }

    // private ObservableList<Teacher> teachers = FXCollections.observableArrayList(
    //       new Teacher("a", "b", "c", "d", "e"));

    @FXML
    private void handleLogoutAction() {
        appController.initLoginLayout();
    }

    @FXML
    private void handleAdminTeachersAction() {
        appController.showAdminTeachersLayout();
    }

    @FXML
    private void handleAdminStudentsAction() {
        appController.showAdminStudentsLayout();
    }

    @FXML
    private void handleAdminClassesAction() {
        appController.showAdminClassesLayout();
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

}