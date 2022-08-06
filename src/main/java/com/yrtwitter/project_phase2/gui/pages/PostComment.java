package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Comment;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PostComment extends SwitchScenes implements Initializable {

    @FXML
    TextField textField;
    @FXML
    Button addButton;
    @FXML
    VBox commentsBox;

    public static Comment recentComment;

    private Person me = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount);

    public void backToPost(ActionEvent event) throws IOException {
        if(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID.equals(BasePost.myShowPost.usersPostId)){
            onPage = OnPage.MY_PAGE;
        }else {
            onPage = OnPage.SBS_PAGE;
        }
        switchScenes("main_page.fxml");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(event -> add());
        FXMLLoader fxmlLoader;
        try {
            for (Comment postComment : BasePost.myShowPost.postComments) {
                recentComment = postComment;
                fxmlLoader = new FXMLLoader(Main.class.getResource("each_comment.fxml"));
                commentsBox.getChildren().add(fxmlLoader.load());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void add(){
        String commentText = textField.getText();
        Post.commentPost(me , BasePost.myShowPost , commentText);
        onPage = OnPage.COMMENT_POST;
        switchScenes("main_page.fxml");
    }
}
