package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupUsers extends SwitchScenes implements Initializable {
    @FXML
    Button backButton , addMemberButton , addBannedButton;
    @FXML
    VBox memberBox , bannedBox;
    @FXML
    TextField addTextField , bannTextField;

    public static Person addedMember , bannedMember;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Person groupUser : Input.myRegister.grouponBord.groupUsers) {
            Label user = new Label(groupUser.name , memberBox);
            user.setTextFill(Color.WHITE);
        }
        for (Person bannedUser : Input.myRegister.grouponBord.bannedUsers) {
            Label banned = new Label(bannedUser.name , bannedBox);
            banned.setTextFill(Color.WHITE);
        }

        addMemberButton.setOnAction(event -> addMember());
        addBannedButton.setOnAction(event -> addBanned());
        backButton.setOnAction(event -> back());
    }

    private void addMember(){

    }

    private void addBanned(){

    }

    private void back(){
        onPage = OnPage.GROUP_CHAT;
        switchScenes("main_page.fxml");
    }
}
