package pl.edu.agh.to2.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;

public class AdminClassesController {
    private AppController appController;

    public AdminClassesController() {}

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @FXML
    private TableView<StudentGroup> studentGroupTable;

    @FXML
    private TableColumn<StudentGroup, String> classColumn;

    @FXML
    private TableColumn<StudentGroup, String> teacherColumn;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

//    @FXML
//    private TableView<Student> studentsTable;
//
//    @FXML
//    private TableColumn<Student, String> student_firstnameColumn;
//
//    @FXML
//    private TableColumn<Student, String> student_lastnameColumn;

    @FXML
    private void initialize() {
        studentGroupTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        classColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        teacherColumn.setCellValueFactory(data -> data.getValue().tutorNameProperty());

        studentGroupTable.setItems(studentGroups);

        editButton.disableProperty().bind(
                Bindings.size(
                        studentGroupTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));

        deleteButton.disableProperty().bind(
                Bindings.size(
                        studentGroupTable.getSelectionModel()
                                .getSelectedItems()).isNotEqualTo(1));
    }

    private ObservableList<StudentGroup> studentGroups = FXCollections.observableArrayList(
            new StudentGroupDAO().findAll());

    @FXML
    private void handlePrevAction(){
        appController.showAdminLayout();
    }

    @FXML
    public void handleEditAction(ActionEvent event) {

    }

    @FXML
    public void handleDeleteAction(ActionEvent event) {
        StudentGroup studentGroup = studentGroupTable.getSelectionModel().getSelectedItem();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();

        if( studentGroup != null ) {
            studentGroupDAO.delete(studentGroup.getStudentGroupId());
            studentGroups.remove(studentGroup);
        }
    }

    @FXML
    public void handleAddAction(ActionEvent event) {
        StudentGroup studentGroup = new StudentGroup();
        appController.showClassesAddDialog(studentGroup);
    }
}
