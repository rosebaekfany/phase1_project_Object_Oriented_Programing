package com.yrtwitter.project_phase2.gui;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.temporary.*;
import com.yrtwitter.project_phase2.view.*;
import com.yrtwitter.project_phase2.controller.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.SearchIdTop.indexSearch;
import static com.yrtwitter.project_phase2.gui.SearchIdTop.mysearchIdResult;
import static com.yrtwitter.project_phase2.view.Input.myRegister;

public class Search extends SwitchScenes{
        @FXML
        VBox topp;
        @FXML
        VBox bodyyy;
        @FXML
        TextField searchId ;

        public static int indexSearch=0;
        public static ArrayList<Person> mysearchIdResult = new ArrayList<>();

        public void search (ActionEvent event) throws IOException {
            bodyyy.getChildren().clear();
            String myid = searchId.getText() ;
            Communication.searchName(myRegister, mysearchIdResult,myid);
            initialize();
        }


    //@Override
    public void initialize () {

        try {
            for (indexSearch = 0; indexSearch < mysearchIdResult.size(); indexSearch++) {
                FXMLLoader singleLoader ;
                if (!SwitchScenes.darkTheme) {
                    singleLoader = new FXMLLoader(Main.class.getResource("searchIdSingleLight.fxml"));
                } else {
                    singleLoader = new FXMLLoader(Main.class.getResource("searchIdSingle.fxml"));
                }
                try {
                    if(bodyyy!=null) {
                        bodyyy.getChildren().add(singleLoader.load());
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mysearchIdResult.clear();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
