package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.view.Input.myRegister;

public class CreatPost extends SwitchScenes implements Initializable {
    @FXML
    TextField text;
    @FXML
    TextField imageName;

    public void creatPost (ActionEvent event) throws IOException {
        Post.writePost(Input.myRegister, text.getText(),imageName.getText());
        Post.post(Input.myRegister);
        onPage = OnPage.MY_PAGE;
        switchScenes("main_page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
