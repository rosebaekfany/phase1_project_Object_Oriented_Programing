package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.media.Post;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrivateChat implements Initializable {
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox chatContent;
    @FXML
    ArrayList<Label> myTalks = new ArrayList<>();
    @FXML
    ArrayList<Label> yourTalks = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void fillInLabels(){


    }
}
