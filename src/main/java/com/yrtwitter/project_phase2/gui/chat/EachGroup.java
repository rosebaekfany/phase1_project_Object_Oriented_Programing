package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Group;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EachGroup extends MyGroups implements Initializable {
    @FXML
    ImageView profile;
    @FXML
    HBox back;
    @FXML
    Label name , text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        back.setOnMouseClicked(mouseEvent -> enterGroup());
        if (groupNum != -1){
            Group thisGroup = Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap.get(groupNum);

            try {
                text.setText(thisGroup.allTexts.get(thisGroup.allTexts.size()-1).script);
            }catch (Exception e){
                text.setText("GROUP JUST CREATED");
                System.out.println(e.fillInStackTrace());
                System.out.println(groupNum);
            }
            name.setText(thisGroup.groupName);


        }
    }

    public void enterGroup(){
        Input.myRegister.grouponBord = findGroup(name.getText());
        SwitchScenes.onPage = OnPage.GROUP_CHAT;
        switchScenes("main_page.fxml");
    }

    private Group findGroup(String groupName){
        for (Group group : Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap) {
            if (groupName.equals(group.groupName)){
                return group;
            }
        }
        return null;
    }
}
