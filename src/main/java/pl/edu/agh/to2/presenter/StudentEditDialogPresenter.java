package pl.edu.agh.to2.presenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.dao.StudentDAO;
import pl.edu.agh.to2.model.Student;

public class StudentEditDialogPresenter {
    private Student student;

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
        System.out.println(this.dialogStage.getTitle());
    }

    public void setData(Student student) {
        this.student = student;
        updateControls();
    }

    public boolean isApproved() {
        return approved;
    }

    @FXML
    private void handleOkAction(ActionEvent event) {
        if (isInputValid()) {
            updateStudent();
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

    private void updateStudent() {
        StudentDAO studentDAO = new StudentDAO();
        String fn = student.getFirstName();

        student.setFirstName(first_nameTextField.getText());
        student.setLastName(last_nameTextField.getText());
        student.setEmail(emailTextField.getText());
        student.setPassword(passwordTextField.getText());
        student.setPhone(phoneTextField.getText());

        if (fn==""){
            studentDAO.create(student.getFirstName(), student.getLastName(), student.getPhone(), student.getEmail(), student.getPassword());
        }

        studentDAO.update(student);
    }

    private void updateControls() {
        first_nameTextField.setText(student.getFirstName());
        last_nameTextField.setText(student.getLastName());
        emailTextField.setText(student.getEmail());
        passwordTextField.setText(student.getPassword());
        phoneTextField.setText(student.getPhone());
    }
}
