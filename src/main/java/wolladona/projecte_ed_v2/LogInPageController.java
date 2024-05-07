package wolladona.projecte_ed_v2;

import PersonP.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInPageController implements Initializable {

    @FXML
    private TextField TFemale;
    @FXML
    private PasswordField PFpassword;

    private Users usersListLoginPage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListLoginPage = new Users();

    }

    public void setUsersListLoginPage(Users usersList){
        usersListLoginPage = usersList;
        System.out.println("Hola");
        System.out.println(usersListLoginPage.Showone(4));
    }


    public void button_click_login(ActionEvent actionEvent) throws IOException {
        String emailTF, passwordPF;

        emailTF = TFemale.getText();
        passwordPF = PFpassword.getText();

        if(!(emailTF.isEmpty()) &&
                !(passwordPF.isEmpty()) &&
                usersListLoginPage.CheckCredentials(emailTF,passwordPF)){
            if (usersListLoginPage.TypeOfUser(emailTF).equals("Seller")){
                //System.out.println("Furula");
                FXMLLoader loader = new FXMLLoader(WallaDona.class.
                        getResource("SellerPage-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("Seller Page");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);


                SellerPageController controller = loader.getController();
                controller.SetInfoSellerPage(usersListLoginPage,
                        usersListLoginPage.PositionList(emailTF));
                stage.showAndWait();
            }//fer per a redirigir a secció de clients
        }
    }
}
