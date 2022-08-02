/*
package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.* ;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JavaInsertDemo {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myTwitter", "root", "400110009");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO InsertDemo " + "VALUES (1, 'John', 34)";
            stmt.executeUpdate(query1);
            query1 = "INSERT INTO InsertDemo " + "VALUES (2, 'Carol', 42)";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");
    }
}

public class DatabaseUpdate {

    String myDriver = "org.gjt.mm.mysql.Driver";
    String myUrl = "jdbc:mysql://localhost/test";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "root", "");

    String sql = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
            + " values (?, ?, ?, ?, ?)";
    PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString (1, s.first_name);
      preparedStmt.setString (2, s.last_name);
      preparedStmt.setDate   (3, s.date_created);
      preparedStmt.setBoolean(4, s.is_admin);
      preparedStmt.setInt    (5, s.num_points);

        preparedStmt.execute();
        conn.close();
         catch (Exception e)
    {
        System.err.println("Got an exception!");
        // printStackTrace method
        // prints line numbers + call stack
        e.printStackTrace();
        // Prints what exception has been thrown
        System.out.println(e);
    }



}
*/
