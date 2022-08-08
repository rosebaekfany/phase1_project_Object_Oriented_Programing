package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import javafx.fxml.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BasePost implements Initializable{
    @FXML
    VBox top ;
    @FXML
    VBox buttom ;
    @FXML
    ImageView image ;

    public static com.yrtwitter.project_phase2.media.Post myShowPost = new  com.yrtwitter.project_phase2.media.Post() ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader topLoader ;
        if (!SwitchScenes.darkTheme) {
            topLoader = new FXMLLoader(Main.class.getResource("postTopLight.fxml"));
        } else {
            topLoader = new FXMLLoader(Main.class.getResource("postTop.fxml"));
        }
        try {
            top.getChildren().add(topLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        FXMLLoader buttomLoader;
        if (!SwitchScenes.darkTheme) {
            buttomLoader = new FXMLLoader(Main.class.getResource("postUnderLight.fxml"));
        } else {
            buttomLoader = new FXMLLoader(Main.class.getResource("postUnder.fxml"));
        }
        try {
            buttom.getChildren().add(buttomLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        FXMLLoader editLoader ;
        if (!SwitchScenes.darkTheme) {
            editLoader = new FXMLLoader(Main.class.getResource("editPostLight.fxml"));
        } else {
            editLoader = new FXMLLoader(Main.class.getResource("editPost.fxml"));
        }
        try {
            buttom.getChildren().add(editLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        Image myImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + myShowPost.imagePath)));
        image.setImage(myImage);

    }
}
