package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.controller.DatabaseUpdate;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatepostIcon extends SwitchScenes implements Initializable {

    public void massage(ActionEvent event) throws IOException {
        onPage = OnPage.massageRequestBase;
        switchScenes("main_page.fxml");
    }
    public void creatPost(ActionEvent event) throws IOException {
        onPage = OnPage.creatPost;
        switchScenes("main_page.fxml");
    }
    public void con(ActionEvent event) throws IOException {
        onPage = OnPage.removeFollow;
        switchScenes("main_page.fxml");
    }
    public void exit(ActionEvent event) throws IOException {
        Input.registerMenu=0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
