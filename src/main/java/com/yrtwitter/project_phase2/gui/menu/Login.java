package com.yrtwitter.project_phase2.gui.menu;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Login extends SwitchScenes implements Initializable {
    @FXML
    Pane backPane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Label welcomeLabel;
    @FXML
    Button loginButton, forgotPasswordButton, signUpButton;
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backPane.setStyle("-fx-background-color: #535353");
        scrollPane.setStyle("-fx-background-color: #535353");

        loginButton.setOnAction(event -> login());
        loginButton.setMinWidth(0.0);
        loginButton.setText("login");
        loginButton.setFont(Font.font("System" , FontWeight.BOLD , 25.0));

        signUpButton.setOnAction(event -> signUp());
        signUpButton.setMinWidth(0.0);

        forgotPasswordButton.setOnAction(event -> forgotPassword());
        forgotPasswordButton.setMinWidth(0.0);

        scrollPane.widthProperty().addListener((observableValue, number, t1) -> wScaling());
        scrollPane.heightProperty().addListener((observableValue, number, t1) -> hScaling());
    }

    private void wScaling(){
        double coef = window.getWidth() / 800.0;

        double fontsize = 25.0;
        if (coef < 1){
            fontsize = Math.sqrt(coef) * 25.0;
        }

        //backPane
        backPane.setPrefWidth(coef * 800.0);
        backPane.setMinWidth(coef * 800.0);
        backPane.setMaxWidth(coef * 800.0);
        backPane.setStyle("-fx-background-color: #535353");

        //loginButton
        loginButton.setLayoutX(218.0 * coef);
        loginButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        loginButton.setText("Login");
        loginButton.setPrefWidth(coef * 350.0);
//        double loginButtonW = loginButton.getPrefWidth();
//        loginButton.setLayoutX((backPane.getPrefWidth() - loginButtonW) / 2);

        //welcomeLabel
        welcomeLabel.setFont(Font.font("System" , FontWeight.BOLD , fontsize));
        welcomeLabel.setLayoutX(218.0 * coef);
        welcomeLabel.setPrefWidth(coef * 350.0);

        //signUpButton
        signUpButton.setLayoutX(218.0 * coef);
        signUpButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        signUpButton.setText("Sign up");
        signUpButton.setPrefWidth(coef * 350.0);

        //forgetPasswordButton
        forgotPasswordButton.setLayoutX(218.0 * coef);
        forgotPasswordButton.setFont(Font.font(fontsize * 18.0 / 25.0));
        forgotPasswordButton.setUnderline(true);
        forgotPasswordButton.setPrefWidth(coef * 350.0);

        //usernameTextField
        usernameTextField.setLayoutX(218.0 * coef);
        usernameTextField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        usernameTextField.setPrefWidth(350.0 * coef);

        //passwordField
        passwordField.setLayoutX(218.0 * coef);
        passwordField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        passwordField.setPrefWidth(350.0 * coef);

    }

    private void hScaling(){
        double coef = window.getHeight() / 600.0;
        if(coef>1)
        backPane.setPrefHeight(coef * 600.0 -40.0);

        scrollPane.setPrefHeight(coef * 600.0);

    }

    private void login(){
        String username = usernameTextField.getText();
        String password  = passwordField.getText();

        if (Pattern.compile("[^A-z0-9_ ]").matcher(username).find()) {
            texting("username format is invalid" , welcomeLabel);
            return;
        }
        if (Pattern.compile("[^A-z0-9_ ]").matcher(password).find()){
            texting("password format is invalid" , welcomeLabel);
            return;
        }
        for (int i = 0; i < RegisterMenu.allRegisters.size(); i++) {
            if (RegisterMenu.allRegisters.get(i).name.equals(username)) {
                if (RegisterMenu.allRegisters.get(i).userPasswords.equals(password)) {
                    RegisterMenu.logedInAccount = i;
                    onPage = OnPage.START;
                    switchScenes("main_page.fxml");
                    return;
                } else {
                    warning("invalid password", welcomeLabel);
                    usernameTextField.setText("");
                    passwordField.setText("");
                    return;
                }
            }
        }
        warning("invalid username" , welcomeLabel);
        passwordField.setText("");
        usernameTextField.setText("");
    }

    private void signUp(){
        switchScenes("signUp.fxml");
    }

    private void forgotPassword(){
        switchScenes("forgetPassword.fxml");
    }
}
