package wolladona.projecte_ed_v2;

import PersonP.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    private Button BTRegister;
    @FXML
    private Button BTLogin;

    private Users userListMain;
    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userListMain = new Users();
        userListMain.ReadFile();
        System.out.println("Hola");
    }

    public void Click_button_Register(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(WallaDona.class.
                getResource("RegisterPage-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Hola");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        RegisterPageController controller = loader.getController();
        controller.setUsersList(userListMain);
        stage.showAndWait();
    }


    public void click_button_Login(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(WallaDona.class.
                getResource("LogInPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Hola");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        LogInPageController controller = loader.getController();
        controller.setUsersListLoginPage(userListMain);
        stage.showAndWait();
        System.out.println(userListMain.Showone(0));
    }


    public void setUsersList(Users usersList) {
        this.userListMain = usersList;

    }

    public Users getUserListMain(){
        return userListMain;
    }
}