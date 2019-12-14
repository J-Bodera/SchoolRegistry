package pl.edu.agh.to2.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.edu.agh.to2.App;

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
            AnchorPane rootLayout = (AnchorPane) loader.load();

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
            BorderPane adminLayout = (BorderPane) loader.load();

            AdminController controller = loader.getController();
            controller.setAppController(this);

            Scene scene = new Scene(adminLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
