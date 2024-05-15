module com.example.ficheros {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ficheros to javafx.fxml;
    exports com.example.ficheros;
}