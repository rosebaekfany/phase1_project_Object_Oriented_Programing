package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupTop extends SwitchScenes implements Initializable {

    @FXML
    Label groupId , memberNumLabel;
    @FXML
    Button usersButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupId.setText(Input.myRegister.grouponBord.groupName);
        memberNumLabel.setText(String.valueOf(Input.myRegister.grouponBord.groupUsers.size()));
        usersButton.setOnAction(event -> showUsers());
    }

    private void showUsers(){
        onPage = OnPage.GROUP_INFO;
        switchScenes("main_page.fxml");
    }
}
