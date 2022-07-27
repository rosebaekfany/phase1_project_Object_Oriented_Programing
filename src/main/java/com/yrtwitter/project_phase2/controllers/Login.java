package com.yrtwitter.project_phase2.controllers;

import eu.hansolo.tilesfx.addons.Switch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Login extends SwitchScenes {
    @FXML
    GridPane loginPane;
    @FXML
    Label welcomeLabel;
    @FXML
    ImageView logoImage;
    @FXML
    Button loginButton , forgotPasswordButton , signUpButton;
    @FXML
    TextField usernameTextField , passwordTextField;

}
