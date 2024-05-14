package wolladona.projecte_ed_v2;

import PersonP.SellerP.Seller;
import PersonP.Users;
import ProductP.Fruit;
import ProductP.Product;
import ProductP.Vegetable;
import ProductP.VegetableLeafy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class, in charge of managing the view of adding products
 * @author Pedro Sala Mora
 * @version 1
 */
public class AddProductController implements Initializable {
    @FXML
    private Button BTNback;
    @FXML
    private RadioButton RBleafyvegetable;
    @FXML
    private TextField TFname;
    @FXML
    private TextField TFseason;
    @FXML
    private TextField TFprice;
    @FXML
    private TextField TFamount;
    @FXML
    private RadioButton RBfruit;
    @FXML
    private RadioButton RBvegetable;
    @FXML
    private Button BTNadd;

    private Users usersListLoginPage;
    private int pos;
    private Product product_aux;
    private boolean create;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListLoginPage = new Users();
        create = true;

        ToggleGroup toggleGroup = new ToggleGroup();
        RBleafyvegetable.setToggleGroup(toggleGroup);
        RBfruit.setToggleGroup(toggleGroup);
        RBvegetable.setToggleGroup(toggleGroup);
    }

    /**
     * This method, activated when we present the add button, creates the new product and saves it in the list
     * (Aquest metode, s'activa quan presentem el boto d'afegir, crea el nou producte i el guarda en la llista)
     * @param actionEvent Click on the add button
     */
    public void button_click_add(ActionEvent actionEvent) {
        String tfName, tfSeason;
        double tfPrice;
        int tfAmount;

        tfName =  TFname.getText();
        tfSeason = TFseason.getText();
        tfPrice = Double.parseDouble(TFprice.getText());
        tfAmount = Integer.parseInt(TFamount.getText());

        if(RBfruit.isSelected()){
            product_aux = new Fruit((Seller) usersListLoginPage.getList_Person().get(pos),
                    tfSeason,tfPrice,tfAmount,tfName);
        }else if(RBvegetable.isSelected()){
            product_aux = new Vegetable((Seller) usersListLoginPage.getList_Person().get(pos),
                    tfSeason,tfPrice,tfAmount,tfName);
        } else if (RBleafyvegetable.isSelected()) {
            product_aux = new VegetableLeafy((Seller) usersListLoginPage.getList_Person().get(pos),
                    tfSeason,tfPrice,tfAmount,tfName);
        }

        Stage stage = (Stage) this.BTNadd.getScene().getWindow();
        stage.close();
    }

    /**
     * method to transmit the necessary information from the parent controller
     * (metode per a transmetre la informació necessària del controlador pare)
     * @param usersList Object that stores the list of users
     * @param pos position in the list of users who has logged in
     */
    public void SetInfoPage(Users usersList, int pos){
        this.usersListLoginPage = usersList;
        this.pos= pos;
    }

    public Product getProduct_aux() {
        return product_aux;
    }

    public boolean getCreate() {
        return create;
    }

    /**
     * Method that is activated when you hit the bach button, to return to the parent page
     * (Metode que s'activa quan donem al botó de back, per a retornar a la pantalla pare)
     * @param actionEvent Click on the back button
     */
    public void button_click_back(ActionEvent actionEvent) {
        create = false;
        Stage stage = (Stage) this.BTNback.getScene().getWindow();
        stage.close();
        this.product_aux = null;
    }
}
