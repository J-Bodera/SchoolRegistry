package pl.edu.agh.to2.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.edu.agh.to2.App;
import pl.edu.agh.to2.model.Teacher;
import pl.edu.agh.to2.presenter.TeacherEditDialogPresenter;

import java.io.IOException;

public class AppController {
    private Stage primaryStage;

    public AppController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initLoginLayout() {
        try {
            this.primaryStage.setTitle("Logowanie");

            FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource("LoginPane.fxml"));
            //loader.setLocation(App.class.getResource("view/LoginPane.fxml"));
            AnchorPane rootLayout = loader.load();

            LoginController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdminLayout() {
        try {
            this.primaryStage.setTitle("Panel admina");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("AdminPane.fxml"));
            AnchorPane adminLayout = loader.load();

            AdminController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(adminLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public void showAdminTeachersLayout() {
        try {
            this.primaryStage.setTitle("Panel admina - tabela nauczycieli");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("AdminTeachersPane.fxml"));
            BorderPane adminTeachersLayout = loader.load();

            AdminTeachersController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(adminTeachersLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public boolean showTeacherEditDialog(Teacher teacher) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("TeacherEditDialog.fxml"));
            BorderPane page = loader.load();

            Stage dialogStage = new Stage();
            if (teacher.getFirstName()==""){
                dialogStage.setTitle("Add teacher");

            }else {
                dialogStage.setTitle("Edit teacher");
            }
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            TeacherEditDialogPresenter presenter = loader.getController();
            presenter.setDialogStage(dialogStage);
            presenter.setData(teacher);

            dialogStage.showAndWait();
            return presenter.isApproved();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showAdminStudentsLayout() {
        try {
            this.primaryStage.setTitle("Panel admina - tabela uczniów");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("AdminStudentsPane.fxml"));
            BorderPane adminStudentsLayout = loader.load();

            AdminStudentsController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(adminStudentsLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public void showAdminClassesLayout() {
        try {
            this.primaryStage.setTitle("Panel admina - tabela klas");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("AdminClassesPane.fxml"));
            BorderPane adminClassesLayout = loader.load();

            AdminClassesController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(adminClassesLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public void showTeacherLayout() {
        try {
            this.primaryStage.setTitle("Panel nauczyciela");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("TeacherPane.fxml"));
            BorderPane TeacherLayout = loader.load();

//            TeacherController controller = loader.getController();
//            controller.setAppController(this);

            Scene scene = new Scene(TeacherLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }


    public void showStudentLayout() {
        try {
            this.primaryStage.setTitle("Panel ucznia");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getClassLoader().getResource("StudentPane.fxml"));
            BorderPane StudentLayout = loader.load();

//            StudentController controller = loader.getController();
//            controller.setAppController(this);

            Scene scene = new Scene(StudentLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

}
