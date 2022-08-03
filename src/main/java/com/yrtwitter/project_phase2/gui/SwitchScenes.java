package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.media.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SwitchScenes {

    public static Stage window = new Stage();
    public boolean darkTheme = true;

    public static OnPage onPage;


    public void switchScenes (String[] fxmls){

    }


    public void switchScenes (String fxml) {
        double preWidth = window.getWidth();
        double preHeight = window.getHeight();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            SwitchScenes.window.setTitle("Rosa_Yekta_Twitter");
            SwitchScenes.window.setScene(scene);
            window.setHeight(preHeight);
            window.setWidth(preWidth);
            SwitchScenes.window.show();
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }


    }



    public static void warning(String warn , Label guide) {
        guide.setTextFill(Color.RED);
        //guide.setFont(Font.font(18.0));
        guide.setText(warn);
    }

    public static void texting(String txt , Label guide) {
        guide.setTextFill(Color.rgb(212 , 215 , 227));
        guide.setText(txt);
        //guide.setFont(Font.font("System", FontWeight.BOLD, 30.0));
    }


}
