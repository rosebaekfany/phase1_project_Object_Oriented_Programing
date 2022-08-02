package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SignUp extends SwitchScenes implements Initializable {
    @FXML
    Button signUpButton , backButton , cancelButton;
    @FXML
    Pane backPane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    TextField usernameTextField , favoriteFlowerTextField;
    @FXML
    Label signUpLabel;
    @FXML
    PasswordField passwordField , repeatPasswordField;



    //My sign up
    public void signUp(){
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String password2 = repeatPasswordField.getText();
        String favoriteFlower = favoriteFlowerTextField.getText();
        if (username.equals("") ||
            password.equals("") ||
            password2.equals("") ||
            favoriteFlower.equals("")){
            warning("enter data" , signUpLabel);
            return;
        }
        if (Pattern.compile("[^A-z0-9_ ]").matcher(username).find()) {
            warning("username format is invalid" , signUpLabel);
            return;
        }
        if (Pattern.compile("[^A-z0-9_ ]").matcher(password).find()) {
            warning("password format is invalid" , signUpLabel);
            return;
        }
        if (!password.equals(password2)) {
            warning("passwords do not match" , signUpLabel);
            return;
        }
        for (int i = 0; i < RegisterMenu.allRegisters.size(); i++) {
            if (RegisterMenu.allRegisters.get(i).name.equals(username)) {
                warning("a user exists with this username" , signUpLabel);
                return;
            }
        }
        Person newPerson = new Person();
        newPerson.name = username;
        newPerson.userPasswords = password;
        newPerson.securityQuestion = favoriteFlower;
        newPerson.userID = "@" + String.valueOf(RegisterMenu.allRegisters.size()) + "***";
        RegisterMenu.allRegisters.add(newPerson);
        successfulPage();
    }

    private void successfulPage(){
        texting("signUp successful" , signUpLabel);
        usernameTextField.setVisible(false);
        passwordField.setVisible(false);
        repeatPasswordField.setVisible(false);
        favoriteFlowerTextField.setVisible(false);
        signUpButton.setVisible(false);
        cancelButton.setVisible(false);
        backButton.setVisible(true);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //backButton
        backButton.setVisible(false);
        backButton.setOnAction(event -> cancel());

        //cancelButton
        cancelButton.setOnAction(event -> cancel());

        //signUpButton
        signUpButton.setOnAction(event -> signUp());

        //passwordField
        passwordField.setText("");

        //usernameTextField
        usernameTextField.setText("");

        //repeatPasswordField
        repeatPasswordField.setText("");

        //favoriteFlowerTextField
        favoriteFlowerTextField.setText("");

        //scrollPane
        scrollPane.widthProperty().addListener((observableValue, number, t1) -> wScaling());
        scrollPane.heightProperty().addListener((observableValue, number, t1) -> hScaling());

    }

    private void hScaling(){
        double coef = window.getHeight() / 600.0;
        if(coef>1)
            backPane.setPrefHeight(coef * 600.0-40);

        scrollPane.setPrefHeight(coef * 600.0);
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
        signUpButton.setLayoutX(218.0 * coef);
        signUpButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        signUpButton.setPrefWidth(coef * 350.0);

        //welcomeLabel
        signUpLabel.setFont(Font.font("System" , FontWeight.BOLD , fontsize));
        signUpLabel.setLayoutX(218.0 * coef);
        signUpLabel.setPrefWidth(coef * 350.0);

        //signUpButton
        backButton.setLayoutX(218.0 * coef);
        backButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        backButton.setPrefWidth(coef * 350.0);

        //cancelButton
        cancelButton.setLayoutX(218.0 * coef);
        cancelButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        cancelButton.setPrefWidth(coef * 350.0);

        //usernameTextField
        usernameTextField.setLayoutX(218.0 * coef);
        usernameTextField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        usernameTextField.setPrefWidth(350.0 * coef);

        //passwordField
        passwordField.setLayoutX(218.0 * coef);
        passwordField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        passwordField.setPrefWidth(350.0 * coef);

        //repeatPasswordField
        repeatPasswordField.setLayoutX(218.0 * coef);
        repeatPasswordField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        repeatPasswordField.setPrefWidth(350.0 * coef);

        //favoriteFlowerTextField
        favoriteFlowerTextField.setLayoutX(218.0 * coef);
        favoriteFlowerTextField.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        favoriteFlowerTextField.setPrefWidth(350.0 * coef);
    }






    private void cancel(){
        //passwordField
        passwordField.setText("");

        //usernameTextField
        usernameTextField.setText("");

        //repeatPasswordField
        repeatPasswordField.setText("");

        //favoriteFlowerTextField
        favoriteFlowerTextField.setText("");

        switchScenes("login.fxml");
    }


}
