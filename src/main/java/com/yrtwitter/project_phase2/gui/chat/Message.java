package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.media.Chat;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Message extends SwitchScenes implements Initializable {
    @FXML
    ImageView profile;
    @FXML
    VBox messagePane;
    @FXML
    Label replyLabel ,  forwardLabel , nameLabel , textLabel , dateLabel;
    @FXML
    Button replyButton , forwardButton , likeButton , editButton , deleteButton;
    @FXML
    TextField forwardTextField , editTextField , replyTextField;

    Chat myChat = Input.myRegister.chatOnBord;
    Person me = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount);

    public static Post recentPost;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        if(recentPost.forwarded.equals("forwarded")){
//            forwardLabel.setText("forwarded");
//        } else {
//            forwardLabel.setText("");
//        }
//        if (recentPost.edited.equals("edited")){
//            replyLabel.setText("edited");
//        } else {
//            replyLabel.setText("");
//        }
        replyLabel.setText(recentPost.edited);
        forwardLabel.setText(recentPost.forwarded);
        nameLabel.setText(recentPost.usersPostId);
        textLabel.setText(recentPost.script);
        dateLabel.setText(recentPost.postDate.toString());
        try {
            Image image = new Image(new FileInputStream(Person.findPerson(recentPost.usersPostId).profilePath));
            profile.setImage(image);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        if (!recentPost.usersPostId.equals(me.userID)){
            deleteButton.setVisible(false);
            editButton.setVisible(false);
            editTextField.setVisible(false);
        }

        //replyButton.setOnAction(event -> Communication.replyChat(myChat , post , me ,));
        editButton.setOnAction(event -> editText());
        forwardButton.setOnAction(event -> forward());
        replyButton.setOnAction(event -> reply());
        deleteButton.setOnAction(event -> delete());
        likeButton.setOnAction(event -> like());
    }

    private void reply(){
        String replyText = replyTextField.getText();
        if (replyText.equals("")){
            return;
        }
        Communication.replyChat(myChat , recentPost , me , replyText);
        onPage = OnPage.PRIVATE_CHAT;
        switchScenes("main_page.fxml");
    }

    private void like(){
        Communication.likeDm(myChat , recentPost , me);
        likeButton.setText("liked");
    }

    private void delete(){
        Communication.deleteDmChat(myChat , recentPost);
        onPage = OnPage.PRIVATE_CHAT;
        switchScenes("main_page.fxml");
    }

    private void editText(){
        String newText = editTextField.getText();
        if (newText.equals("")){
            return;
        }
        Communication.editDmInChat(myChat , recentPost , newText);
        onPage = OnPage.PRIVATE_CHAT;
        switchScenes("main_page.fxml");
    }



    private void forward(){
        String userId = forwardTextField.getText();
        if (userId.equals("")){
            return;
        }
        int ff = 0, j;
//        for (int i = 0; i < Input.myRegister.chatOnBord.allTexts.size(); i++) {
//            if (Input.myRegister.chatOnBord.allTexts.get(i).postID.equals(split[1])) {
                for (j = 0; j < Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.size(); j++) {
                    if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(j).person1.userID.equals(userId)) {
                        Communication.forwardDm(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), recentPost, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(j));
                        ff = 1;
                        break;
                    } else if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(j).person2.userID.equals(userId)) {
                        Communication.forwardDm(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), recentPost, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(j));
                        ff = 1;
                        break;
                    }
                }
//            }
//        }

//        if (ff == 0) {
//            System.out.println("you dont have the access");
//        }
    }
}
