package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.media.BusinessPost;
import com.yrtwitter.project_phase2.view.Input;
import com.yrtwitter.project_phase2.view.Show;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.yrtwitter.project_phase2.gui.pages.BasePost.myShowPost;

public class postTop extends SwitchScenes implements Initializable {

    @FXML
    Label userid ;
    @FXML
    Label postid ;
    @FXML
    Button stat;
    @FXML
    ImageView imm;

    public static BusinessPost myShowBusinessPost = new BusinessPost();

    public void showState(ActionEvent event) throws IOException, SQLException {
        int i ;
        for (i = 0; i < Input.myRegister.allbussinessPost.size(); i++) {
            if (Input.myRegister.allbussinessPost.get(i).postID.equals(postid.getText()) && Input.myRegister.allbussinessPost.get(i).usersPostId.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID)) {
                //Show.show_stat(Input.myRegister.allbussinessPost.get(i));
                myShowBusinessPost=Input.myRegister.allbussinessPost.get(i);
                onPage = OnPage.showState ;
                switchScenes("main_page.fxml");
                break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userid.setText(BasePost.myShowPost.usersPostId);
        postid.setText(BasePost.myShowPost.postID);

        if(SearchIdSingle.myPersonPage.userAccountType.equals("Business_Account") && SearchIdSingle.myPersonPage.userID.equals(Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount).userID)){}
        else{
            stat.setVisible(false);
        }
        int i ;
        for(i=0 ; i<Input.myRegister.allRegisters.size() ; i++){
            if(Input.myRegister.allRegisters.get(i).userID.equals(myShowPost.usersPostId)){
                Image myIm = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + Input.myRegister.allRegisters.get(i).profilePath)));
                imm.setImage(myIm);
                break;
            }
        }

    }
}
