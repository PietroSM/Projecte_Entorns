package Random_Classes;

import ProductP.Product;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * Class in charge of the delete buttons found in tableviews
 * @author Pedro Sala Mora
 * @version 1
 */
public class ButtonCellTable extends TableCell<Product,Void> {
    private Button button;

    /**builders */
    public ButtonCellTable() {
        this.button = new Button("Delete");
        this.button.setOnAction(event -> {
            Product product = getTableView().getItems().get(getIndex());
            getTableView().getItems().remove(product);
        });
    }

    @Override
    protected void updateItem(Void unused, boolean b) {
        super.updateItem(unused, b);
        if (b) {
            setGraphic(null);
        } else {
            setGraphic(button);
        }
    }
}
