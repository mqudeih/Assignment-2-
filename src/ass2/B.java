/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LTC2020
 */
public class B extends Application {

    private TextField textField;
    private Label message, temp;

    @Override
    public void start(Stage primaryStage) throws Exception {

        textField = new TextField();
        message = new Label("Enter Celsius Temprature");
        temp = new Label("");
        RadioButton choise1 = new RadioButton("Fahrenheit");
        RadioButton choise2 = new RadioButton("Kelvin");
        choise1.setSelected(true);
        ToggleGroup myToggle = new ToggleGroup();
        choise1.setToggleGroup(myToggle);
        choise2.setToggleGroup(myToggle);
        HBox hbox1 = new HBox(choise1, choise2);
        hbox1.setAlignment(Pos.CENTER);

        choise1.setOnAction(event -> {
            temp.setText("New Temprature in is:" + ((Double.parseDouble(textField.getText()) * (1.8)) + 32));
        });
        choise2.setOnAction(event -> {
            temp.setText("New Temprature in is:" + ((Double.parseDouble(textField.getText()) + 273.15)));
        });

        VBox vBox = new VBox(4, message, textField, hbox1, temp);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 300, 350);
        primaryStage.setTitle("Temprature Converter");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
