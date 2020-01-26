package pl.edu.agh.to2.presenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.StudentGroup;
import pl.edu.agh.to2.model.Teacher;

public class ClassesAddDialogPresenter {
    StudentGroup studentGroup = new StudentGroup();
    @FXML
    private TextField classNameTextField;

    @FXML
    private ComboBox<Teacher> teachersBox;

    private Stage dialogStage;

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList(
            new TeacherDAO().findAll());

    @FXML
    private void initialize() {
        for( Teacher t : teachers) {
            teachersBox.getItems().add(t);
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        System.out.println(this.dialogStage.getTitle());
    }

    @FXML
    private void handleOkAction(ActionEvent event) {
        createStudentGroup();
//        approved = true;
        dialogStage.close();

    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        dialogStage.close();
    }

    private void createStudentGroup() {
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();

        String name = classNameTextField.getText();
        Teacher tutor = teachersBox.getValue();

        studentGroupDAO.create(name, tutor);
    }
}
