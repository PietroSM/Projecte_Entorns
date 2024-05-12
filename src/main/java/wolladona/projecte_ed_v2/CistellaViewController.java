package wolladona.projecte_ed_v2;

import PersonP.Users;
import ProductP.Inventary;
import ProductP.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class that handles the operation and events of the Cistella page
 * @author Pedro Sala Mora
 * @version 1
 */
public class CistellaViewController implements Initializable {
    @FXML
    private Button BTNpurchase;
    @FXML
    private Button BTNback;
    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product, String> nameC;
    @FXML
    private TableColumn<Product, String> seasonC;
    @FXML
    private TableColumn<Product, Void> TCPrice;
    @FXML
    private TableColumn<Product, Integer> amountColum;
    @FXML
    private TableColumn<Product, String> TClocation;
    @FXML
    private TextField TFpurchase;

    private ObservableList<Product> productObservableList;
    private ArrayList<Product> productArrayList;
    private int pos;
    private  Users usersListUserPage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productArrayList = new ArrayList<>();
        pos = 0;
        usersListUserPage = new Users();
        TFpurchase.setEditable(false);

        /**
         * Code to load the information into the table
         */
        productObservableList = FXCollections.observableArrayList();
        this.nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.seasonC.setCellValueFactory(new PropertyValueFactory<>("season"));
        this.amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));
        this.TCPrice.setCellValueFactory(new PropertyValueFactory<>("priceKg"));
        this.TClocation.setCellValueFactory(new PropertyValueFactory<>("productorLocation"));

        try {
            table.setItems(productObservableList);
        } catch (Exception e) {
            System.err.println("Error setting table elements: " + e.getMessage());
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

    /**
     * Method responsible for receiving information from the parent controller
     * (Metode encarregat de rebre l'informació del constrolador pare)
     * @param usersList class with all users
     * @param pos position of the logged-in user
     * @param productArrayList List of selected products
     */
    public void SetInfoClientPage(Users usersList, int pos,
                                  ArrayList<Product> productArrayList){
        usersListUserPage = usersList;
        this.pos= pos;
        this.productArrayList=productArrayList;

        productObservableList.addAll(productArrayList);
        TFpurchase.setText(String.valueOf(Inventary.CalculatePrice(productArrayList)) +" €");
    }


    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }


    /**
     * Method that is activated when we click the BTNpurchase button and show the purchase made
     * (Metode que s'activa quan cliquem el botó BTNpurchase i mostrar la compra realitzada)
     * @param actionEvent Click on the pruchase button
     */
    public void button_click_purchase(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Purchase");
        alert.setContentText("Purchase made, total: " + TFpurchase.getText());
        alert.showAndWait();
        productArrayList.clear();
        Stage stage = (Stage) this.BTNpurchase.getScene().getWindow();
        stage.close();
    }
}
