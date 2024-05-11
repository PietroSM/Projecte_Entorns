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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class in charge of managing the registration page, where a user can register
 * @author Pedro Sala Mora
 * @version 1
 */
public class RegisterPageController implements Initializable {
    @FXML
    private CheckBox CBfreelance;
    @FXML
    private CheckBox CBcooperative;
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
    }

    public void setUsersList(Users usersList) {
        this.usersList = usersList;
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
                        0,cifCLient));

            }else if(cifCLient.isEmpty()){
                usersList.AddUser(new Particular(name,password,location,email,
                        1,dniClient));
            }

        }else if(RBseller.isSelected()){
            cifSeller = TFsellercif.getText();

            if(CBfreelance.isSelected()){
                usersList.AddUser(new Freelance(name,password,location,email,
                        2,cifSeller));
            }else if(CBcooperative.isSelected()){
                usersList.AddUser(new Cooperative(name,password,location,email,
                        2,cifSeller));
            }
        }

    }



}
