package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowState extends SwitchScenes implements Initializable {

    @FXML
    VBox viewed;
    @FXML
    VBox liked;

    public void backToPagee(ActionEvent event) throws IOException {
        onPage = OnPage.MY_PAGE;
        switchScenes("main_page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i , j ;
        for(i=0 ; i< Input.myRegister.allbussinessPost.size() ; i++){
            if(Input.myRegister.allbussinessPost.get(i).postID.equals(BasePost.myShowPost.postID)){
                ArrayList<Integer> views = Input.myRegister.allbussinessPost.get(i).eachDayView();
                if(views!=null){
                    for (j=0 ; j<views.size() ; j++){
                        Label newV= new Label();
                        newV.setText("   "+views.get(j).toString());
                        newV.setFont(new Font(18));
                        newV.setTextAlignment(TextAlignment.CENTER);
                        newV.setTextFill(Color.WHITE);
                        viewed.getChildren().add(newV);
                    }
                }
                break;
            }
        }

        for(i=0 ; i< Input.myRegister.allbussinessPost.size() ; i++){
            if(Input.myRegister.allbussinessPost.get(i).postID.equals(BasePost.myShowPost.postID)){
                ArrayList<Integer> likes = Input.myRegister.allbussinessPost.get(i).eachDayLike();
                if(liked!=null){
                    for (j=0 ; j<likes.size() ; j++){
                        Label newV= new Label();
                        newV.setText("   "+likes.get(j).toString());
                        newV.setFont(new Font(18));
                        newV.setTextAlignment(TextAlignment.CENTER);
                        if(!SwitchScenes.darkTheme){
                            newV.setTextFill(Color.BLACK);
                        }
                        else {
                            newV.setTextFill(Color.WHITE);
                        }
                        liked.getChildren().add(newV);
                    }
                }
                break;
            }
        }

    }
}
