package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PostComment extends SwitchScenes implements Initializable {

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

    }
}
