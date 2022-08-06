package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.BusinessPost;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
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
    @FXML
    Label edited;

    public void likePost(ActionEvent event) throws IOException {
        BusinessPost.fillLike(BasePost.myShowPost.postID , Input.myRegister ,Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), LocalDate.now());
        Post.likePost(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), BasePost.myShowPost);
        if(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID.equals(BasePost.myShowPost.usersPostId)){
            onPage = OnPage.MY_PAGE;
        }else {
            onPage = OnPage.SBS_PAGE;
        }
        switchScenes("main_page.fxml");
    }

    public void show_likes(ActionEvent event) throws IOException {
        onPage = OnPage.LIKE_POST;
        switchScenes("main_page.fxml");
    }

    public void commenting(ActionEvent event) throws IOException {
        onPage = OnPage.COMMENT_POST;
        switchScenes("main_page.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(BasePost.myShowPost.script);
        likeNum.setText(String.valueOf(BasePost.myShowPost.likedUsers.size()));
        commentNum.setText(String.valueOf(BasePost.myShowPost.postComments.size()));
        edited.setText(BasePost.myShowPost.edited);
    }
}
