
package controller;

import com.sun.org.apache.bcel.internal.generic.Select;
import media.*;
import controller.*;
import view.*;

import java.sql.*;
import java.sql.DriverManager;
import java.util.*;


public class DatabaseUpdate {
    public static void creatConnection() {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mySQL connection", "root", "400110009");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO allregister " + "VALUES ()";
            stmt.executeUpdate(query1);
            //query1 = "INSERT INTO InsertDemo " + "VALUES (2, 'Carol', 42)";
            //stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
        }
        catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void insertMyRegister(RegisterMenu myRegister, Statement myStatment) {
        //ResultSet myResultSet = myStatment.executeQuery(SELECT * FROMallregister);
    }
}


