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

/**
 *Controller class to control the inventions of MainPage View
 * @author Pedro Sala Mora
 * @version 1
 */
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
    }

    /**
     * Method that takes care of the operation of the register button and redirects us to the register page
     * (Metode que s'encarrega del funcionament del boton de registrar i mos redirigix a la register page)
     * @param actionEvent the click of the BTRegister button
     * @throws IOException catch the exception if the view does not exist
     */
    public void Click_button_Register(ActionEvent actionEvent) throws IOException {
        userListMain.getList_Person().clear();
        userListMain.ReadFile();

        FXMLLoader loader = new FXMLLoader(WallaDona.class.
                getResource("RegisterPage-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Register Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        RegisterPageController controller = loader.getController();
        controller.setUsersList(userListMain);
        stage.showAndWait();

        userListMain.SaveFile();
    }

    /**
     * Method that defines the operation of the login button, in this case, it redirects us to the Login Page
     * (Metode que defineix el funcionament del botó login, en aquest cas, mos rederigeix a la Login Page)
     * @param actionEvent the click of the BTLogin button
     * @throws IOException catch the exception if the view does not exist
     */
    public void click_button_Login(ActionEvent actionEvent) throws IOException {

        userListMain.getList_Person().clear();
        userListMain.ReadFile();

        FXMLLoader loader = new FXMLLoader(WallaDona.class.
                getResource("LogInPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        LogInPageController controller = loader.getController();
        controller.setUsersListLoginPage(userListMain);
        stage.showAndWait();

        userListMain = controller.getUsersListLoginPage();
        userListMain.SaveFile();
    }


    public void setUsersList(Users usersList) {
        this.userListMain = usersList;

    }

    public Users getUserListMain(){
        return userListMain;
    }
}