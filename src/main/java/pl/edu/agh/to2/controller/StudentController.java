package pl.edu.agh.to2.controller;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import pl.edu.agh.to2.dao.AttendanceDAO;
import pl.edu.agh.to2.dao.GradeDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Attendance;
import pl.edu.agh.to2.model.Grade;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.Teacher;

public class StudentController {
    private AppController appController;
    private Student student;

    public StudentController() {}

    public void setStudent(Student student) {
        this.student = student;
    }

    @FXML
    private TableView<Grade> gradesTable;
    @FXML
    private TableColumn<Grade, String> grCourseColumn;
    @FXML
    private TableColumn<Grade, String> grGradeColumn;
    @FXML
    private TableColumn<Grade, String> grCommentColumn;
    @FXML
    private TableColumn<Grade, String> grDateColumn;
    @FXML
    private TableColumn<Grade, String> grTeacherColumn;

    @FXML
    private TableView<Attendance> attendanceTable;
    @FXML
    private TableColumn<Attendance, String> attDateColumn;
    @FXML
    private TableColumn<Attendance, String> attCourseColumn;
    @FXML
    private TableColumn<Attendance, String> attTeacherColumn;
    @FXML
    private TableColumn<Attendance, String> attAttendanceColumn;



    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            ObservableList<Grade> grades = FXCollections.observableArrayList(
                    new GradeDAO().findAllForStudent(student));

            ObservableList<Attendance> attendance = FXCollections.observableArrayList(
                    new AttendanceDAO().findAllForStudent(student));
            grCourseColumn.setCellValueFactory(data -> data.getValue().courseStringProperty());
            grGradeColumn.setCellValueFactory(data -> data.getValue().gradeStringProperty());
            grCommentColumn.setCellValueFactory(data -> data.getValue().commentProperty());
            grDateColumn.setCellValueFactory(data -> data.getValue().dateStringProperty());
            grTeacherColumn.setCellValueFactory(data -> data.getValue().teacherStringProperty());

            gradesTable.setItems(grades);

            attCourseColumn.setCellValueFactory(data -> data.getValue().courseStringProperty());
            attDateColumn.setCellValueFactory(data -> data.getValue().dateStringProperty());
            attTeacherColumn.setCellValueFactory(data -> data.getValue().teacherStringProperty());
            attAttendanceColumn.setCellValueFactory(data -> data.getValue().attendanceStringProperty());

            attendanceTable.setItems(attendance);
        });
    }



    @FXML
    private void handleLogoutAction() {
        appController.initLoginLayout();
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}