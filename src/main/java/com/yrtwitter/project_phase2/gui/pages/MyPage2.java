package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPage2 extends SwitchScenes implements Initializable {

    @FXML
    VBox pageTop;
    @FXML
    VBox pageBody;
    @FXML
    VBox pageButtom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader topLoader = new FXMLLoader(Main.class.getResource("myPageTop.fxml"));
        try {
            pageTop.getChildren().add(topLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        if(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID.equals(SearchIdSingle.myPersonPage.userID)){
            FXMLLoader buttomLoader = new FXMLLoader(Main.class.getResource("createpostIcon.fxml"));
            try {
                pageButtom.getChildren().add(buttomLoader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            FXMLLoader buttomLoader = new FXMLLoader(Main.class.getResource("follow&unfollow.fxml"));
            try {
                pageButtom.getChildren().add(buttomLoader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        int i ;
        int  j, flag = 0;
        for (i = 0; i < Input.myRegister.allRegisters.size(); i++) {
            if (Input.myRegister.allRegisters.get(i).userID.equals(SearchIdSingle.myPersonPage.userID)) {
                if (Input.myRegister.allRegisters.get(i).userType.equals("private")) {
                    for (j = 0; j < Input.myRegister.allRegisters.get(i).folowers.size(); j++) {
                        if (Input.myRegister.allRegisters.get(i).folowers.get(j).userID.equals(SearchIdSingle.myPersonPage.userID)) {
                            flag = 1;
                            break;
                        }
                    }
                } else {
                    flag = 1;
                }
                break;
            }
        }
        if (flag == 1) {
            for(i=0 ; i<SearchIdSingle.myPersonPage.posts.size() ; i++){
                BasePost.myShowPost=SearchIdSingle.myPersonPage.posts.get(i);
                FXMLLoader bodyLoader = new FXMLLoader(Main.class.getResource("postBase.fxml"));
                try {
                    pageBody.getChildren().add(bodyLoader.load());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
}
