package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.gui.menu.MainPage;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.temporary.*;
import com.yrtwitter.project_phase2.view.*;
import com.yrtwitter.project_phase2.controller.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @FXML
    ImageView profileImageView;
    @FXML
    Label profileLabel;
    @FXML
    TextField profileTextField;

    @FXML
            Label accountTypeLabel;
    @FXML
            RadioButton publicRadioButton , privateRadioButton;
    @FXML
            CheckBox businessAccountCheckBox;
    @FXML
            TextField phoneNumTextField;
    @FXML
            Label phoneNumLabel;
    @FXML
            Label businessGenreLabel;
    @FXML
            ChoiceBox<String> businessGenreChoiceBox;

    String[] theme = {"Dark" , "Light"};

    double profileW = 130.0 ,
            buttonW ,
            buttonH = 60.0 ,
            textFontsize ,
            textFieldW ,
            textFieldH = 40.0,
            vSpacing = 10.0,
            x0 = 20.0,
            x1 = 230.0,
            x2 = 380.0,
            y0 = 20.0,
            spx0  = 80.0,
            doneX ,
            doneY,
            doneW;

    ToggleGroup toggleGroup;

    String[] genres = {"SCIENCE_AND_TECHNOLOGY" , "HEALTH_AND_CARE" , "STOCK_MARKET" , "FASHION" , "GAMING" ,  "ARTS"};

    private void setSize(double c){

        // set y

        //profile
        profileImageView.setLayoutY(y0);
        profileImageView.setFitWidth(profileW*c);
        double profileImgY = y0 + profileW*c;
        profileLabel.setLayoutY(profileImgY + vSpacing);
        profileTextField.setLayoutY(profileImgY + vSpacing);
        double profileY = profileImgY + 2*vSpacing + textFieldH;

        //id
        userIdTextField.setLayoutY(profileY);
        userIdLabel.setLayoutY(profileY);

        //bio
        double bioY = profileY + textFieldH + vSpacing;
        bioTextField.setLayoutY(bioY);
        bioLabel.setLayoutY(bioY);

        // theme
        double themeY = bioY + textFieldH + vSpacing;
        themeChoiceBox.setLayoutY(themeY);
        themeLabel.setLayoutY(themeY);

        // account type
        double typeY = themeY + textFieldH + vSpacing;
        accountTypeLabel.setLayoutY(typeY);
        privateRadioButton.setLayoutY(typeY);
        publicRadioButton.setLayoutY(typeY);
        businessAccountCheckBox.setLayoutY(typeY + textFieldH + vSpacing);
        double phoneY = typeY + 2*textFieldH + 2*vSpacing;
        phoneNumLabel.setLayoutY(phoneY);
        phoneNumTextField.setLayoutY(phoneY);
        businessGenreLabel.setLayoutY(phoneY + textFieldH + vSpacing);
        businessGenreChoiceBox.setLayoutY(phoneY + textFieldH + vSpacing);

        //logout
        double logoutY = phoneY + 2*textFieldH + 2*vSpacing;
        logoutButton.setLayoutY(logoutY);

        //change pass
        double passY = logoutY + buttonH + vSpacing;
        changePassword.setLayoutY(passY);

        //fav genre
        favGenre.setLayoutY(passY + buttonH + vSpacing);
        double firstY = passY + buttonH + vSpacing + textFieldH + vSpacing;
        techSp.setLayoutY(firstY);
        techLabel.setLayoutY(firstY);
        healthSp.setLayoutY(firstY + (textFieldH + vSpacing));
        healthLabel.setLayoutY(firstY + (textFieldH + vSpacing));
        marketSp.setLayoutY(firstY + 2*(textFieldH + vSpacing));
        marketLabel.setLayoutY(firstY + 2*(textFieldH + vSpacing));
        fashionSp.setLayoutY(firstY + 3*(textFieldH + vSpacing));
        fashionLabel.setLayoutY(firstY + 3*(textFieldH + vSpacing));
        gamingLabel.setLayoutY(firstY + 4*(textFieldH + vSpacing));
        gamingSp.setLayoutY(firstY + 4*(textFieldH + vSpacing));
        artsLabel.setLayoutY(firstY + 5*(textFieldH + vSpacing));
        artsSp.setLayoutY(firstY + 5*(textFieldH + vSpacing));

        //done
        double doneY = firstY + 6*(textFieldH + vSpacing);
        doneButton.setLayoutY(doneY);
        guide.setLayoutY(doneY);

        backPane.setMinHeight(doneY + buttonH + vSpacing);



        //set x

        //profile
        profileImageView.setLayoutX(x0);
        profileLabel.setLayoutX(x0);
        profileTextField.setLayoutX(x1);

        //userid
        userIdLabel.setLayoutX(x0);
        userIdTextField.setLayoutX(x1);

        //bio
        bioTextField.setLayoutX(x1);
        bioLabel.setLayoutX(x0);

        //theme
        themeLabel.setLayoutX(x0);
        themeChoiceBox.setLayoutX(x1);

        // type
        accountTypeLabel.setLayoutX(x0);
        privateRadioButton.setLayoutX(x1);
        publicRadioButton.setLayoutX(x2);
        businessAccountCheckBox.setLayoutX(x0);
        phoneNumLabel.setLayoutX(x0);
        phoneNumTextField.setLayoutX(x1);
        businessGenreChoiceBox.setLayoutX(x1);
        businessGenreLabel.setLayoutX(x0);

        //button
        logoutButton.setLayoutX(x0);
        changePassword.setLayoutX(x0);
        doneButton.setLayoutX(x0);
        guide.setLayoutX(x1);
        
        // fav genre
        favGenre.setLayoutX(x0);
        artsSp.setLayoutX(x0);
        gamingSp.setLayoutX(x0);
        fashionSp.setLayoutX(x0);
        techSp.setLayoutX(x0);
        marketSp.setLayoutX(x0);
        healthSp.setLayoutX(x0);
        artsLabel.setLayoutX(spx0);
        fashionLabel.setLayoutX(spx0);
        techLabel.setLayoutX(spx0);
        gamingLabel.setLayoutX(spx0);
        marketLabel.setLayoutX(spx0);
        healthLabel.setLayoutX(spx0);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setSize(1.0);

        toggleGroup = new ToggleGroup();
        publicRadioButton.setToggleGroup(toggleGroup);
        privateRadioButton.setToggleGroup(toggleGroup);
        if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userAccountType.equals("public")){
            publicRadioButton.selectedProperty().set(true);
        }else{
            privateRadioButton.selectedProperty().set(true);
        }

        phoneNumLabel.setVisible(false);
        phoneNumTextField.setVisible(false);
        businessGenreChoiceBox.setVisible(false);
        businessGenreLabel.setVisible(false);

        businessAccountCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (businessAccountCheckBox.isSelected()){
                    phoneNumLabel.setVisible(true);
                    phoneNumTextField.setVisible(true);
                    businessGenreLabel.setVisible(true);
                    businessGenreChoiceBox.setVisible(true);
                } else {
                    phoneNumLabel.setVisible(false);
                    phoneNumTextField.setVisible(false);
                    phoneNumTextField.setText("");
                    businessGenreLabel.setVisible(false);
                    businessGenreChoiceBox.setVisible(false);
                    businessGenreChoiceBox.setValue(null);
                }
            }
        });

        //theme
        themeChoiceBox.getItems().addAll(theme);
        if (darkTheme){
            themeChoiceBox.setValue("Dark");
        } else {
            themeChoiceBox.setValue("Light");
        }

        businessGenreChoiceBox.getItems().addAll(genres);

        //userid
        userIdTextField.setText(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID);

        //bio
        bioTextField.setText(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).bio);


        //profile
        try {
            Image image = new Image(new FileInputStream(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).profilePath));
            profileImageView.setImage(image);
        } catch (Exception e) {
            e.fillInStackTrace();
        }


        logoutButton.setOnAction(event -> logout());

        changePassword.setOnAction(event -> changePass());

        doneButton.setOnAction(event -> done());
        //guide
        guide.setVisible(false);

    }

    private void changePass(){
        switchScenes("forgetPassword.fxml");
    }

    private void logout(){
        Input.myRegister.logedInAccount = -1;
        switchScenes("login.fxml");
    }

    private void setProfile(){
        String url = profileTextField.getText();
        if (url.equals("")){
            return;
        }
        try {
            Image image = new Image(new FileInputStream(url));
            profileImageView.setImage(image);
            Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).profilePath = url;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private void setType(){
        RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
        String type = rb.getText();
        Edit.changeUserType(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), type);
    }

    private void setBusiness(){
        String phoneNumber = phoneNumTextField.getText();
        if (phoneNumber.equals("")){
            return;
        }
        String genre = businessGenreChoiceBox.getValue();
        if (genre.equals("")){
            return;
        }
        if (businessAccountCheckBox.isSelected()){
            BusinessUser businessUser = new BusinessUser(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount),phoneNumber , genre);
            businessUser.userAccountType = "Business_Account";
            Input.myRegister.businessUsers.add(businessUser);
            Input.myRegister.allRegisters.add(businessUser);
            Input.myRegister.allRegisters.remove(Input.myRegister.logedInAccount);
            Input.myRegister.logedInAccount = Input.myRegister.allRegisters.size() - 1;
        }
    }

