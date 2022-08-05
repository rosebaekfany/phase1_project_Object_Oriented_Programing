package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.BusinessPost;
import com.yrtwitter.project_phase2.media.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.pages.BasePost.myShowPost;
import static com.yrtwitter.project_phase2.media.RegisterMenu.* ;
import static com.yrtwitter.project_phase2.view.Input.myRegister;

public class PostUnder extends SwitchScenes implements Initializable {

    @FXML
    Label text;
    @FXML
    Label likeNum;
    @FXML
    Label commentNum;

    public void likePost(ActionEvent event) throws IOException {
        BusinessPost.fillLike(myShowPost.postID , myRegister , allRegisters.get(logedInAccount), LocalDate.now());
        Post.likePost(allRegisters.get(logedInAccount), myShowPost);
    }

    public void show_likes(ActionEvent event) throws IOException {
        switchScenes("showPostLikes.fxml");
    }

    public void commenting(ActionEvent event) throws IOException {
        switchScenes("postComment.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(myShowPost.script);
        likeNum.setText(String.valueOf(myShowPost.likedUsers.size()));
        commentNum.setText(String.valueOf(myShowPost.postComments.size()));

    }
}
