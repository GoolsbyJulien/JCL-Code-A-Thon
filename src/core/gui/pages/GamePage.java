package core.gui.pages;

import core.gui.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class GamePage extends Page {


    private Pane createCell(Game game) {
        Pane pane = new Pane();
        HBox hBox = new HBox();
        VBox titleCol = new VBox();
        VBox buttonCol = new VBox();


        // if cant get img from backend
        ImageView img = new ImageView("/img/notFound.png");

        img.setFitWidth(100);
        img.setFitHeight(100);


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


        for (Game g : Game.getDummyList()) {
            pane.getItems().add(createCell(g));

        }

        pane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        pane.getStylesheets().add("style.css");
        return pane;
    }


}
