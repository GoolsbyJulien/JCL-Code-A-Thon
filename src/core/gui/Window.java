package core.gui;

import core.Project;
import core.gui.pages.GamePage;
import core.gui.pages.PieChartPage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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


        GridPane grid = new GridPane();

        Scene loginScreen = new Scene(grid, 600, 800);
        Scene mainScene = new Scene(rootPane, 1280, 720);

        grid.getStyleClass().add("root");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Login");
        sceneTitle.setFill(Color.WHITE);

        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        userName.setTextFill(Color.WHITE);
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.WHITE);
        grid.add(passwordLabel, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);


        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        mainScene.getStylesheets().add("style.css");
        loginScreen.getStylesheets().add("style.css");

        primaryStage.setTitle(Project.PROJECT_NAME);
        primaryStage.setScene(loginScreen);
        primaryStage.show();
    }
}


