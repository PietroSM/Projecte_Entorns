package wolladona.projecte_ed_v2;

import PersonP.ClientP.Company;
import PersonP.ClientP.Particular;
import PersonP.SellerP.Cooperative;
import PersonP.SellerP.Freelance;
import PersonP.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class in charge of managing the registration page, where a user can register
 * @author Pedro Sala Mora
 * @version 1
 */
public class RegisterPageController implements Initializable {
    @FXML
    private Button BTNback;
    @FXML
    private RadioButton RBfreelance;
    @FXML
    private RadioButton RBcooperative;
    @FXML
    private Label labelCifSeller;
    @FXML
    private Label labelCifClient;
    @FXML
    private Label labeldniClient;
    @FXML
    private TextField TFName;
    @FXML
    private PasswordField PFpassword;
    @FXML
    private RadioButton RBclient;
    @FXML
    private TextField TFlocation;
    @FXML
    private TextField TFemail;
    @FXML
    private RadioButton RBseller;
    @FXML
    private TextField TFcifclient;
    @FXML
    private TextField TFdniclien;
    @FXML
    private TextField TFsellercif;
    @FXML
    private Button BTNregister;


    private Users usersList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersList = new Users();

        ToggleGroup toggleGroup1 = new ToggleGroup();
        RBseller.setToggleGroup(toggleGroup1);
        RBclient.setToggleGroup(toggleGroup1);

        ToggleGroup toggleGroup2 = new ToggleGroup();
        RBcooperative.setToggleGroup(toggleGroup2);
        RBfreelance.setToggleGroup(toggleGroup2);

        labelCifClient.setVisible(false);
        TFcifclient.setVisible(false);
        labeldniClient.setVisible(false);
        TFdniclien.setVisible(false);

        labelCifSeller.setVisible(false);
        TFsellercif.setVisible(false);
        RBcooperative.setVisible(false);
        RBfreelance.setVisible(false);
    }

    public void setUsersList(Users usersList) {
        this.usersList = usersList;
    }



    public void radioClient_click(ActionEvent actionEvent) {
        labelCifClient.setVisible(true);
        TFcifclient.setVisible(true);
        labeldniClient.setVisible(true);
        TFdniclien.setVisible(true);

        labelCifSeller.setVisible(false);
        TFsellercif.setVisible(false);
        RBcooperative.setVisible(false);
        RBfreelance.setVisible(false);
    }



    public void radioSeller_click(ActionEvent actionEvent) {
        labelCifClient.setVisible(false);
        TFcifclient.setVisible(false);
        labeldniClient.setVisible(false);
        TFdniclien.setVisible(false);

        labelCifSeller.setVisible(true);
        TFsellercif.setVisible(true);
        RBcooperative.setVisible(true);
        RBfreelance.setVisible(true);
    }

    /**
     * Method that validates the credentials and registers the user
     * (Metode que sencarrega de validar les credencials i registra el usuari)
     * @param actionEvent the click of the BTNregister button
     */
    public void button_clic_register(ActionEvent actionEvent) {
        String name, password, location, email;
        String cifCLient, dniClient, cifSeller;

        name = TFName.getText();
        password = PFpassword.getText();
        location = TFlocation.getText();
        email = TFemail.getText();


        if(RBclient.isSelected()){
            cifCLient = TFcifclient.getText();
            dniClient = TFdniclien.getText();

            if(dniClient.isEmpty()){
                usersList.AddUser(new Company(name,password,location,email,
                        1,cifCLient));

            }else if(cifCLient.isEmpty()){
                usersList.AddUser(new Particular(name,password,location,email,
                        0,dniClient));
            }

        }else if(RBseller.isSelected()){
            cifSeller = TFsellercif.getText();

            if(RBfreelance.isSelected()){
                usersList.AddUser(new Freelance(name,password,location,email,
                        2,cifSeller));
            }else if(RBcooperative.isSelected()){
                usersList.AddUser(new Cooperative(name,password,location,email,
                        3,cifSeller));
            }
        }

    }


    /**
     * Method that is activated when you hit the bach button, to return to the parent page
     * (Metode que s'activa quan donem al botó de back, per a retornar a la pantalla pare)
     * @param actionEvent Click on the back button
     */
    public void button_click_back(ActionEvent actionEvent) {
        Stage stage = (Stage) this.BTNback.getScene().getWindow();
        stage.close();
    }
}
