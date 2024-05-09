package wolladona.projecte_ed_v2;

import PersonP.Users;
import ProductP.Inventary;
import ProductP.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class responsible for the operation of the LogIn page
 * (Classe controlador encarregada de tindre el funcionament de la pàgina de LogIn)
 * @author Pedro Sala Mora
 * @version 1
 */
public class LogInPageController implements Initializable {
    @FXML
    private Button BTNback;
    @FXML
    private TextField TFemale;
    @FXML
    private PasswordField PFpassword;


    private Users usersListLoginPage;
    private Inventary inventaryList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListLoginPage = new Users();
        inventaryList = new Inventary();
        inventaryList.ReadFile();
    }

    public Users getUsersListLoginPage() {
        return usersListLoginPage;
    }

    /**
     * This method is responsible for removing a Users object from the parent window and assigning it to our Users
     * (Aquest métode s'encarrega de rebrer un objecte Users de la finestra pare i asignar-la al nostre Users)
     * @param usersList The Users instance of the parent class
     */
    public void setUsersListLoginPage(Users usersList){
        usersListLoginPage = usersList;
    }

    /**
     * This method gives functionality to the login button to start and edit the corresponding window
     * (Aquest métode, dona funcionalitat al botó d'iniciar sessió per a iniciar i redigirir a la finestra corresponent)
     * @param actionEvent OnClick()
     * @throws IOException
     */
    public void button_click_login(ActionEvent actionEvent) throws IOException {
        String emailTF, passwordPF;

        emailTF = TFemale.getText();
        passwordPF = PFpassword.getText();

        if(!(emailTF.isEmpty()) &&
                !(passwordPF.isEmpty()) &&
                usersListLoginPage.CheckCredentials(emailTF,passwordPF)){
            //Seller section
            if (usersListLoginPage.TypeOfUser(emailTF).equals("Seller")){
                FXMLLoader loader = new FXMLLoader(WallaDona.class.
                        getResource("SellerPage-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("Seller Page");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);

                //Array aux
                ArrayList<Product> listProduct = new ArrayList<>();

                for (int i = 0; i < inventaryList.getList_Inventary().size(); i++) {
                    if(inventaryList.getList_Inventary().get(i).getProductor()
                            .equals(usersListLoginPage.PersonSearch(emailTF))){
                        listProduct.add(inventaryList.getList_Inventary().get(i));
                    }
                }

                //mirar per a borrar


                SellerPageController controller = loader.getController();
                controller.SetInfoSellerPage(usersListLoginPage,
                        usersListLoginPage.PositionList(emailTF), listProduct);
                stage.showAndWait();

                //Retornar de la filla
            //Client section
            }else if(usersListLoginPage.TypeOfUser(emailTF).equals("Client")){
                FXMLLoader loader = new FXMLLoader(WallaDona.class.
                        getResource("MainPageUser-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("Seller Page");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);

                MainPageUserViewController controller = loader.getController();
                controller.SetInfoClientPage(usersListLoginPage,
                        usersListLoginPage.PositionList(emailTF));
                stage.showAndWait();

                //retornar de la filla
            }
        }
    }

    public void button_click_back(ActionEvent actionEvent) {

    }

}
