package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FollowingList  extends SwitchScenes implements Initializable {
    @FXML
    VBox followingList;

    public void backToPage(ActionEvent event) throws IOException {
        switchScenes("myPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(followingList!=null){
            int i ;
            for(i=0 ; i< SearchIdSingle.myPersonPage.folowings.size() ; i++){
                Label userr = new Label() ;
                userr.setText("  "+SearchIdSingle.myPersonPage.folowings.get(i).userID);
                userr.setFont(new Font(18));
                userr.setTextAlignment(TextAlignment.CENTER);
                userr.setTextFill(Color.WHITE);
                followingList.getChildren().add(userr);
            }
        }
    }
}
