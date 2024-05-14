package wolladona.projecte_ed_v2;
import PersonP.SellerP.Freelance;
import PersonP.Users;
import ProductP.Inventary;
import ProductP.Product;
import ProductP.Vegetable;
import Random_Classes.ButtonCellTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *Controller class, which administers the operation of the Seller page
 * @author Pedro Sala Mora
 * @version 1
 */
public class SellerPageController implements Initializable {
    @FXML
    private TableColumn<Product, Void> TCPrice;
    @FXML
    private TableColumn<Product, Void> TCbuttonDelete;
    @FXML
    private TableColumn<Product,Integer> amountColum;
    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product,String> nameC;
    @FXML
    private TableColumn<Product, String> seasonC;
    @FXML
    private Button BTNback;

    private Users usersListSellerPage;
    private int pos;
    private ObservableList<Product> productObservableList;
    private ArrayList<Product> arrayListProduct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListSellerPage = new Users();
        arrayListProduct = new ArrayList<>();

        /**
         * Code to load the information into the table
         */
        productObservableList = FXCollections.observableArrayList();
        this.nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.seasonC.setCellValueFactory(new PropertyValueFactory<>("season"));
        this.amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));
        this.TCPrice.setCellValueFactory(new PropertyValueFactory<>("priceKg"));
        this.TCbuttonDelete.setCellFactory(cell -> new ButtonCellTable());

        try {
            table.setItems(productObservableList);
        } catch (Exception e) {
            System.err.println("Error setting table elements: " + e.getMessage());
        }
    }

    /**
     * method to transmit the necessary information from the parent controller
     * (metode per a transmetre la informació necessària del controlador pare)
     * @param usersList Object that stores the list of users
     * @param pos position in the list of users who has logged in
     * @param arrayListProduct object that stores the products associated with this seller
     */
    public void SetInfoSellerPage(Users usersList, int pos, ArrayList<Product> arrayListProduct){
        usersListSellerPage = usersList;
        this.pos= pos;
        this.arrayListProduct=arrayListProduct;
        productObservableList.addAll(arrayListProduct);
    }

    public ArrayList<Product> getArrayListProduct() {
        arrayListProduct.clear();
        arrayListProduct.addAll(productObservableList);
        return arrayListProduct;
    }

    /**
     * this method, go to the child page and save the created product
     * (aquest metode, direxis a la pagina filla i guarda el producte creat)
     * @param actionEvent Click on the add button
     * @throws IOException Exception if the view does not exist
     */
    public void button_click_Add_Formulari(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(WallaDona.class
                .getResource("AddProduct-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        AddProductController controller = loader.getController();
        controller.SetInfoPage(usersListSellerPage,pos);
        stage.showAndWait();

        if(controller.getCreate()){
            productObservableList.add( controller.getProduct_aux());
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
