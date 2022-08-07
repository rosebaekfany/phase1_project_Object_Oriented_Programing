package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.Chat;
import com.yrtwitter.project_phase2.media.Group;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
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


        back.setOnMouseClicked(mouseEvent -> enterChat());

        if (chatNum != -1){
            Chat thisChat = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(chatNum);
            // name
            String name1 = thisChat.person1.name;
            String name2 = thisChat.person2.name;
            String chatterName;
            if (name1.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).name)) {
                chatterName = name2;
                try {
                    Image image = new Image(new FileInputStream(thisChat.person2.profilePath));
                    profile.setImage(image);
                } catch (Exception e) {
                    e.fillInStackTrace();
                }
            } else {
                chatterName = name1;
                try {
                    Image image = new Image(new FileInputStream(thisChat.person1.profilePath));
                    profile.setImage(image);
                } catch (Exception e) {
                    e.fillInStackTrace();
                }
            }
            name.setText(chatterName);

            //text
            text.setText(thisChat.allTexts.get(thisChat.allTexts.size()-1).script);
        }


    }

    public void enterChat(){

        Input.myRegister.chatOnBord = findChat(name.getText());
        SwitchScenes.onPage = OnPage.PRIVATE_CHAT;
        switchScenes("main_page.fxml");

    }


    private Chat findChat (String name){
        for (Chat personalChat : Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats) {
            if (personalChat.person2.name.equals(name) ||
                personalChat.person1.name.equals(name)){
                return personalChat;
            }
        }
        return null;
    }
}
