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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListLoginPage = new Users();

    }



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

    public void SetInfoPage(Users usersList, int pos){
        this.usersListLoginPage = usersList;
        this.pos= pos;
    }

    public Product getProduct_aux() {
        return product_aux;
    }

    public void button_click_back(ActionEvent actionEvent) {
        Stage stage = (Stage) this.BTNback.getScene().getWindow();
        stage.close();
        this.product_aux = null;
    }
}
