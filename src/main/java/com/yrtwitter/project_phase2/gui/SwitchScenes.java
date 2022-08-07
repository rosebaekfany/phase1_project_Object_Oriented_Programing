package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwitchScenes {

    public static Stage window = new Stage();
    public static boolean darkTheme = true;
    public static OnPage onPage;


    public void switchScenes (String[] fxmls){

    }


    public void switchScenes (String fxml) {
        double preWidth = window.getWidth();
        double preHeight = window.getHeight();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
//        if(darkTheme){
            fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
//        } else {
//            String regexStr = "(.+).fxml";
//            Pattern pattern = Pattern.compile(regexStr);
//            Matcher matcher = pattern.matcher(fxml);
//            String fxml2 = matcher.group(0);
//            String fxmlfinal = fxml2 + "Light.fxml";
//            fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlfinal));
//        }
        try {
            Scene scene = new Scene(fxmlLoader.load() );
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
