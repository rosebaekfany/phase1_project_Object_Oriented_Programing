
package controller;

import com.sun.org.apache.bcel.internal.generic.Select;
import media.*;
import controller.*;
import view.*;

import java.sql.*;
import java.sql.DriverManager;

import java.util.*;
import static temporary.CommercialGenres.*;


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

class UserRepository {

    public void loadUsers(RegisterMenu allRegister , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM allregister" );
        while (resultSet.next()) {
            int i ;
            Person user = new Person();
            user.userID = (resultSet.getString("userId"));
            user.userType = (resultSet.getString("userType"));
            user.securityQuestion = (resultSet.getString("securityQuestion"));
            user.name = (resultSet.getString("name"));
            user.userAccountType = (resultSet.getString("userAccountType"));
            user.bio = (resultSet.getString("bio"));
            user.userPasswords = (resultSet.getString("userPassword"));
            for(i=0 ; i<6 ; i++){
                if(resultSet.getInt("gene_HEALTH_AND_CARE")==i){
                    user.favoriteGenres[i]=HEALTH_AND_CARE ;
                }
                else if(resultSet.getInt("gene_FASHION")==i){
                    user.favoriteGenres[i]=FASHION ;
                }
                else if(resultSet.getInt("gene_SCIENCE_AND_TECHNOLOGY")==i){
                    user.favoriteGenres[i]= SCIENCE_AND_TECHNOLOGY ;
                }
                else if(resultSet.getInt("gene_STOCK_MARKET")==i){
                    user.favoriteGenres[i]=STOCK_MARKET ;
                }
                else if(resultSet.getInt("gene_ARTS")==i){
                    user.favoriteGenres[i]=ARTS ;
                }
                else if(resultSet.getInt("gene_GAMING")==i){
                    user.favoriteGenres[i]=GAMING ;
                }

            }
            allRegister.allRegisters.add(user) ;
        }

        statement.close();
    }

/*    public void insertUsers(Connection connection ) throws SQLException {
        int i , j ;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM user");
        preparedStatement.executeUpdate();
        for(j=0 ; j<)
        for ( i=0 ; i<8 ; i++){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO user(userType, userPassword, bio, name, userAccountType"+
                            " securityQuestion ,userId , ) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setString( user.getUserName());
            preparedStatementA.setString(user.getPassword());
            preparedStatementA.setString( user.getBio());
            preparedStatementA.setString( user.getName());
            preparedStatementA.setString( user.getLastName());
            preparedStatementA.setString( user.getBirthday());
            preparedStatementA.setString( user.getEmail());
            preparedStatementA.setString( user.getSecurityQuestionsAnswers());
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
    }*/
}


