
package controller;

import com.sun.org.apache.bcel.internal.generic.Select;
import media.*;
import controller.*;
import view.*;

import java.sql.*;
import java.sql.DriverManager;

import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import static temporary.CommercialGenres.*;


public class DatabaseUpdate {
    public static void creatConnection() {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                //Class.forName("com.mysql.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
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
        } catch (SQLException excep) {
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

    public void loadUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM allregister");
        while (resultSet.next()) {
            int i;
            Person user = new Person();
            user.userID = (resultSet.getString("userId"));
            user.userType = (resultSet.getString("userType"));
            user.securityQuestion = (resultSet.getString("securityQuestion"));
            user.name = (resultSet.getString("name"));
            user.userAccountType = (resultSet.getString("userAccountType"));
            user.bio = (resultSet.getString("bio"));
            user.userPasswords = (resultSet.getString("userPassword"));
            for (i = 0; i < 6; i++) {
                if (resultSet.getInt("gene_HEALTH_AND_CARE") == i) {
                    user.favoriteGenres[i] = HEALTH_AND_CARE;
                } else if (resultSet.getInt("gene_FASHION") == i) {
                    user.favoriteGenres[i] = FASHION;
                } else if (resultSet.getInt("gene_SCIENCE_AND_TECHNOLOGY") == i) {
                    user.favoriteGenres[i] = SCIENCE_AND_TECHNOLOGY;
                } else if (resultSet.getInt("gene_STOCK_MARKET") == i) {
                    user.favoriteGenres[i] = STOCK_MARKET;
                } else if (resultSet.getInt("gene_ARTS") == i) {
                    user.favoriteGenres[i] = ARTS;
                } else if (resultSet.getInt("gene_GAMING") == i) {
                    user.favoriteGenres[i] = GAMING;
                }

            }
            allRegister.allRegisters.add(user);
        }

        statement.close();
    }

    public void insertUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM allregister");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO allregister(userType, userPassword, bio, name, userAccountType" +
                            " securityQuestion ,userId , gene_HEALTH_AND_CARE , gene_FASHION , gene_SCIENCE_AND_TECHNOLOGY , gene_STOCK_MARKET , gene_ARTS , gene_GAMING) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setString(1, allRegister.allRegisters.get(j).userType);
            preparedStatementA.setString(2, allRegister.allRegisters.get(j).userPasswords);
            preparedStatementA.setString(3, allRegister.allRegisters.get(j).bio);
            preparedStatementA.setString(4, allRegister.allRegisters.get(j).name);
            preparedStatementA.setString(5, allRegister.allRegisters.get(j).userAccountType);
            preparedStatementA.setString(6, allRegister.allRegisters.get(j).securityQuestion);
            preparedStatementA.setString(7, allRegister.allRegisters.get(j).userID);
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(HEALTH_AND_CARE)) {
                    preparedStatementA.setInt(8, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(FASHION)) {
                    preparedStatementA.setInt(9, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(SCIENCE_AND_TECHNOLOGY)) {
                    preparedStatementA.setInt(10, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(STOCK_MARKET)) {
                    preparedStatementA.setInt(11, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(ARTS)) {
                    preparedStatementA.setInt(12, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.allRegisters.get(j).favoriteGenres[i].equals(GAMING)) {
                    preparedStatementA.setInt(13, i);
                    break;
                }
            }

            preparedStatementA.executeUpdate();

        }
    }

}

class PostRepository {

    public void loadPosts(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM post");
        while (resultSet.next()) {
            int i;
            Post myPost = new Post();
            myPost.postID = resultSet.getString("postId");
            myPost.usersPostId = resultSet.getString("usersPostId");
            myPost.forwarded = resultSet.getString("forwarded");
            myPost.edited = resultSet.getString("edited");
            myPost.script = resultSet.getString("script");
            Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
            myPost.postDate = myDate;
            for (index = 0; index < allRegister.allRegisters.size(); index++) {
                if (allRegister.allRegisters.get(index).userID.equals(myPost.usersPostId)) {
                    allRegister.allRegisters.get(index).posts.add(myPost);
                    allRegister.allPosts.add(myPost);
                    break;
                }
            }

        }
        statement.close();
    }

    public void insertPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM post");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO post(postId,usersPostId,forwarded,edited,script,postDate) " +
                            "VALUES(?, ?, ?, ?, ?, ?)");
            for (i = 0; i < allRegister.allRegisters.get(j).posts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).posts.get(i).postID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).posts.get(i).usersPostId);
                preparedStatementA.setString(3, allRegister.allRegisters.get(j).posts.get(i).forwarded);
                preparedStatementA.setString(4, allRegister.allRegisters.get(j).posts.get(i).edited);
                preparedStatementA.setString(5, allRegister.allRegisters.get(j).posts.get(i).script);
                preparedStatementA.setString(6, String.valueOf(allRegister.allRegisters.get(j).posts.get(i).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class likedPostRepository {

    public void loadLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM likephoto");
        while (resultSet.next()) {
            int i, j;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                    for (j = 0; j < allRegister.allPosts.size(); j++) {
                        if (allRegister.allPosts.get(j).postID.equals(resultSet.getString("postId"))) {
                            allRegister.allPosts.get(j).likedUsers.add(allRegister.allRegisters.get(i));
                            allRegister.allRegisters.get(i).likedPhotoes.add(allRegister.allPosts.get(j));
                            break;
                        }
                    }
                    break;
                }
            }

        }
        statement.close();
    }

    public void insertLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM likephoto");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO likephoto(postId,usersId) " +
                            "VALUES(?, ?)");
            for (i = 0; i < allRegister.allRegisters.get(j).likedPhotoes.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).likedPhotoes.get(i).postID);
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class draftPostRepository {

    public void loadDraftPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM drafpost");
        while (resultSet.next()) {
            int i, j;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                    Post myDrafPost = new Post();
                    myDrafPost.postID = resultSet.getString("postId");
                    myDrafPost.script = resultSet.getString("script");
                    Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
                    myDrafPost.postDate = myDate;
                    myDrafPost.edited = "";
                    myDrafPost.forwarded = "";
                    allRegister.allRegisters.get(i).draftPosts.add(myDrafPost);
                    break;
                }
            }

        }
        statement.close();
    }

    public void insertDraftPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM drafpost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO likephoto(usersId,postId,script,postDate) " +
                            "VALUES(?,?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).draftPosts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).draftPosts.get(i).postID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).draftPosts.get(i).script);
                preparedStatementA.setString(2, String.valueOf(allRegister.allRegisters.get(j).draftPosts.get(i).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }
        }
    }

}

/*
class viewPostRepository {

    public void loadViewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM drafpost");
        while (resultSet.next()) {
            int i, j;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                    Post myDrafPost = new Post();
                    myDrafPost.postID = resultSet.getString("postId");
                    myDrafPost.script = resultSet.getString("script");
                    Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
                    myDrafPost.postDate = myDate;
                    myDrafPost.edited = "";
                    myDrafPost.forwarded = "";
                    allRegister.allRegisters.get(i).draftPosts.add(myDrafPost);
                    break;
                }
            }

        }
        statement.close();
    }

    public void insertViewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM drafpost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO likephoto(usersId,postId,script,postDate) " +
                            "VALUES(?,?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).draftPosts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).draftPosts.get(i).postID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).draftPosts.get(i).script);
                preparedStatementA.setString(2, String.valueOf(allRegister.allRegisters.get(j).draftPosts.get(i).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }
        }
    }

}
*/



