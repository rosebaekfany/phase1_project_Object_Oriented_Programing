package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MyChats extends SwitchScenes implements Initializable {

    @FXML
    ScrollPane personal_scrollPane, group_scrollPane;
    @FXML
    Tab personalTab, groupTab;
    @FXML
    VBox personal_back, group_back;

    public static int groupNum = -1;
    public static int chatNum = -1;

    private int allPersonalChatsNum = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allPersonalChats.size();
    private int allGroupChatsNum = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap.size();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalTab.closableProperty().set(false);
        groupTab.closableProperty().set(false);
        personal_back.setStyle("-fx-background-color: #535353");
        group_back.setStyle("-fx-background-color: #535353");
        FXMLLoader fxmlLoader;

        try {
            for (chatNum = allPersonalChatsNum-1; chatNum >= 0; chatNum--) {
                fxmlLoader = new FXMLLoader(Main.class.getResource("each_contact.fxml"));
                personal_back.getChildren().add(fxmlLoader.load());
            } chatNum = -1;
            for (groupNum = allGroupChatsNum-1; groupNum >= 0; groupNum--) {
                fxmlLoader = new FXMLLoader(Main.class.getResource("each_contact.fxml"));
                group_back.getChildren().add(fxmlLoader.load());
            } groupNum = -1;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }


    }
}
