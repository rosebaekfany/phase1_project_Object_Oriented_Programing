package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatepostIcon extends SwitchScenes implements Initializable {

    public void massage(ActionEvent event) throws IOException{
        switchScenes("massageRequestBase.fxml");
    }
    public void creatPost(ActionEvent event) throws IOException{
        switchScenes("creatPost.fxml");
    }
    public void con(ActionEvent event) throws IOException{
        switchScenes("removeFollow.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
