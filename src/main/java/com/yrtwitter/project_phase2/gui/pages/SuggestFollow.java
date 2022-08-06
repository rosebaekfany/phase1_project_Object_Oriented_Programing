package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.controller.Communication;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuggestFollow extends SwitchScenes implements Initializable {

    @FXML
    Label suggestId;

    public void followSuggest (ActionEvent event) throws IOException {
        Communication.followSb(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), suggestId.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        suggestId.setText("  "+SuggestedPersonBase.suggestedPerson.get(SuggestedPersonBase.suggestedIndex).userID);
        suggestId.setFont(new Font(18));
        suggestId.setTextAlignment(TextAlignment.CENTER);
        suggestId.setTextFill(Color.WHITE);
    }
}
