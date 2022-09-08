package com.example.onlinefood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class FoodItemController {
@FXML
    ImageView fruitimage,pimage,chickenimage;
    @FXML
    private VBox ChosenFruitCard;


@FXML
private TextField taking;

    @FXML
    private Label fruitnameLabel,fruitpricelabel,chickenname,chickenprice;



    @FXML
    private VBox pizza;

    @FXML
    private Label pizzaname;

    @FXML
    private Label pizzaprice;
    String pprice;
    public void pizzaAction(MouseEvent event) {

fruitimage.setImage(pimage.getImage());
fruitnameLabel.setText(pizzaname.getText());
fruitpricelabel.setText(pizzaprice.getText());
pprice=fruitpricelabel.getText();
    }
    String cprice;
    public void chickenAction(MouseEvent event) {

        fruitimage.setImage(chickenimage.getImage());
        fruitnameLabel.setText(chickenname.getText());
        fruitpricelabel.setText(chickenprice.getText());
        cprice=fruitpricelabel.getText();
    }

    public void friedriceAction(MouseEvent event) {
    }

    public void sharmaAction(MouseEvent event) {
    }

    public void burgerAction(MouseEvent event) {
    }


    public void addcart(ActionEvent event) {

        if(chickenprice.getText().equals(cprice)){
            int totalprice=Integer.parseInt(cprice)*Integer.parseInt(taking.getText());
            System.out.println(totalprice);
        } else if (pizzaprice.getText().equals(pprice)) {
            int totalprice=Integer.parseInt(pprice)*Integer.parseInt(taking.getText());
            System.out.println(totalprice);
        }
    }
}
