package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.Chat;
import com.yrtwitter.project_phase2.media.Group;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EachContact extends MyChats implements Initializable {

    @FXML
    ImageView profile;
    @FXML
    HBox back;
    @FXML
    Label name , text;
    @FXML
    Label unreadNum;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (chatNum != -1){
            Chat thisChat = RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).allPersonalChats.get(chatNum);
            // name
            String name1 = thisChat.person1.name;
            String name2 = thisChat.person2.name;
            String chatterName;
            if (name1.equals(RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).name)) {
                chatterName = name2;
            } else {
                chatterName = name1;
            }
            name.setText(chatterName);

            //text
            text.setText(thisChat.allTexts.get(thisChat.allTexts.size()-1).script);
        }
        if (groupNum != -1){
            Group thisGroup = RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).allMyGroap.get(groupNum);
            // name
            name.setText(thisGroup.groupName);

            //text
            text.setText(thisGroup.allTexts.get(thisGroup.allTexts.size()-1).script);
        }

    }

    public void enterChat(){

        RegisterMenu.chatOnBord = findChat(name.getText());
        SwitchScenes.onPage = OnPage.PRIVATE_CHAT;
        switchScenes("main_page.fxml");

    }

    private Chat findChat (String name){
        for (Chat personalChat : RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).allPersonalChats) {
            if (personalChat.person2.name.equals(name) ||
                personalChat.person1.name.equals(name)){
                return personalChat;
            }
        }
        return null;
    }
}
