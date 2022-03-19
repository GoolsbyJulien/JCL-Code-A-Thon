package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {
    @Override
    public void start(Stage primaryStage)  {

        BorderPane rootPane = new BorderPane();
        rootPane.getStyleClass().add("root");

        VBox tabPane = new VBox();
        Pane pane = new Pane();

        tabPane.setPrefWidth(150);
        tabPane.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 10, 0, 0))));
        rootPane.setLeft(tabPane);
        rootPane.setCenter(pane);

        Scene mainScene = new Scene(rootPane, 1280, 720);
        mainScene.getStylesheets().add("style.css");

        primaryStage.setTitle("Window");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
