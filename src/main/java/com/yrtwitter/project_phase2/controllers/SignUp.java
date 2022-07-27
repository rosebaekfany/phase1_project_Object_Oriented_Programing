package com.yrtwitter.project_phase2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SignUp extends SwitchScenes {
    @FXML
    Button signUpButton;
    @FXML
    GridPane signUpPane;
    @FXML
    TextField usernameTextField , passwordTextField , favoriteFlowerTextField;
    @FXML
    ImageView logoImage;
    @FXML
    Label signUpLabel;
}
