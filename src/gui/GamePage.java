package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.awt.*;


public class GamePage extends Page {


    private Pane createCell(Game game) {
        Pane pane = new Pane();
        HBox hBox = new HBox();
        VBox titleCol = new VBox();
        VBox buttonCol = new VBox();


        // if cant get img from backend
        ImageView img = new ImageView("/img/notFound.png");

        img.setFitWidth(374 / 3);
        img.setFitHeight(448 / 3);


        Text titleText = new Text(game.getNameAbbreviated());

        titleText.setFont(new Font(30));
        titleText.setFill(Color.WHITE);
        Text timeText = new Text("Last Played: " + game.getDaysSinceLastPlay() + " days ago");
        timeText.setFont(new Font(21));
        timeText.setFill(Color.WHITE);
        titleCol.getChildren().add(titleText);
        titleCol.getChildren().add(timeText);
        titleCol.setPadding(new Insets(0, 10, 0, 10));


        Text sizeText = new Text(game.getSize() + "GB");
        sizeText.setTextAlignment(TextAlignment.CENTER);
        Button uninstallButton = new Button("Uninstall");
        uninstallButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Uninstalling " + game.getName());
            }
        });
        uninstallButton.setPadding(new Insets(20));
        uninstallButton.setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        buttonCol.setAlignment(Pos.CENTER);
        sizeText.setFont(new Font(21));
        sizeText.setFill(Color.WHITE);
        buttonCol.getChildren().add(sizeText);
        buttonCol.getChildren().add(uninstallButton);

        titleCol.setPrefWidth(500);
        Pane spacer = new Pane();
        spacer.setPrefWidth(300);
        hBox.getChildren().add(img);
        hBox.getChildren().add(titleCol);

        hBox.getChildren().add(buttonCol);

        pane.getChildren().add(hBox);
        pane.setPrefHeight(300);
        pane.setPrefWidth(300);
        pane.setStyle("  -fx-text-fill: white;-fx-background-color: #20232A;\n");
        //pane.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        pane.setPadding(new Insets(50, 0, 0, 0));
        return pane;
    }

    public Parent getPane() {
        ListView<Pane> pane = new ListView();

        pane.getItems().add(createCell(new Game("GTA", 234, 124)));
        pane.getItems().add(createCell(new Game("Minecraft", 0, 10)));
        pane.getItems().add(createCell(new Game("CK2", 442, 4)));
        pane.getItems().add(createCell(new Game("Red Dead Redemption 2", 4, 3)));
        pane.getItems().add(createCell(new Game(" Tales of Monkey Island Complete Pack: Chapter 4 – The Trial and Execution of Guybrush Threepwood", 4, 3)));

        pane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        pane.getStylesheets().add("style.css");
        return pane;
    }


}
