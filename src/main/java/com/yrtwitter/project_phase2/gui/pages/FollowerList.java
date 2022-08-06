package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
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

public class FollowerList extends SwitchScenes implements Initializable {

    @FXML
    VBox followerList;

    public void backToPage(ActionEvent event) throws IOException {
        if(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID.equals(SearchIdSingle.myPersonPage.userID)){
            onPage = OnPage.MY_PAGE;
        }
        else {
            onPage = OnPage.SBS_PAGE;
        }
        switchScenes("main_page.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(followerList!=null){
            int i ;
            for(i=0 ; i<SearchIdSingle.myPersonPage.folowers.size() ; i++){
                Label userr = new Label() ;
                userr.setText("  "+SearchIdSingle.myPersonPage.folowers.get(i).userID);
                userr.setFont(new Font(18));
                userr.setTextAlignment(TextAlignment.CENTER);
                userr.setTextFill(Color.WHITE);
                followerList.getChildren().add(userr);
            }
        }
    }
}
