package wolladona.projecte_ed_v2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainPageController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}