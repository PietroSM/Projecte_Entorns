module wolladona.projecte_ed_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens wolladona.projecte_ed_v2 to javafx.fxml;
    opens ProductP;
    exports wolladona.projecte_ed_v2;
}