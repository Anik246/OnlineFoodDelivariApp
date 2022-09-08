module com.example.onlinefood {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlinefood to javafx.fxml;
    exports com.example.onlinefood;
}