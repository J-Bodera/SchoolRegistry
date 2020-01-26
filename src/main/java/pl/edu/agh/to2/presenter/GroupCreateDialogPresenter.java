package pl.edu.agh.to2.presenter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.dao.StudentGroupDAO;
import pl.edu.agh.to2.model.Student;
import pl.edu.agh.to2.model.StudentGroup;

public class GroupCreateDialogPresenter {
    StudentGroup studentGroup = new StudentGroup();

    @FXML
    private Label classNameLabel;

    @FXML
    private ComboBox<Student> studentsBox;

    private Stage dialogStage;

    private ObservableList<Student> students = FXCollections.observableArrayList(
            new StudentDAO().findAll());

    @FXML
    private void initialize() {
        for(Student s : students) {
            if(s.getStudentGroup() == null) {
                studentsBox.getItems().add(s);
            }

        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        System.out.println(this.dialogStage.getTitle());
    }

    public void setGroupName(StudentGroup studentGroup) {
        classNameLabel.setText(studentGroup.getName());
        this.studentGroup = studentGroup;
    }

    @FXML
    private void handleOkAction(ActionEvent event) {
        addStudentToGroup();
//        approved = true;
        dialogStage.close();

    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        dialogStage.close();
    }

    private void addStudentToGroup() {
        StudentDAO studentDAO = new StudentDAO();

        Student student = studentsBox.getValue();
        student.setStudentGroup(studentGroup);
        studentDAO.update(student, studentGroup);
    }
}
