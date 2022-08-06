package com.yrtwitter.project_phase2.gui.menu;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ForgetPassword extends SwitchScenes implements Initializable {
    @FXML
    Button changePasswordButton , backButton , cancelButton;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Pane backPane;
    @FXML
    TextField usernameTextField , favoriteFlowerTextField;
    @FXML
    PasswordField passwordField , repeatPasswordField;
    @FXML
    Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //backButton
        backButton.setVisible(false);
        backButton.setOnAction(event -> cancel());

        //cancelButton
        cancelButton.setOnAction(event -> cancel());

        //signUpButton
        changePasswordButton.setOnAction(event -> changePassword());

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
        changePasswordButton.setLayoutX(218.0 * coef);
        changePasswordButton.setFont(Font.font("System" , FontWeight.BOLD ,  fontsize));
        changePasswordButton.setPrefWidth(coef * 350.0);

        //welcomeLabel
        label.setFont(Font.font("System" , FontWeight.BOLD , fontsize));
        label.setLayoutX(218.0 * coef);
        label.setPrefWidth(coef * 350.0);

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



    private void changePassword(){
        String username = usernameTextField.getText();
        String newPassword = passwordField.getText();
        String newPassword2 = repeatPasswordField.getText();
        String favoriteFlower = favoriteFlowerTextField.getText();
        if (username.equals("") ||
                newPassword.equals("") ||
                newPassword2.equals("") ||
                favoriteFlower.equals("")){
            warning("enter data" , label);
            return;
        }
        if (Pattern.compile("[^A-z0-9_ ]").matcher(username).find()) {
            texting("invalid usernameFormat" , label);
            return;
        }
        if (Pattern.compile("[^A-z0-9_ ]").matcher(newPassword).find()){
            texting("invalid passwordFormat" , label);
            return;
        }        if (!newPassword.equals(newPassword2)) {
            warning("match passwords" , label);
            return;
        }
        for (Person registered : Input.myRegister.allRegisters) {
            if (registered.name.equals(username)){
                if (registered.securityQuestion.equals(favoriteFlower)){
                    registered.userPasswords = newPassword;
                    successfulPage();
                    return;
                }
            }
        }
        warning("no such user" , label);
    }

    private void successfulPage(){
        texting("password changed" , label);
        usernameTextField.setVisible(false);
        passwordField.setVisible(false);
        repeatPasswordField.setVisible(false);
        favoriteFlowerTextField.setVisible(false);
        changePasswordButton.setVisible(false);
        cancelButton.setVisible(false);
        backButton.setVisible(true);
    }

    private void cancel() {
        //passwordField
        passwordField.setText("");

        //usernameTextField
        usernameTextField.setText("");

        //repeatPasswordField
        repeatPasswordField.setText("");

        //favoriteFlowerTextField
        favoriteFlowerTextField.setText("");
        if (Input.myRegister.logedInAccount == -1){
            switchScenes("login.fxml");
        } else {
            switchScenes("main_page.fxml");
        }
    }
}
