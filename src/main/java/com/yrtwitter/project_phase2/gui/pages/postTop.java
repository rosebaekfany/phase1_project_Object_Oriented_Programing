package com.yrtwitter.project_phase2.gui.pages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.pages.BasePost.myShowPost;

public class postTop implements Initializable {

    @FXML
    Label userid ;
    @FXML
    Label postid ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userid.setText(BasePost.myShowPost.usersPostId);
        postid.setText(BasePost.myShowPost.postID);
    }
}
