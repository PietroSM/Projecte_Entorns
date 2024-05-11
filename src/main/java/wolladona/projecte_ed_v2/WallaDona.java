package wolladona.projecte_ed_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WallaDona extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WallaDona.class
                .getResource("MainPage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 932, 523);
        stage.setTitle("Walla-Dona");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}