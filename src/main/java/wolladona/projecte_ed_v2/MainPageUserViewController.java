package wolladona.projecte_ed_v2;

import PersonP.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageUserViewController implements Initializable {
    @FXML
    private TextField TFtype;
    @FXML
    private TextField TFlocation;
    @FXML
    private Button BTNsearch;
    @FXML
    private Button BTNcistella;
    @FXML
    private TableView table;
    @FXML
    private TableColumn nameC;
    @FXML
    private TableColumn seasonC;
    @FXML
    private TableColumn amountColum;

    private Users usersListUserPage;
    private int pos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void SetInfoClientPage(Users usersList, int pos){
        usersListUserPage = usersList;
        this.pos= pos;
    }



    public void button_click_Add_Cistella(ActionEvent actionEvent) {
    }

    public void button_click_search(ActionEvent actionEvent) {
    }


}
