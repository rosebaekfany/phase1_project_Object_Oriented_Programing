package com.yrtwitter.project_phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Group root = new Group();
        root.getChildren().add(scene.getRoot());
        stage.setTitle("rosy");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();

        view.Input myInput = new view.Input() ;
        myInput.register_menu();
        while (myInput.registerMenu==1){
            myInput.inputRegister();
        }
    }
}

// ToDO : css stylesheet ->
//                          .selected { -fx-background-color : #color }
//                          .mouse-moved: hover { -fx-background-color : #color }
//      then add this to the buttons stylesheet in sceneBuilder