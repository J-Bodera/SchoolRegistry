package pl.edu.agh.to2.presenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.dao.TeacherDAO;
import pl.edu.agh.to2.model.Teacher;

public class TeacherEditDialogPresenter {
    private Teacher teacher;

    @FXML
    private TextField first_nameTextField;
    @FXML
    private TextField last_nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField phoneTextField;

    private Stage dialogStage;

    private boolean approved;

    @FXML
    public void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setData(Teacher teacher) {
        this.teacher = teacher;
        updateControls();
    }

    public boolean isApproved() {
        return approved;
    }

    @FXML
    private void handleOkAction(ActionEvent event) {
        if (isInputValid()) {
                updateTeacher();
                approved = true;
                dialogStage.close();

        }
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        dialogStage.close();
    }

    private boolean isInputValid() {
        // TODO: implement

        return true;
    }

    private void updateTeacher() {

        String fn= teacher.getFirstName();
        teacher.setFirstName(first_nameTextField.getText());
        teacher.setLastName(last_nameTextField.getText());
        teacher.setEmail(emailTextField.getText());
        teacher.setPassword(passwordTextField.getText());
        teacher.setPhone(phoneTextField.getText());

        if (fn==""){
            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.create(teacher.getFirstName(), teacher.getLastName(), teacher.getPhone(), teacher.getEmail(), teacher.getPassword());

        }
    }

    private void updateControls() {
        first_nameTextField.setText(teacher.getFirstName());
        last_nameTextField.setText(teacher.getLastName());
        emailTextField.setText(teacher.getEmail());
        passwordTextField.setText(teacher.getPassword());
        phoneTextField.setText(teacher.getPhone());
    }
}
