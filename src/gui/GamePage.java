package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;


public class GamePage
{





    private Pane createCell(Game game){
        Pane pane = new Pane();
        HBox hBox= new HBox();
        VBox titleCol = new VBox();
        VBox buttonCol = new VBox();


        Pane img = new Pane();

        img.setPrefWidth(374 /3);


        img.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        img.setPrefHeight(448/3);



        Text titleText = new Text(game.getName());
        titleText.setFont(new Font(30));
        titleText.setFill(Color.WHITE);

        Text timeText = new Text("Last Played: "+game.getDaysSinceLastPlay() + " days ago");
        timeText.setFont(new Font(21));
        timeText.setFill(Color.WHITE);
        titleCol.getChildren().add(titleText);
        titleCol.getChildren().add(timeText);


        Text sizeText = new Text(game.getSize() + "GB");
        sizeText.setFont(new Font(21));
        sizeText.setFill(Color.WHITE);
        buttonCol.getChildren().add(sizeText);
        buttonCol.getChildren().add(new Button("Uninstall"));

    buttonCol.setPadding(new Insets(0,0,0,300));
        hBox.getChildren().add(img);
        hBox.getChildren().add(titleCol);
        hBox.getChildren().add(buttonCol);
        titleCol.setPadding(new Insets(0,10,0,10));

        pane.getChildren().add(hBox);


        pane.setPrefHeight(300);
        pane.setPrefWidth(300);


        pane.setStyle("  -fx-text-fill: white;-fx-background-color: #20232A;\n");

        //pane.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));

      pane.setPadding(new Insets(50,0,0,0));
        return pane;
    }
public ListView getPane() {
ListView<Pane> pane = new ListView();


pane.getItems().add(createCell(new Game("GTA",234,124)));
    pane.getItems().add(createCell(new Game("Minecraft",0,10)));
    pane.getItems().add(createCell(new Game("CK2",442,4)));
    pane.getItems().add(createCell(new Game("",4,3)));
    pane.getItems().add(createCell(new Game("Test",4,3)));
    pane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
    pane.getStylesheets().add("style.css");
    return pane;
}


}
