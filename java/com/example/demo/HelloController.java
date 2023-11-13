package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView field;

    @FXML
    private Button playBtn;

    @FXML
    private Label welcomeText;

    @FXML
    void start_play(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Config.class.getResource("sign-up-player.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 336.5);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
    }


    @FXML
    void initialize() {}

}
