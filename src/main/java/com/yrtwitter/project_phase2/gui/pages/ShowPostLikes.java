package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.pages.BasePost.myShowPost;

public class ShowPostLikes extends SwitchScenes implements Initializable {
    @FXML
    VBox likedUser;

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
        int i ;
        for (i = 0; i <BasePost.myShowPost.likedUsers.size(); i++) {
            Label myUser = new Label();
            myUser.setText("  "+BasePost.myShowPost.likedUsers.get(i).userID);
            myUser.setFont(Font.font(18));
            myUser.setTextAlignment(TextAlignment.CENTER);
            myUser.setTextFill(Color.WHITE);
            likedUser.getChildren().add(myUser);

        }
    }
}
