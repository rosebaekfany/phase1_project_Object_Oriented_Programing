package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyPageTop extends SwitchScenes implements Initializable {
    @FXML
    Label userIdd;
    @FXML
    Label userNamee;
    @FXML
    Label bioo;
    @FXML
    Label userAccount;
    @FXML
    Label postNum;
    @FXML
    Label followerNum;
    @FXML
    Label followingNum;
    @FXML
    Label userType;
    @FXML
    ImageView ImBur;
    @FXML
    Button Sbut;

    public void show_suggestedPerson (ActionEvent event) throws IOException {
        switchScenes("suggestedPersonBase.fxml");
    }

    public void show_follower (ActionEvent event) throws IOException {
        switchScenes("followerList.fxml");
    }

    public void show_following (ActionEvent event) throws IOException {
        switchScenes("followingList.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userIdd.setText(SearchIdSingle.myPersonPage.userID);
        userNamee.setText(SearchIdSingle.myPersonPage.name);
        bioo.setText(SearchIdSingle.myPersonPage.bio);
        userAccount.setText(SearchIdSingle.myPersonPage.userAccountType);
        followerNum.setText(String.valueOf(SearchIdSingle.myPersonPage.folowers.size()));
        followingNum.setText(String.valueOf(SearchIdSingle.myPersonPage.folowings.size()));
        postNum.setText(String.valueOf(SearchIdSingle.myPersonPage.posts.size()));
        userType.setText(SearchIdSingle.myPersonPage.userType);
        if(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID.equals(SearchIdSingle.myPersonPage.userID)){
        }
        else {
            Sbut.setVisible(false);
            ImBur.setVisible(false);
        }
    }
}
