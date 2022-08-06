package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveFollow extends SwitchScenes implements Initializable {

    @FXML
    TextField followerRemoveId;

    public void removeFollower(ActionEvent event) throws IOException {
        Communication.removeFollower(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount),followerRemoveId.getText());
        switchScenes("myPage.fxml");
    }
    public void backToPage(ActionEvent event) throws IOException {
        switchScenes("myPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
