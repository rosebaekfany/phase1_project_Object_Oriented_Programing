package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Chat implements Initializable {
    @FXML
    VBox chatPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader chatTop = new FXMLLoader(Main.class.getResource("chatTop.fxml"));
        FXMLLoader chatSend = new FXMLLoader(Main.class.getResource("chatSend.fxml"));
        FXMLLoader chatContent = new FXMLLoader(Main.class.getResource("private_chat.fxml"));

        try {
            chatPane.getChildren().add(chatTop.load());
            chatPane.getChildren().add(chatContent.load());
            chatPane.getChildren().add(chatSend.load());
        } catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
