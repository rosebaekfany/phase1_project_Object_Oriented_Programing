package com.yrtwitter.project_phase2.gui.menu;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu extends SwitchScenes implements Initializable {

    @FXML
    Button homeButton , searchButton , myChatsButton , myPageButton , settingButton;
    @FXML
    ImageView home_icon , search_icon , chat_icon , profile_icon , setting_icon;
    @FXML
    Pane backPane;
    @FXML
    ScrollPane scrollPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //homeButton
        homeButton.setOnAction(event -> openHome());

        //myPageButton
        myPageButton.setOnAction(event -> openMyPage());

        //myChatButton
        myChatsButton.setOnAction(event -> openMyChats());

        //searchButton
        searchButton.setOnAction(event -> openSearch());

        //settingButton
        settingButton.setOnAction(event -> openSetting());

    }

    public void openHome(){
        onPage = OnPage.HOME;
        switchScenes("main_page.fxml");
    }

    public void openMyPage(){
        onPage = OnPage.MY_PAGE;
        switchScenes("main_page.fxml");
    }

    public void openMyChats(){
        onPage = OnPage.CONTACTS;
        switchScenes("main_page.fxml");
    }

    public void openSearch(){
        onPage = OnPage.SEARCH;
        switchScenes("main_page.fxml");
    }

    public void openSetting(){
        onPage = OnPage.SETTING;
        switchScenes("main_page.fxml");
    }



}
