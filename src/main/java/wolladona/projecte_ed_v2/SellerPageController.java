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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class SellerPageController implements Initializable {
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

    private Users usersListSellerPage;
    private int pos;
    //private Inventary inventaryList;
    private ObservableList<Product> productObservableList;
    private ArrayList<Product> arrayListProduct;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usersListSellerPage = new Users();
        arrayListProduct = new ArrayList<>();
        //inventaryList = new Inventary();
        //inventaryList.ReadFile();

        productObservableList = FXCollections.observableArrayList();

        this.nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.seasonC.setCellValueFactory(new PropertyValueFactory<>("season"));
        this.amountColum.setCellValueFactory(new PropertyValueFactory<>("amount"));
        this.TCbuttonDelete.setCellFactory(cell -> new ButtonCellTable());


        //productObservableList.addAll(inventaryList.getList_Inventary());



        try {
            table.setItems(productObservableList);
        } catch (Exception e) {
            System.err.println("Error al establecer los elementos de la tabla: " + e.getMessage());
        }

    }


    public void SetInfoSellerPage(Users usersList, int pos, ArrayList<Product> arrayListProduct){
        usersListSellerPage = usersList;
        this.pos= pos;
        this.arrayListProduct=arrayListProduct;
        productObservableList.addAll(arrayListProduct);
    }

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

        productObservableList.add( controller.getProduct_aux());


    }




}
