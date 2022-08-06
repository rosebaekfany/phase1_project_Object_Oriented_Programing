package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MyGroups extends SwitchScenes implements Initializable {
    @FXML
    ScrollPane group_scrollPane;
    @FXML
    VBox group_back;

    public static int groupNum = -1;
    private int allGroupChatsNum = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap.size();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group_back.setStyle("-fx-background-color: #535353");
        FXMLLoader fxmlLoader;
        try {
            for (groupNum = allGroupChatsNum-1; groupNum >= 0; groupNum--) {
                fxmlLoader = new FXMLLoader(Main.class.getResource("each_group.fxml"));
                group_back.getChildren().add(fxmlLoader.load());
            } groupNum = -1;
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
