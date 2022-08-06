package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
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
    Button backButton , blockButton;
    @FXML
    ImageView profile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name1 = Input.myRegister.chatOnBord.person1.name;
        String name2 = Input.myRegister.chatOnBord.person2.name;
        String chatterName;
        if (name1.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).name)){
            chatterName = name2;
        }else {
            chatterName = name1;
        }
        nameLabel.setText(chatterName);
        backButton.setOnAction(event -> back());

        if (Input.myRegister.chatOnBord.blockState.equals("blocked")){
            blockButton.setText("blocked");
        } else {
            blockButton.setOnAction(event -> block());
            blockButton.setText("block");
        }

    }

    private void back(){
        onPage = OnPage.CONTACTS;
        switchScenes("main_page.fxml");
    }

    private void block(){
        Input.myRegister.chatOnBord.blockState = "blocked";
        blockButton.setText("blocked");
    }
}
