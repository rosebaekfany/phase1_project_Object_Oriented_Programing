import controller.DatabaseUpdate;
import view.Input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) throws SQLException {
        Input myInput = new Input();

        Connection conn = null;
        Statement stmt = null;
        try {
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
        }
    }
}
