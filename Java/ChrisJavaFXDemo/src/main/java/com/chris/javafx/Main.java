package com.chris.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField myTextField = new TextField();
        HBox hbox = new HBox();
        hbox.getChildren().add(myTextField);
        HBox.setHgrow(myTextField, Priority.ALWAYS);
        // from =>w WW .yi  I BA I.C O M
        Scene scene = new Scene(hbox, 320, 112, Color.rgb(0, 0, 0, 0));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}