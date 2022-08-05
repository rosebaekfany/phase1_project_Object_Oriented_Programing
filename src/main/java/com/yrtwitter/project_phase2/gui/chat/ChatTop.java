package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatTop extends SwitchScenes implements Initializable {
    @FXML
    Label nameLabel;
    @FXML
    Button backButton , editButton;
    @FXML
    ImageView profile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name1 = RegisterMenu.chatOnBord.person1.name;
        String name2 = RegisterMenu.chatOnBord.person2.name;
        String chatterName;
        if (name1.equals(RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).name)){
            chatterName = name2;
        }else {
            chatterName = name1;
        }
        nameLabel.setText(chatterName);

        backButton.setOnAction(event -> back());
        editButton.setOnAction(event -> edit());
    }

    private void back(){
        onPage = OnPage.CONTACTS;
        switchScenes("main_page.fxml");
    }

    private void edit(){

    }
}
