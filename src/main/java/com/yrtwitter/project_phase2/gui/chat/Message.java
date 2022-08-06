package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Chat;
import com.yrtwitter.project_phase2.media.Comment;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Message extends SwitchScenes implements Initializable {
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
        if(recentPost.forwarded.equals("forwarded")){
            forwardLabel.setText("forwarded");
        }
        nameLabel.setText(recentPost.usersPostId);
        textLabel.setText(recentPost.script);
        dateLabel.setText(recentPost.postDate.toString());

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
        textLabel.setText(newText);
        Communication.editDmInChat(myChat , recentPost , newText);
    }



    private void forward(){
       // ToDo Communication.forwardDm(me , com.yrtwitter.project_phase2.gui.chat.Chat.recentPost ,);
    }
}
