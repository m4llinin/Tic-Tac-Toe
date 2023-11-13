package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinGame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label winner;

    @FXML
    void GameBtnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Config.class.getResource("game_field.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 336.5);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
    }

    @FXML
    void initialize() {
        if (GameField.winner == 1) {
            winner.setText("Выиграл " + SignUpPlayer.name1);
            winner.setAlignment(Pos.CENTER);
        } else if (GameField.winner == 0){
            winner.setText("Выиграл " + SignUpPlayer.name2);
            winner.setAlignment(Pos.CENTER);
        } else {
            winner.setText("Ничья!");
            winner.setAlignment(Pos.CENTER);
        }
    }
}
