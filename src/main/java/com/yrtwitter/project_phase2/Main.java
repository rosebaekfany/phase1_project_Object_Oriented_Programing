package com.yrtwitter.project_phase2;

import com.yrtwitter.project_phase2.controller.*;
import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.view.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        //TEST
        Person me = new Person();
        me.name = "yekta";
        me.userID = "yekta";
        me.userPasswords = "1111";

        Person friend1 = new Person();
        friend1.name = "Mahnoosh";

        Person friend2 = new Person();
        friend2.name = "Rosa";

        Input.myRegister.allRegisters.add(me);
        Input.myRegister.allRegisters.add(friend1);
        Input.myRegister.allRegisters.add(friend2);

        Chat myChat1 = new Chat();
        myChat1.person1 = friend1;
        myChat1.person2 = me;
        Post chat1Post = new Post();
        chat1Post.script = "Hello good morning";
        myChat1.allTexts.add(chat1Post);

        Chat myChat2 = new Chat();
        myChat2.person2 = friend2;
        myChat2.person1 = me;
        Post chat2Post = new Post();
        chat2Post.script = "Hello good morning 2";
        myChat2.allTexts.add(chat2Post);

        Group group1 = new Group();
        group1.groupName = "myGroup1";
        group1.allTexts.add(chat2Post);
        group1.groupUsers.add(me);
        group1.groupUsers.add(friend1);

        Group group2 = new Group();
        group2.groupName = "newGroup";
        group2.allTexts.add(chat2Post);
        Post group2Post = new Post();
        group2Post.script = "this is a new group";
        group2.allTexts.add(group2Post);
        group2.groupUsers.add(me);

        me.allPersonalChats.add(myChat1);
        me.allPersonalChats.add(myChat2);
        me.allMyGroap.add(group1);
        me.allMyGroap.add(group2);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        SwitchScenes.window = stage;
        SwitchScenes.window.setTitle("Rosa_Yekta_Twitter");
        SwitchScenes.window.setScene(scene);
        SwitchScenes.window.setWidth(800.0);
        SwitchScenes.window.setHeight(640.0);
        SwitchScenes.window.show();
    }

    public static void main(String[] args) throws SQLException {

        Input myInput = new Input();

        Connection conn = null;
        Statement stmt = null;
       /* try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myTwitter", "root", "manager");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO allregister " + "VALUES ()";

            stmt.executeUpdate(query1);
        }
        catch (SQLException excep) {
            excep.printStackTrace();
        }
        catch (Exception excep) {
            excep.printStackTrace();
        }

        myInput.register_menu(conn);

        while (myInput.registerMenu == 1) {
            myInput.inputRegister();
        }
        if(myInput.registerMenu == 0){
            DatabaseUpdate.insertAll(myInput.myRegister,conn);
            conn.close();
        }*/


        launch();

       /* view.Input myInput = new view.Input() ;
        myInput.register_menu();
        while (myInput.registerMenu==1){
            myInput.inputRegister();
        }*/
    }
}

// ToDO : css stylesheet ->
//                          .selected { -fx-background-color : #color }
//                          .mouse-moved: hover { -fx-background-color : #color }
//      then add this to the buttons stylesheet in sceneBuilder