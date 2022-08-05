package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatSend implements Initializable {
    @FXML
    Button sendButton , attachmentButton;
    @FXML
    TextField textField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sendButton.setOnAction(event -> sendText());
        attachmentButton.setOnAction(event -> attach());
    }

    private void sendText(){
        String text = textField.getText();
        if (!text.equals("")){
            Post post = new Post();
            post.script = text;
            post.usersPostId = RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).userID;
            RegisterMenu.chatOnBord.allTexts.add(post);
        }
    }

    private void attach(){

    }
}
