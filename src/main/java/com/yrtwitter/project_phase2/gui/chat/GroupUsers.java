package com.yrtwitter.project_phase2.gui.chat;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.Group;
import com.yrtwitter.project_phase2.media.Person;
import com.yrtwitter.project_phase2.media.RegisterMenu;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GroupUsers extends SwitchScenes implements Initializable {
    @FXML
    ImageView profile;
    @FXML
    TextField path;
    @FXML
    Button pathButton;
    @FXML
    Button backButton , addMemberButton , addBannedButton;
    @FXML
    VBox memberBox , bannedBox;
    @FXML
    TextField addTextField , bannTextField;
    @FXML
    Label guide;
    @FXML
    Button removeMemberButton;
    @FXML
    TextField removeTextField;

    public static Person addedMember , bannedMember;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pathButton.setOnAction(event -> setImg());

        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + Input.myRegister.grouponBord.profilePath)));
            profile.setImage(image);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        FXMLLoader fxmlLoader;

        for (Person groupUser : Input.myRegister.grouponBord.groupUsers) {
            fxmlLoader = new FXMLLoader(Main.class.getResource("member.fxml"));
            Member.person = groupUser;
            try {
                memberBox.getChildren().add(fxmlLoader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        for (Person bannedUser : Input.myRegister.grouponBord.bannedUsers) {
            fxmlLoader = new FXMLLoader(Main.class.getResource("member.fxml"));
            Member.person = bannedUser;
            try {
                bannedBox.getChildren().add(fxmlLoader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }



        addMemberButton.setOnAction(event -> addMember());
        addBannedButton.setOnAction(event -> addBanned());
        backButton.setOnAction(event -> back());
        removeMemberButton.setOnAction(event -> removeMember());
    }

    private void setImg(){
        String s = path.getText();
        if (s.equals("")){
            return;
        }
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + s)));
            profile.setImage(image);
            Input.myRegister.grouponBord.profilePath = s;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private void addMember(){
        String userID = addTextField.getText();
        if(userID.equals("")){
            return;
        }
        int j, h, ff = 0, gg = 0;
//        for (int i = 0; i < Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap.size(); i++) {
//            if (Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).allMyGroap.get(i).groupId.equals()) {
                for (j = 0; j < Input.myRegister.allRegisters.size(); j++) {
                    if (Input.myRegister.allRegisters.get(j).userID.equals(userID)) {
                        for (h = 0; h < Input.myRegister.grouponBord.bannedUsers.size(); h++) {
                            if (Input.myRegister.grouponBord.bannedUsers.get(h).userID.equals(Input.myRegister.allRegisters.get(j).userID)) {
                                guide.setText("memeber is banned from this group");
                                gg = 1;
                                break;
                            }
                        }
                        if (gg == 0) {
                            Group.addMemeber(Input.myRegister.grouponBord, Input.myRegister.allRegisters.get(j));
                            ff = 1;
                            guide.setText("member is added");
                            onPage = OnPage.GROUP_INFO;
                            switchScenes("main_page.fxml");
                            break;
                        }
                    }
                }
            //}

        //}
        if (ff == 0) {
            guide.setText("you don't have the access");
        }
    }

    private void addBanned(){
        String userId = bannTextField.getText();
        if (userId.equals("")){
            return;
        }
        int ff = 0;
        if (Input.myRegister.grouponBord.admin.userID.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID)) {
            for (int i = 0; i < Input.myRegister.allRegisters.size(); i++) {
                if (Input.myRegister.allRegisters.get(i).userID.equals(userId)) {
                    Group.bannUser(Input.myRegister.grouponBord, Input.myRegister.allRegisters.get(i));
                    guide.setText("banned successfully");
                    ff = 1;
                    onPage = OnPage.GROUP_INFO;
                    switchScenes("main_page.fxml");
                    break;
                }
            }
            if (ff == 0) {
                guide.setText("the userId id incorrect");
            }
        } else {
            guide.setText("only admin can ban users");
        }
    }

    private void removeMember(){
        String userId = removeTextField.getText();
        if (userId.equals("")){
            return;
        }
        int ff = 0;
        if (Input.myRegister.grouponBord.admin.userID.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID)) {
            for (int i = 0; i < Input.myRegister.allRegisters.size(); i++) {
                if (Input.myRegister.allRegisters.get(i).userID.equals(userId)) {
                    Group.removeUser(Input.myRegister.grouponBord, Input.myRegister.allRegisters.get(i));
                    guide.setText("removed successfully");
                    onPage = OnPage.GROUP_INFO;
                    switchScenes("main_page.fxml");
                    ff = 1;
                    break;
                }
            }
            if (ff == 0) {
                guide.setText("the userId id incorrect");
            }
        } else {
            guide.setText("only admin can remove users");

        }
    }

    private void back(){
        onPage = OnPage.GROUP_CHAT;
        switchScenes("main_page.fxml");
    }
}
