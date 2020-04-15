package pluralsight.javacourse.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxControllerMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ihm.fxml"));

            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
