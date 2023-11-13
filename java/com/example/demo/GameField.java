package com.example.demo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameField {

    @FXML
    private Label gameLabel;

    public static byte winner;
    private short curPlayer = 1;
    private char curSym = 'x';
    private String curGameLabel = "Ходит " + SignUpPlayer.name1;
    private char[][] gameField = new char[][]{{'a','b','c'},{'e','f','g'},{'v','h','l'}};
    
    @FXML
    void GameBtnCLick(ActionEvent actionEvent) throws InterruptedException, IOException {
        Button btn = (Button)actionEvent.getSource();
        String curText = btn.getText();

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0: GridPane.getColumnIndex(btn);

        if (curText.isEmpty()){
            btn.setText(String.valueOf(curSym));

            gameField[rowIndex][columnIndex] = curSym;

            if (isWin(gameField)){
                winner = (byte)curPlayer;
                FXMLLoader fxmlLoader = new FXMLLoader(Config.class.getResource("win-game.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600.0, 336.5);
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
            } else if (IsGameEnd(gameField)){
                winner = 2;
                FXMLLoader fxmlLoader = new FXMLLoader(Config.class.getResource("win-game.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600.0, 336.5);
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
            }

            if (curPlayer == 0)
                curGameLabel = "Ходит " + SignUpPlayer.name1;
            else
                curGameLabel = "Ходит " + SignUpPlayer.name2;
            gameLabel.setText(curGameLabel);
            gameLabel.setAlignment(Pos.CENTER);

            curPlayer = (short)(curPlayer == 1 ? 0 : 1);
            curSym = curSym == 'x' ? 'o': 'x';
        }else{
            gameLabel.setText("Сюда сходить нельзя");
            gameLabel.setAlignment(Pos.CENTER);
        }
    }

    private boolean isWin(char[][] gameField){
        for (int i=0; i<3; i++){
            if (gameField[i][0] == gameField[i][1] && gameField[i][1]== gameField[i][2])
                return true;
        }
        for (int i=0; i<3; i++){
            if (gameField[0][i] == gameField[1][i] && gameField[1][i]== gameField[2][i])
                return true;
        }
        if (gameField[0][0] == gameField[1][1] && gameField[1][1]== gameField[2][2])
            return true;
        return gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0];
    }

    private boolean IsGameEnd(char[][] gameField){
        short counter = 0;
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                if (gameField[i][j] == 'x' || gameField[i][j] == 'o')
                    counter++;
            }
        }
        return counter == 9;
    }

    @FXML
    void initialize() {
        gameLabel.setText(curGameLabel);
        gameLabel.setAlignment(Pos.CENTER);
    }
}
