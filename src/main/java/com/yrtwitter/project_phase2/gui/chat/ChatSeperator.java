package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatSeperator implements Initializable {
    @FXML
    Tab personalTab, groupTab;
    @FXML
    VBox personal , group;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalTab.closableProperty().set(false);
        groupTab.closableProperty().set(false);
        FXMLLoader groupLoader ;
        FXMLLoader personalLoader ;
        if(!SwitchScenes.darkTheme){
            groupLoader = new FXMLLoader(Main.class.getResource("myGroupsLight.fxml"));
            personalLoader = new FXMLLoader(Main.class.getResource("myChatsLight.fxml"));
        }
        else {
            groupLoader = new FXMLLoader(Main.class.getResource("myGroups.fxml"));
            personalLoader = new FXMLLoader(Main.class.getResource("myChats.fxml"));
        }
        try {
            personal.getChildren().add(personalLoader.load());
            group.getChildren().add(groupLoader.load());
        } catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
