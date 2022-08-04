package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPage extends SwitchScenes implements Initializable {
    @FXML
    HBox mainPane;
    @FXML
    VBox menuPane;
    @FXML
    VBox contentPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("menu.fxml"));
        FXMLLoader fxmlLoader2;


        switch (onPage){
            //case START -> fxmlLoader2 =  new FXMLLoader(Main.class.getResource("startPage.fxml"));
            case HOME -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("home.fxml"));
            }
            case MY_PAGE -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("myPage.fxml"));
            }
            case SEARCH -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("search.fxml"));
            }
            case CONTACTS -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("myChats.fxml"));
            }
            case SETTING -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("setting.fxml"));
            }
            case GROUP_CHAT -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("group_chat.fxml"));
            }
            case PRIVATE_CHAT -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                fxmlLoader2 = new FXMLLoader(Main.class.getResource("chat.fxml"));
            }
            default -> fxmlLoader2 =  new FXMLLoader(Main.class.getResource("startPage.fxml"));
        }

        try {
            Node node1 = fxmlLoader1.load();
            Node node2 = fxmlLoader2.load();
            contentPane.getChildren().add(node2);
            menuPane.getChildren().add(node1);
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}