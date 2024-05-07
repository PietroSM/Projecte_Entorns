package wolladona.projecte_ed_v2;

import PersonP.SellerP.Freelance;
import PersonP.Users;
import ProductP.Inventary;
import ProductP.Product;
import ProductP.Vegetable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SellerPageController implements Initializable {


    @FXML
    private TableColumn<Product,Integer> amountColum;
    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product,String> nameC;
    @FXML
    private TableColumn<Product, String> seasonC;

    private Users usersListSellerPage;
    private int pos;
    private Inventary inventaryList;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListSellerPage = new Users();
        inventaryList = new Inventary();
        inventaryList.ReadFile();

        ObservableList<Product> productObservableList = FXCollections.observableArrayList();


        this.nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.seasonC.setCellValueFactory(new PropertyValueFactory<>("season"));
        this.amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));

        productObservableList.addAll(inventaryList.getList_Inventary());

        //productObservableList.add(inventaryList.getList_Inventary().get(0));
        //productObservableList.add(new Vegetable(new Freelance(),"d",43,434,""));

        try {
            table.setItems(productObservableList);
        } catch (Exception e) {
            System.err.println("Error al establecer los elementos de la tabla: " + e.getMessage());
        }

        System.out.println(productObservableList.size());
        //
        System.out.println(inventaryList.getList_Inventary().get(0).getName());

    }


    public void SetInfoSellerPage(Users usersList, int pos){
        usersListSellerPage = usersList;
        this.pos= pos;
    }

}
