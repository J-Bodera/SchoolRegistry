package pl.edu.agh.to2.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.dao.TeacherDAO;
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
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private void initialize() {
        teachersTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        first_nameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        last_nameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        phoneColumn.setCellValueFactory(data -> data.getValue().phoneProperty());
        emailColumn.setCellValueFactory(data -> data.getValue().emailProperty());

        teachersTable.setItems(teachers);
        editButton.disableProperty().bind(
                Bindings.size(
                        teachersTable.getSelectionModel()
                            .getSelectedItems()).isNotEqualTo(1));

        deleteButton.disableProperty().bind(
                Bindings.size(
                        teachersTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));

    }

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(
            new TeacherDAO().findAll());

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
        Teacher teacher = teachersTable.getSelectionModel().getSelectedItem();
        TeacherDAO teacherDAO = new TeacherDAO();

        if(teacher != null ) {
            teacherDAO.delete(teacher.getTeacherId());
            teachers.remove(teacher);
        }

    }

    @FXML
    private void handleAddAction() {
        Teacher teacher= new Teacher("","","","","");
        teachers.add(teacher);
        appController.showTeacherEditDialog(teacher);
    }
}