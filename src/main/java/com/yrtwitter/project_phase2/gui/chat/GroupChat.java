package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupChat implements Initializable {
    @FXML
    VBox chatPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader chatTop = new FXMLLoader(Main.class.getResource("groupTop2.fxml"));
        FXMLLoader chatContent = new FXMLLoader(Main.class.getResource("groupBottom.fxml"));

        try {
            chatPane.getChildren().add(chatTop.load());
            chatPane.getChildren().add(chatContent.load());
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
