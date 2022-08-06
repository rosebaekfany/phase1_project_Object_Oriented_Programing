package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.SearchIdTop.indexSearch;
import static com.yrtwitter.project_phase2.gui.SearchIdTop.mysearchIdResult;


public class SearchIdSingle extends SwitchScenes implements Initializable{
     @FXML
     Label username;
     @FXML
     Label userid;
     @FXML
     Label userAccountType;

     public static Person myPersonPage = new Person();

     public void enterPage (ActionEvent event) throws IOException {
         int i;
         for (i=0 ; i< Input.myRegister.allRegisters.size() ; i++){
             if(Input.myRegister.allRegisters.get(i).userID.equals(userid.getText().toString())){
                 myPersonPage=Input.myRegister.allRegisters.get(i);
                 SwitchScenes.onPage = OnPage.SBS_PAGE;
                 switchScenes("main_page.fxml");
             }
         }
     }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(Search.mysearchIdResult.get(indexSearch).name.toString());
        userid.setText(Search.mysearchIdResult.get(indexSearch).userID.toString());
        userAccountType.setText((Search.mysearchIdResult.get(indexSearch).userAccountType.toString()));
    }
}
