package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.media.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.view.Input.myRegister;

public class SearchIdTop extends SwitchScenes implements Initializable {

    @FXML
    TextField searchId ;

    public static int indexSearch;

    public static ArrayList<Person> mysearchIdResult = new ArrayList<>();

    public void search (ActionEvent event) throws IOException {
        String myid = searchId.getText() ;
        Communication.searchName(myRegister, mysearchIdResult,myid);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
