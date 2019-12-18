package pl.edu.agh.to2.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.model.Teacher;

public class AdminTeachersController {
    private AppController appController;

    public AdminTeachersController(){}

    public void setAppController(AppController appController) {
        this.appController = appController;
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
    private Button editButton;

    @FXML
    private void initialize() {
        teachersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        first_nameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        last_nameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        phoneColumn.setCellValueFactory(data -> data.getValue().phoneProperty());
        emailColumn.setCellValueFactory(data -> data.getValue().emailProperty());
        passwordColumn.setCellValueFactory(data -> data.getValue().passwordProperty());

        teachersTable.setItems(teachers);
        editButton.disableProperty().bind(
                Bindings.size(
                        teachersTable.getSelectionModel()
                            .getSelectedItems()).isNotEqualTo(1));
    }

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(
            new Teacher("a", "b", "c", "d", "e"));

    @FXML
    private void handlePrevAction(){
        appController.showAdminLayout();
    }

    @FXML
    private void handleEditAction() {
        Teacher teacher = teachersTable.getSelectionModel().getSelectedItem();
        if(teacher != null ) {
            appController.showTeacherEditDialog(teacher);
        }
    }

    @FXML
    private void handleDeleteAction() {

    }

    @FXML
    private void handleAddAction() {

    }
}