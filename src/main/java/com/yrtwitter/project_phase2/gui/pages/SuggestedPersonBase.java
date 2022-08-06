package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.controller.Commercial;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SuggestedPersonBase extends SwitchScenes implements Initializable {

    @FXML
    VBox suggestedBox;

    public static ArrayList<Person> suggestedPerson = new ArrayList<>();
    public static int suggestedIndex;

    public void backToPage(ActionEvent event) throws IOException {
        switchScenes("myPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(suggestedBox!=null) {
            suggestedPerson = Commercial.sortSuggestedPerson(SearchIdSingle.myPersonPage);
            for (suggestedIndex = 0; suggestedIndex< suggestedPerson.size(); suggestedIndex++) {
                FXMLLoader suggest = new FXMLLoader(Main.class.getResource("suggestFollow.fxml"));
                try {
                    suggestedBox.getChildren().add(suggest.load());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            suggestedPerson.clear();
        }
    }
}
