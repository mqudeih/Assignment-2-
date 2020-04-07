/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author LTC2020
 */
public class A extends Application {

    private ListView<String> listView1, listView2;
    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        listView1 = new ListView<>();
        button = new Button("Copy>>>");
        listView2 = new ListView<>();

        HBox hBox = new HBox(15, listView1, button, listView2);

        hBox.setAlignment(Pos.CENTER);

        Scene Scene = new Scene(hBox, 600, 500);
        primaryStage.setTitle("Multibul Selection Lists");
        primaryStage.setScene(Scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        listView1.getItems().addAll("White", "Black", "Red", "Blue", "Pink", "Yellow", "Green", "Gray", "Lightblue");
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        eventHandler1 event = new eventHandler1();
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, event);

    }

    private class eventHandler1 implements EventHandler<Event> {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        @Override
        public void handle(Event event) {
            if (event.getSource() == button) {
                ArrayList<String> item = new ArrayList<>();
                item.addAll(listView1.getSelectionModel().getSelectedItems());

                listView2.getItems().setAll(item);
                if (item.isEmpty() == true) {
                    alert.setTitle("WARNING ABOUT INFORMATION");
                    alert.setContentText("NOT Selsectiom Item");
                    alert.showAndWait();
                }
            }

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
