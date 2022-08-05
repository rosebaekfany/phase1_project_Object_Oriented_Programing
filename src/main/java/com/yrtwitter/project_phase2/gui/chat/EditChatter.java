package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditChatter extends SwitchScenes {
    @FXML
    Button backButton , changeButton , blockButton;
    @FXML
    TextField newNameField;

    public void back(){
        onPage = OnPage.CONTACTS.PRIVATE_CHAT;
        switchScenes("main_page.fxml");
    }

    public void changeName(){
        String myId = RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).userID;
        String newName = newNameField.getText();
        if (newName.equals("")) {
            return;
        }
        if (RegisterMenu.chatOnBord.person1.equals(myId)){
            RegisterMenu.chatOnBord.person2.name = newName;
        } else {
            RegisterMenu.chatOnBord.person1.name = newName;
        }
    }

    public void block(){

    }
}
