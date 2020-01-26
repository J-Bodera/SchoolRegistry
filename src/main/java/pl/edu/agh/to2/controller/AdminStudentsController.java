package pl.edu.agh.to2.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;

public class AdminStudentsController {
    private AppController appController;

    public AdminStudentsController(){}

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> first_nameColumn;

    @FXML
    private TableColumn<Student, String> last_nameColumn;

    @FXML
    private TableColumn<Student, String> phoneColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> passwordColumn;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private void initialize() {
        studentsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        first_nameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        last_nameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());
        phoneColumn.setCellValueFactory(data -> data.getValue().phoneProperty());
        emailColumn.setCellValueFactory(data -> data.getValue().emailProperty());
        passwordColumn.setCellValueFactory(data -> data.getValue().passwordProperty());

        studentsTable.setItems(students);

        editButton.disableProperty().bind(
                Bindings.size(
                        studentsTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));

        deleteButton.disableProperty().bind(
                Bindings.size(
                        studentsTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));
    }

    private ObservableList<Student> students = FXCollections.observableArrayList(
            new StudentDAO().findAll());

    @FXML
    private void handlePrevAction(){
        appController.showAdminLayout();
    }

    @FXML
    private void handleEditAction() {
        Student student = studentsTable.getSelectionModel().getSelectedItem();
        if(student != null ) {
            appController.showStudentEditDialog(student);
        }
    }

    @FXML
    private void handleDeleteAction() {
        Student student = studentsTable.getSelectionModel().getSelectedItem();
        StudentDAO studentDAO = new StudentDAO();

        if(student != null ) {
            studentDAO.delete(student.getStudentId());
            students.remove(student);
        }
    }

    @FXML
    private void handleAddAction() {
        Student student = new Student("","","","","");
        students.add(student);
        appController.showStudentEditDialog(student);
    }
}
