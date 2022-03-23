package gui;

import gui.pages.GamePage;
import gui.pages.PieChartPage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Window extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane rootPane = new BorderPane();
        rootPane.getStyleClass().add("root");

        VBox tabPane = new VBox();
        tabPane.setPrefWidth(150);
        tabPane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 5, 0, 0))));


        Button gamePageTab = new Button("GP");
        gamePageTab.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootPane.setCenter(new GamePage().getPane());
            }
        });
        Button piePageTab = new Button("Pie");
        piePageTab.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootPane.setCenter(new PieChartPage().getPane());
            }
        });


        tabPane.getChildren().add(gamePageTab);
        tabPane.getChildren().add(piePageTab);

        rootPane.setLeft(tabPane);
        rootPane.setCenter(new GamePage().getPane());


        Scene mainScene = new Scene(rootPane, 1280, 720);
        mainScene.getStylesheets().add("style.css");

        primaryStage.setTitle("Window");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}


