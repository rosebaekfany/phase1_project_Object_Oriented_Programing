package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.Post;
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
        FXMLLoader chatTop ;
        FXMLLoader chatContent ;
        if(!SwitchScenes.darkTheme){
            chatTop = new FXMLLoader(Main.class.getResource("chatTopLight.fxml"));
            chatContent = new FXMLLoader(Main.class.getResource("chatBottomLight.fxml"));
        }
        else {
            chatTop = new FXMLLoader(Main.class.getResource("chatTop.fxml"));
            chatContent = new FXMLLoader(Main.class.getResource("chatBottom.fxml"));
        }

        try {
            chatPane.getChildren().add(chatTop.load());
            chatPane.getChildren().add(chatContent.load());
        } catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
