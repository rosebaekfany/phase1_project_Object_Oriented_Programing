package com.yrtwitter.project_phase2.gui.pages;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Home extends SwitchScenes implements Initializable {

    @FXML
    VBox mainPageContent;
    @FXML
    Button addGroupButton , startChatButton;
    @FXML
    TextField groupNameTextField , startChatTextField;
    @FXML
    Label label;

    private Person me = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setVisible(false);
        addGroupButton.setOnAction(event -> addGroup());
        startChatButton.setOnAction(event -> startChat());

        me.mainPagePostFinal.clear();
        Person.makeMainPage(me,Input.myRegister);
        FXMLLoader postLoader;
        try {
            for (Post post : me.mainPagePostFinal) {
                BasePost.myShowPost = post;
                postLoader = new FXMLLoader(Main.class.getResource("postBase.fxml"));
                mainPageContent.getChildren().add(postLoader.load());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void addGroup(){
        String groupName = groupNameTextField.getText();
        if (groupName.equals("")){
            return;
        }
        Group.creatGroup(Input.myRegister ,me , groupName);
        label.setVisible(true);
    }

    private void startChat(){
        String userId = startChatTextField.getText();
        if (userId.equals("")){
            return;
        }
        int ff = 0, fg = 0;
        for (int i = 0; i < Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.size(); i++) {
            if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(userId)) {
                if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i).blockState.equals("blocked")) {
                    label.setText("the chat is blocked");
                } else {
                    Communication.countinueChatting(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i));
                    //startChat = 1;
                    onPage = OnPage.PRIVATE_CHAT;
                    switchScenes("main_page.fxml");
                    label.setText("you have entered the chat");
                }
                ff = 1;
                break;
            } else if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(userId)) {
                if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i).blockState.equals("blocked")) {
                    label.setText("the chat is blocked");
                } else {
                    Communication.countinueChatting(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.get(i));
                    //startChat = 1;
                    onPage = OnPage.PRIVATE_CHAT;
                    switchScenes("main_page.fxml");

                    label.setText("you have entered the chat");
                }
                ff = 1;
                break;
            }
        }
        if (ff == 0) {
            for (int i = 0; i < Input.myRegister.allRegisters.size(); i++) {
                if (Input.myRegister.allRegisters.get(i).userID.equals(userId) && i != Input.myRegister.logedInAccount) {
                    Communication.StartNewChat(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), Input.myRegister.allRegisters.get(i));
                    //startChat = 1;
                    onPage = OnPage.PRIVATE_CHAT;
                    switchScenes("main_page.fxml");
                    label.setText("you have started a new chat");
                    fg = 1;
                    break;
                }
            }
            if (fg == 0) {
                label.setText("userId is incorrect");
            }
        }
    }
}
