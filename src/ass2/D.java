/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LTC2020
 */
public class D extends Application {

    private static PrintWriter output;
    private Scene s1, s2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l1 = new Label("Welcom");
        TextField t1 = new TextField();
        Label l2 = new Label("User Name:", t1);
        TextField t2 = new TextField();
        Label l3 = new Label("Password:", t2);
        Button b1 = new Button("Sign in");
        Button b2 = new Button("Exite");
        HBox h1 = new HBox(10, b1, b2);
        Pane p1 = new VBox(15, l1, l2, l3, h1);
        ((VBox) p1).setAlignment(Pos.CENTER);
        p1.setStyle("-fx-background-color:gray");
        h1.setAlignment(Pos.CENTER);
        s1 = new Scene(p1, 350, 450);
        primaryStage.setScene(s1);
        b1.setOnAction(event -> {
            String text1 = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader("src/AssimentJava/pass.data"));

                String line = "";
                while ((line = br.readLine()) != null) {
                    text1 += line;
                }
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
            }

            MessageDigest md1;
            String myHash1 = null;
            try {
                md1 = MessageDigest.getInstance("MD5");
                md1.update(t2.getText().getBytes());
                byte[] digests = md1.digest();
                myHash1 = DatatypeConverter.printHexBinary(digests);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(D.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (myHash1.equals(text1)) {
                primaryStage.setScene(s2);
                primaryStage.setTitle("Optinal Page");
            }
        });

        Button b3 = new Button("Add student");
        Button b4 = new Button("View student");
        Pane p2 = new VBox(7, b3, b4);
        ((VBox) p2).setAlignment(Pos.CENTER);
        s2 = new Scene(p2, 350, 450);
        p2.setStyle("-fx-background-color:gray");
        primaryStage.setTitle("Login Page");
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {
        String password = "123456";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);
        System.out.println(myHash);
        output = new PrintWriter(new File("src/AssimentJava/pass.data"));
        output.write(myHash);
        output.close();
        launch(args);
    }

}
