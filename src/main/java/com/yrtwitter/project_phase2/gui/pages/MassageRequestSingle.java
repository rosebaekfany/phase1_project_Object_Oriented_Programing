package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.controller.Edit;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
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

public class MassageRequestSingle extends SwitchScenes implements Initializable {

    @FXML
    Label massageRequest;

    public void confirmRequest (ActionEvent event) throws IOException {
        Edit.confirmFollow(Input.myRegister, Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount), MassageRequestBase.requestIndex);
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        massageRequest.setText("   "+SearchIdSingle.myPersonPage.massageRequests.get(MassageRequestBase.requestIndex));
        massageRequest.setFont(new Font(18));
        massageRequest.setTextAlignment(TextAlignment.CENTER);
        massageRequest.setTextFill(Color.WHITE);
    }
}
