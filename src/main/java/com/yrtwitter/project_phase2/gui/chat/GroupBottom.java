package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Group;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupBottom extends SwitchScenes implements Initializable {
    @FXML
    Button sendButton , attachmentButton;
    @FXML
    TextField textField;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox chatContent;
    @FXML
    Label guideLabel;

    Image img;

    Person me = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount);
    public void sendText(){
        String text = textField.getText();
        if (!text.equals("")){
            if (Input.myRegister.grouponBord.bannedUsers.contains(me)){
                textField.setText("YOU ARE BANNED");
            } else {
                Group.DMing(Input.myRegister.grouponBord , Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount) , text);
                onPage = OnPage.GROUP_CHAT;
                switchScenes("main_page.fxml");
//                Post post = new Post();
//                post.script = text;
//                post.usersPostId = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID;
//                Input.myRegister.chatOnBord.allTexts.add(post);
//                textField.setText("");


                // ToDo set text and picture
            }
        }
    }

    public void attach(){
        String imgPath = textField.getText();
        if (imgPath.equals("")){
            return;
        }
        try {
            img = new Image(new FileInputStream(imgPath));
        } catch (FileNotFoundException e){
            guideLabel.setVisible(true);
            guideLabel.setText("file not found");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Post allText : Input.myRegister.grouponBord.allTexts) {
            FXMLLoader messageLoader ;
            Message.recentPost = allText;
            if(!SwitchScenes.darkTheme){
                messageLoader = new FXMLLoader(Main.class.getResource("messageLight.fxml"));
            }
            else{
                messageLoader = new FXMLLoader(Main.class.getResource("message.fxml"));
            }
            try {
                chatContent.getChildren().add(messageLoader.load());
            } catch (Exception e){
                e.fillInStackTrace();
            }
        }
    }
}
