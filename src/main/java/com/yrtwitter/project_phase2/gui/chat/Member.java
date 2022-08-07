package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.media.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Member implements Initializable {
    @FXML
    Label memberLabel;
    @FXML
    AnchorPane memberPane;

    public static Person person;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        memberLabel.setText(person.name);
    }
}
