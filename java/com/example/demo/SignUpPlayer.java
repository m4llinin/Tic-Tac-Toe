package com.example.demo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpPlayer {

    @FXML
    private TextField inputName1;

    @FXML
    private TextField inputName2;

    public static String name1;
    public static String name2;

    @FXML
    void startGame(ActionEvent event) throws IOException {

        name1 = inputName1.getText();
        name2 = inputName2.getText();

        FXMLLoader fxmlLoader = new FXMLLoader(Config.class.getResource("game_field.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 336.5);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
    }

    @FXML
    void initialize() {
    }

}
