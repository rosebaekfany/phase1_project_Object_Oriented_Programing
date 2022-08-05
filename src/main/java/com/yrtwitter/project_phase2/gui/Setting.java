package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.gui.menu.MainPage;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.temporary.CommercialGenres;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Setting extends MainPage implements Initializable {
    @FXML
    ScrollPane scrollPane;

    @FXML
    Pane backPane;

    @FXML
    Label userIdLabel;
    @FXML
    TextField userIdTextField;

    @FXML
    Label bioLabel;
    @FXML
    TextField bioTextField;

    @FXML
    Label birthDateLabel;
    @FXML
    DatePicker birthDatePicker;

    @FXML
    Label themeLabel;
    @FXML
    ChoiceBox<String> themeChoiceBox;

    @FXML
    Label favGenre;
    @FXML
    Label healthLabel , marketLabel , techLabel , fashionLabel , artsLabel , gamingLabel;
    @FXML
    Spinner<Integer> healthSp , marketSp , techSp , fashionSp , artsSp , gamingSp;
    Spinner<Integer>[] spinners = new Spinner[6];

    @FXML
    Button logoutButton;
    @FXML
    ImageView logout_icon;

    @FXML
    Button changePassword;
    @FXML
    ImageView changePass_icon;

    @FXML
    Button doneButton;

    @FXML
    Label guide;

    String[] theme = {"Dark" , "Light"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //theme
        themeChoiceBox.getItems().addAll(theme);
        if (darkTheme){
            themeChoiceBox.setValue("Dark");
        } else {
            themeChoiceBox.setValue("Light");
        }

        //userid
        userIdTextField.setText(RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).userID);

        //bio
        bioTextField.setText(RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).bio);

        //spinners
        spinners[0] = healthSp;
        spinners[1] = techSp;
        spinners[2] = fashionSp;
        spinners[3] = marketSp;

        //logoutButton
//        logoutButton = new Button("logout" , backPane);
//        logoutButton.setLayoutY(20.0);
//        logoutButton.setLayoutX(20.0);
//        logoutButton.setPrefWidth(50.0);
//        logoutButton.setPrefHeight(50.0);
//        logoutButton.setFont(Font.font("System" , FontWeight.BOLD , 20.0));
//        Image logoutImage = new Image(Main.class.getResource("images/logout_icon.png").toExternalForm());
//        logout_icon = new ImageView(logoutImage);
//        logoutButton.setGraphic(logout_icon);
        logoutButton.setOnAction(event -> logout());
//        logoutButton.setStyle("-fx-background-color: #535353FF");
//        logoutButton.setStyle("-fx-border-color: #2499F8FF");
//        logoutButton.setStyle("-fx-border-width: 6px");
//        logoutButton.setStyle("-fx-border-radius: 20px");
//        logoutButton.setTextFill(Color.rgb(36,153,248));

        //changePassword
//        changePassword = new Button("change password", backPane);
//        changePassword.setLayoutY(730.0);
//        changePassword.setLayoutX(20.0);
//        changePassword.setFont(Font.font("System" , FontWeight.BOLD , 20.0));
//        Image changePassImage = new Image(Main.class.getResource("images\\password_icon.png").toExternalForm());
//        changePass_icon = new ImageView(changePassImage);
//        logoutButton.setGraphic(changePass_icon);
        changePassword.setOnAction(event -> changePass());
//        changePassword.setStyle("-fx-background-color: #535353FF");
//        changePassword.setStyle("-fx-border-color: #2499F8FF");
//        changePassword.setStyle("-fx-border-width: 6px");
//        changePassword.setStyle("-fx-border-radius: 20px");
//        changePassword.setTextFill(Color.rgb(36,153,248));

        //done
//        doneButton = new Button("DONE" , backPane);
//        doneButton.setLayoutY(810.0);
//        doneButton.setLayoutX(20.0);
//        doneButton.setFont(Font.font("System" , FontWeight.BOLD , 20.0));
        doneButton.setOnAction(event -> done());
//        doneButton.setStyle("-fx-background-color: #535353FF");
//        doneButton.setStyle("-fx-border-color: #2499F8FF");
//        doneButton.setStyle("-fx-border-width: 6px");
//        doneButton.setStyle("-fx-border-radius: 20px");
//        doneButton.setTextFill(Color.rgb(36,153,248));

        //guide
        guide.setVisible(false);
//        guide = new Label();
//        backPane.getChildren().add(guide);
//        guide.setLayoutY(880.0);
//        guide.setLayoutX(20.0);
//        guide.setTextFill(Color.RED);
//        guide.setFont(Font.font("System" , FontWeight.BOLD , 20.0));

    }

    private void changePass(){
        switchScenes("forgetPassword.fxml");
    }

    private void logout(){
        RegisterMenu.logedInAccount = -1;
        switchScenes("login.fxml");
    }

    private void done(){
        ArrayList<String> successful = new ArrayList<>();
        setTheme();
        successful.add(setUserId(userIdTextField.getText()));
        setBio(bioTextField.getText());
        for (String s : successful) {
            if (!s.equals("successful")) {
                guide.setVisible(true);
                guide.setText(s);
                return;
            }
        }
        guide.setVisible(true);
        guide.setText("successful");
    }

    private void setTheme(){
        String theme = themeChoiceBox.getValue();
        switch (theme){
            case "Dark" -> darkTheme = true;
            case "Light" -> darkTheme = false;
        }
    }

    private String setUserId(String newString){
        int i, flag = 0;
        String successful = "successful";
        if (newString.equals("")){
            successful = "enter your id";
            return successful;
        }
        if (newString.charAt(0) != '@') {
            successful = "@ should be at first";
            flag = 1;
        }
        for (i = 0; i < RegisterMenu.allRegisters.size(); i++) {
            if (RegisterMenu.allRegisters.get(i).userID.equals(newString)) {
                if (flag == 0) {
                    successful = "a user exists with this Id";
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).userID = newString;
            for (i = 0; i < RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).posts.size(); i++) {
                RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).posts.get(i).usersPostId = newString;
            }
        }
        return successful;
    }

    private void setBio(String newString){
        RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).bio = newString;
    }

    private void setBirthDate(){
        LocalDate time = birthDatePicker.getValue();
        //RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).
    }

    private String chooseFavGenre(){
        int healthNum=0 , techNum=0 , fashionNum=0 , marketNum=0 , artsNum=0 , gamingNum=0;
        String successful = "successful";
        CommercialGenres[] faveGenre = RegisterMenu.allRegisters.get(RegisterMenu.logedInAccount).favoriteGenres;
        for (int i = 0; i < 6; i++) {

        }
        return successful;
    }
}
