package com.yrtwitter.project_phase2.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Chat implements Initializable {
    @FXML
    ArrayList<Label> myTalks = new ArrayList<>();
    @FXML
    ArrayList<Label> yourTalks = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
