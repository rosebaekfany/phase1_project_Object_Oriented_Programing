package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Test extends SwitchScenes implements Initializable{

    @FXML
    AnchorPane pane;
    @FXML
    Button button;

    Panel panel;


    public void initialize(){
        button = new Button("Heloooo" , pane);
        button.setLayoutY(100.0);
        button.setLayoutX(100.0);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button = new Button("Heloooo");
        pane.getChildren().add(button);
        button.getStylesheets().clear();
        button.getStylesheets().add(Main.class.getResource("buttonCSS.css").toExternalForm());

        pane.getStylesheets().add("src/main/resources/com/yrtwitter/project_phase2/paneStyle.html");
        button.setLayoutY(100.0);
        button.setLayoutX(100.0);

//        Main.root.getChildren().clear();
//        //scene = new Scene(Main.root);
//        pane = new AnchorPane(Main.root);
//        scene = new Scene(Main.root);
//        Main.window.setScene(scene);
//        button = new Button("Heloooo" , pane);
//        button.setLayoutY(100.0);
//        button.setLayoutX(100.0);
//        button.getStylesheets().add("src/main/resources/com/yrtwitter/project_phase2/buttonStyle.html");
//        pane.getStylesheets().add("src/main/resources/com/yrtwitter/project_phase2/paneStyle.html");
//        pane.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                scaling();
//            }
//        });
    }

   /* private void scaling(){
        double coef = pane.getWidth() / 800.0;
        button.setFont(Font.font(20*coef));
        double buttonHeight = button.getHeight();
        double buttonWidth = button.getWidth();
        button.setPrefSize(buttonWidth*coef , buttonHeight);
    }*/



//    @FXML
//    Button button;














}
