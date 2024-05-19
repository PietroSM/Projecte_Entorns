package wolladona.projecte_ed_v2;

import PersonP.SellerP.Seller;
import PersonP.Users;
import ProductP.Product;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class to control the inventions of MainPageUser View
 * @author Pedro Sala Mora
 * @version 1
 */
public class MainPageUserViewController implements Initializable {

    @FXML
    private Button BTNback;
    @FXML
    private TextField TFtype;
    @FXML
    private TextField TFlocation;
    @FXML
    private Button BTNsearch;
    @FXML
    private Button BTNcistella;
    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product, String> nameC;
    @FXML
    private TableColumn<Product, String> seasonC;
    @FXML
    private TableColumn<Product, Integer> amountColum;
    @FXML
    private TableColumn<Product, Void> TCPrice;
    @FXML
    private TableColumn<Product, String> TClocation;
    @FXML
    private TableColumn<Product, Boolean> TCbuy;

    private Users usersListUserPage;
    private int pos;
    private ArrayList<Product> productArrayList;
    private ObservableList<Product> productObservableList;
    private ObservableList<Product> productsFiltrer;
    private ObservableList<Product> productsFiltrerLocation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productArrayList = new ArrayList<>();
        pos = 0;
        usersListUserPage = new Users();

        /**
         * Code to load the information into the table
         */
        productObservableList = FXCollections.observableArrayList();

        this.nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.seasonC.setCellValueFactory(new PropertyValueFactory<>("season"));
        this.amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));
        this.TCPrice.setCellValueFactory(new PropertyValueFactory<>("priceKg"));
        this.TClocation.setCellValueFactory(new PropertyValueFactory<>("productorLocation"));
        this.TCbuy.setCellValueFactory(new PropertyValueFactory<>("checked"));

        try {
            table.setItems(productObservableList);
        } catch (Exception e) {
            System.err.println("Error setting table elements: " + e.getMessage());
        }


        productsFiltrer = FXCollections.observableArrayList();
        productsFiltrerLocation = FXCollections.observableArrayList();

    }

    /**
     * method used to receive the necessary data from the parent controller
     * (metode que serveix per a rebre les dades necessaries del controllador pare)
     * @param usersList Objecte que conté els usuaris
     * @param pos position in the list of users who has logged in
     * @param productArrayList list of products we have available
     */
    public void SetInfoClientPage(Users usersList, int pos,
                                  ArrayList<Product> productArrayList){
        usersListUserPage = usersList;
        this.pos= pos;
        this.productArrayList=productArrayList;

        productObservableList.addAll(productArrayList);

    }

    public ArrayList<Product> getproductArrayList() {
        productArrayList.clear();
        productArrayList.addAll(productObservableList);
        return productArrayList;
    }


    /**
     * method to go to the basket view, and send an arraylist with the selected items
     * (metode per a dirigirse a la la vista de la cistella, i enviar una arraylist amb els elements selecionats)
     * @param actionEvent the click of the BTNcistella button
     * @throws IOException catch the exception if the view does not exist
     */
    public void button_click_Add_Cistella(ActionEvent actionEvent) throws IOException {
        ArrayList<Product> array_aux = new ArrayList<>();
        for (int i = 0; i < productObservableList.size(); i++) {
            if(productObservableList.get(i).getChecked().isSelected()){
                array_aux.add(productObservableList.get(i));
            }
        }

        FXMLLoader loader = new FXMLLoader(WallaDona.class.
                getResource("Cistella-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cistella Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        ArrayList<Product> arrayListNochecked = new ArrayList<>();
        for (int i = 0; i < productObservableList.size(); i++) {
            if(!(productObservableList.get(i).getChecked().isSelected())){
                arrayListNochecked.add(productObservableList.get(i));
            }
        }

        productObservableList.clear();
        CistellaViewController controller = loader.getController();
        controller.SetInfoClientPage(usersListUserPage,pos,array_aux);
        stage.showAndWait();

        productObservableList.addAll(arrayListNochecked);
        productObservableList.addAll(controller.getProductArrayList());
    }


    /**
     * method that updates the list by type of fruit
     * (metode que actualitza la llista per el tipo de fruta)
     * @param keyEvent jumps when typed in the text field
     */
    public void typefiltre_Released(KeyEvent keyEvent) {
        String filtre = this.TFtype.getText();

        if(filtre.isEmpty()){
            this.table.setItems(productObservableList);
        }else{
            this.productsFiltrer.clear();
            for (int i = 0; i < productObservableList.size(); i++) {
                if(productObservableList.get(i).getName().toLowerCase()
                        .contains(filtre.toLowerCase())){
                    this.productsFiltrer.add(productObservableList.get(i));
                }
            }
            this.table.setItems(productsFiltrer);
        }
    }

    /**
     * method that updates the list by location
     * (metode que actualitza la llista per la localització)
     * @param keyEvent jumps when typed in the text field
     */
    public void locationfiltre_Released(KeyEvent keyEvent) {
        String filtre = this.TFlocation.getText();

        if(filtre.isEmpty()){
            this.table.setItems(productObservableList);
        }else{
            this.productsFiltrerLocation.clear();
            for (int i = 0; i < productObservableList.size(); i++) {
                if(productObservableList.get(i).getProductorLocation().toLowerCase()
                        .contains(filtre.toLowerCase())){
                    this.productsFiltrerLocation.add(productObservableList.get(i));
                }
            }
            this.table.setItems(productsFiltrerLocation);
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
