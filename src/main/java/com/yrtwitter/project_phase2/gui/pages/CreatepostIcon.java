package com.yrtwitter.project_phase2.gui.pages;

import com.yrtwitter.project_phase2.Main;
import com.yrtwitter.project_phase2.controller.DatabaseUpdate;
import com.yrtwitter.project_phase2.gui.SearchIdSingle;
import com.yrtwitter.project_phase2.gui.SwitchScenes;
import com.yrtwitter.project_phase2.gui.menu.OnPage;
import com.yrtwitter.project_phase2.view.Input;
import com.yrtwitter.project_phase2.view.Show;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreatepostIcon extends SwitchScenes implements Initializable {

    @FXML
    Button stat;

    public void massage(ActionEvent event) throws IOException {
        onPage = OnPage.massageRequestBase;
        switchScenes("main_page.fxml");
    }
    public void creatPost(ActionEvent event) throws IOException {
        onPage = OnPage.creatPost;
        switchScenes("main_page.fxml");
    }
    public void con(ActionEvent event) throws IOException {
        onPage = OnPage.removeFollow;
        switchScenes("main_page.fxml");
    }
    public void exit(ActionEvent event) throws IOException, SQLException {
        Input.registerMenu=0;
        /*Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mytwitter", "root", "manager");
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

        DatabaseUpdate.insertAll(Input.myRegister,conn);
        try {
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("finished");*/
        Platform.exit();
    }
    public void showState(ActionEvent event) throws IOException, SQLException {
        for (i = 0; i < myRegister.allbussinessPost.size(); i++) {
            if (myRegister.allbussinessPost.get(i).postID.equals(split[1]) && myRegister.allbussinessPost.get(i).usersPostId.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                Show.show_stat(myRegister.allbussinessPost.get(i));
                ff = 1;
                break;
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(SearchIdSingle.myPersonPage.userAccountType.equals("Business_Account")){}
        else{
            stat.setVisible(false);
        }
    }
}
