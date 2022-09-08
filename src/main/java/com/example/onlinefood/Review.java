package com.example.onlinefood;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Review {
    @FXML
    public ImageView okSignImg;
@FXML
public TextField getaddress;
    public void initialize(String text) {
getaddress.setText(text);

    }
}
