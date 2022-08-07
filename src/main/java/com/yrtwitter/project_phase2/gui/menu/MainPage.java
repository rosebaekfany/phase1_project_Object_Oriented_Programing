package com.yrtwitter.project_phase2.gui.menu;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.view.Input;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPage extends SwitchScenes implements Initializable {
    @FXML
    HBox mainPane;
    @FXML
    VBox menuPane;
    @FXML
    VBox contentPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("menu.fxml"));
        FXMLLoader fxmlLoader2;

        switch (onPage){
            //case START -> fxmlLoader2 =  new FXMLLoader(Main.class.getResource("startPage.fxml"));
            case HOME -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if(!SwitchScenes.darkTheme){
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("mainBaseLight.fxml"));
                }
                else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("mainBase.fxml"));
                }
            }
            case MY_PAGE -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                SearchIdSingle.myPersonPage= Input.myRegister.allRegisters.get(Input.myRegister.logedInAccount);
                if(!SwitchScenes.darkTheme){
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("myPageLight.fxml"));
                }
                else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("myPage.fxml"));
                }
            }
            case SEARCH -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("searchLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("search.fxml"));

                }
            }
            case SBS_PAGE -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("myPageLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("myPage.fxml"));
                }
            }
            case CONTACTS -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("chat_seperatorLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("chat_seperator.fxml"));
                }
            }
            case SETTING -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("settingLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("setting.fxml"));
                }
            }
            case GROUP_CHAT -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("group_chatLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("group_chat.fxml"));
                }
            }
            case GROUP_INFO -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("groupUsersLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("groupUsers.fxml"));
                }
            }
            case PRIVATE_CHAT -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("chatLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("chat.fxml"));
                }
            }
            case LIKE_POST -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("showPostLikesLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("showPostLikes.fxml"));
                }
            }
            case COMMENT_POST -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("postCommentLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("postComment.fxml"));
                }
            }
            case creatPost -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("creatPostLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("creatPost.fxml"));
                }
            }
            case removeFollow -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("removeFollowLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("removeFollow.fxml"));
                }
            }
            case massageRequestBase -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("massageRequestBaseLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("massageRequestBase.fxml"));
                }

            }
            case followerList -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("followerListLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("followerList.fxml"));
                }
            }
            case followingList -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("followingListLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("followingList.fxml"));
                }
            }
            case suggestedPersonBase -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("suggestedPersonBaseLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("suggestedPersonBase.fxml"));
                }
            }
            case showState -> {
                contentPane.getChildren().clear();
                menuPane.getChildren().clear();
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("showStateLight.fxml"));
                } else {
                    fxmlLoader2 = new FXMLLoader(Main.class.getResource("showState.fxml"));
                }
            }
            default -> {
                if (!SwitchScenes.darkTheme) {
                    fxmlLoader2 =  new FXMLLoader(Main.class.getResource("startPageLight.fxml"));
                } else {
                    fxmlLoader2 =  new FXMLLoader(Main.class.getResource("startPage.fxml"));
                }
            }
        }

        try {
            Node node1 = fxmlLoader1.load();
            Node node2 = fxmlLoader2.load();
            contentPane.getChildren().add(node2);
            menuPane.getChildren().add(node1);
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}