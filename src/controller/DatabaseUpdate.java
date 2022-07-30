
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
                //Class.forName("com.mysql.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/myTwitter", "root", "manager");
            //System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO allregister " + "VALUES ()";


/*            #DataSourceSettings#
#LocalDataSource: myTwitter@localhost
#BEGIN#
<data-source source="LOCAL" name="myTwitter@localhost" uuid="904a0b42-b94b-43ea-b7cf-febb8c99117d"><database-info product="MySQL" version="5.5.5-10.4.24-MariaDB" jdbc-version="4.2" driver-name="MySQL Connector/J" driver-version="mysql-connector-java-8.0.25 (Revision: 08be9e9b4cba6aa115f9b27b215887af40b159e0)" dbms="MARIADB" exact-version="10.4.24" exact-driver-version="8.0"><extra-name-characters>#@</extra-name-characters><identifier-quote-string>`</identifier-quote-string></database-info><case-sensitivity plain-identifiers="lower" quoted-identifiers="lower"/><driver-ref>mysql.8</driver-ref><synchronize>true</synchronize><jdbc-driver>com.mysql.cj.jdbc.Driver</jdbc-driver><jdbc-url>jdbc:mysql://localhost:3306/myTwitter</jdbc-url><secret-storage>master_key</secret-storage><user-name>root</user-name><schema-mapping><introspection-scope><node kind="schema" qname="@"/></introspection-scope></schema-mapping><working-dir>$ProjectFileDir$</working-dir></data-source>
#END#*/
                stmt.executeUpdate(query1);
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
}

/*class UserRepository {

    public void loadUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM user" );
        while (resultSet.next()) {
            Person user = new Person();
            user.userID = (resultSet.getString("userId"));
            user.userType = (resultSet.getString("userType"));
            user.securityQuestion = (resultSet.getString("securityQuestion"));
            user.name = (resultSet.getString("name"));
            user.userAccountType = (resultSet.getString("userAccountType"));
            user.bio = (resultSet.getString("bio"));
            user.userPasswords = (resultSet.getString("userPassword"));
            //user.favoriteGenres = (resultSet.getString("securityQuestionsAnswers"));

        }

        statement.close();
    }

    public void insertUsers(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM user");
        preparedStatement.executeUpdate();
        for (User user : DataBase.getUsers()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO user(userName, password, bio, name, lastName, birthday, email,"+
                            " securityQuestionsAnswers, privacy, numberOfPosts, numberOfFollowers ,numberOfFollowings, userType,date ) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setString(1, user.getUserName());
            preparedStatementA.setString(2, user.getPassword());
            preparedStatementA.setString(3, user.getBio());
            preparedStatementA.setString(4, user.getName());
            preparedStatementA.setString(5, user.getLastName());
            preparedStatementA.setString(6, user.getBirthday());
            preparedStatementA.setString(7, user.getEmail());
            preparedStatementA.setString(8, user.getSecurityQuestionsAnswers());
            if(user.getPrivacy()) {
                preparedStatementA.setInt(9, 1);
            } else {
                preparedStatementA.setInt(9, 0);
            }
            preparedStatementA.setInt(10, user.getNumberOfPosts());
            preparedStatementA.setInt(11, user.getNumberOfFollowers());
            preparedStatementA.setInt(12, user.getNumberOfFollowings());
            if(user.getUserType()) {
                preparedStatementA.setInt(13, 1);
            } else {
                preparedStatementA.setInt(13, 0);
            }
            preparedStatementA.setString(14,user.getDate());
            preparedStatementA.executeUpdate();
        }
    }
}*/