//    private void setFav(){
//        if
//    }


    private void done(){
        setType();
        setBusiness();
        ArrayList<String> successful = new ArrayList<>();
        setProfile();
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
        onPage = OnPage.SETTING;
        switchScenes("main_page.fxml");
    }

    private void setTheme(){
        String theme = themeChoiceBox.getValue();
        switch (theme){
            case "Dark" -> SwitchScenes.darkTheme = true;
            case "Light" -> SwitchScenes.darkTheme = false;
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
        for (i = 0; i < Input.myRegister.allRegisters.size(); i++) {
            if (Input.myRegister.allRegisters.get(i).userID.equals(newString)) {
                if (flag == 0) {
                    successful = "a user exists with this Id";
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID = newString;
            for (i = 0; i < Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).posts.size(); i++) {
                Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).posts.get(i).usersPostId = newString;
            }
        }
        return successful;
    }

    private void setBio(String newString){
        Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).bio = newString;
    }



    private String chooseFavGenre(){
        int healthNum=0 , techNum=0 , fashionNum=0 , marketNum=0 , artsNum=0 , gamingNum=0;
        String successful = "successful";
        CommercialGenres[] faveGenre = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).favoriteGenres;
        for (int i = 0; i < 6; i++) {

        }
        return successful;
    }
}
