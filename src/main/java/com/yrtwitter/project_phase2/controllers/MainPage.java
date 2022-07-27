package com.yrtwitter.project_phase2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainPage extends SwitchScenes {
    @FXML
    SplitPane splitPane;
    @FXML
    GridPane menuPane;
    @FXML
    ScrollPane startPageScrollPane;
    @FXML
    Button homeButton , searchButton , myChatsButton , myPageButton , settingButton;
    @FXML
    ImageView home_icon , search_icon , chat_icon , profile_icon , setting_icon;
    @FXML
    Label startPageLabel;
}