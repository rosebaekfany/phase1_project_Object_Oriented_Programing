package com.yrtwitter.project_phase2.gui.pages;

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
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EachComment extends SwitchScenes implements Initializable {
    @FXML
    VBox messagePane;
    @FXML
    Label nameLabel , textLabel , dateLabel;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(PostComment.recentComment.usersPostId);
        textLabel.setText(PostComment.recentComment.script);
        dateLabel.setText(PostComment.recentComment.postDate.toString());
    }



}
