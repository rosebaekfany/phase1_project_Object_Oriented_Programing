
package controller;

import media.*;
import controller.*;
import view.*;

import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.*;
import java.util.*;
import java.util.Date;

import static temporary.CommercialGenres.*;


public class DatabaseUpdate {
    public static void loadAll(RegisterMenu allRegister , Connection conn) throws SQLException {
        UserRepository.loadUsers(allRegister,conn);
        PostRepository.loadPosts(allRegister,conn); ;
        likedPostRepository.loadLikedPost(allRegister,conn);
        draftPostRepository.loadDraftPost(allRegister,conn);
        viewPostRepository.loadViewPost(allRegister,conn);
        followRepository.loadfollows(allRegister,conn);
        CommentRepository.loadPosts(allRegister,conn);
        RequestMassageRepository.loadRequestMassage(allRegister,conn);
        BussinessUserRepository.loadBussinessUsers(allRegister,conn);
        likedBussinessPostRepository.loadLikedPost(allRegister,conn);
        viewedBussinessPostRepository.loadviewPost(allRegister,conn);

    }
    public static void insertAll(RegisterMenu allRegister , Connection conn) throws SQLException {
        UserRepository.insertUsers(allRegister,conn);
        PostRepository.insertPost(allRegister,conn); ;
        likedPostRepository.insertLikedPost(allRegister,conn);
        draftPostRepository.insertDraftPost(allRegister,conn);
        viewPostRepository.insertViewPost(allRegister,conn);
        followRepository.insertfollows(allRegister,conn);
        CommentRepository.insertPost(allRegister,conn);
        RequestMassageRepository.insertRequestMassage(allRegister,conn);
        BussinessUserRepository.insertBussinessUsers(allRegister,conn);
        likedBussinessPostRepository.insertLikedPost(allRegister,conn);
        viewedBussinessPostRepository.insertviewPost(allRegister,conn);
    }
}

class UserRepository {

    public static void loadUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
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

    public static void insertUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
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

    public static void loadPosts(RegisterMenu allRegister, Connection connection) throws SQLException {
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
            if(resultSet.getInt("BorG")==0){
                myPost.commercialPost=false ;
            }
            else if(resultSet.getInt("BorG")==1){
                myPost.commercialPost=true ;
            }
            for (index = 0; index < allRegister.allRegisters.size(); index++) {
                if (allRegister.allRegisters.get(index).userID.equals(myPost.usersPostId)) {
                    allRegister.allRegisters.get(index).posts.add(myPost);
                    allRegister.allPosts.add(myPost);
                    break;
                }
            }
            if(myPost.commercialPost){
                BusinessPost myBussinessPost = new BusinessPost() ;
                myBussinessPost.commercialPost=true ;
                myBussinessPost.postID=myPost.postID;
                myBussinessPost.usersPostId=myPost.usersPostId;
                myBussinessPost.postDate=myPost.postDate;
                myBussinessPost.script=myPost.postID;
                myBussinessPost.edited=myPost.edited;
                myBussinessPost.forwarded=myPost.forwarded;
                allRegister.allbussinessPost.add(myBussinessPost);
            }

        }
        statement.close();
    }

    public static void insertPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM post");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO post(postId,usersPostId,forwarded,edited,script,postDate,BorG) " +
                            "VALUES(?, ?, ?, ?, ?, ?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).posts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).posts.get(i).postID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).posts.get(i).usersPostId);
                preparedStatementA.setString(3, allRegister.allRegisters.get(j).posts.get(i).forwarded);
                preparedStatementA.setString(4, allRegister.allRegisters.get(j).posts.get(i).edited);
                preparedStatementA.setString(5, allRegister.allRegisters.get(j).posts.get(i).script);
                preparedStatementA.setString(6, String.valueOf(allRegister.allRegisters.get(j).posts.get(i).postDate.getTime()));
                if(allRegister.allRegisters.get(j).posts.get(i).commercialPost){
                    preparedStatementA.setInt(7,1);
                }
                else{
                    preparedStatementA.setInt(7,0);
                }
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class likedPostRepository {

    public static void loadLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
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

    public static void insertLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM likephoto");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO likephoto(usersId,postId) " +
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

    public static void loadDraftPost(RegisterMenu allRegister, Connection connection) throws SQLException {
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

    public static void insertDraftPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM drafpost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO drafpost(usersId,postId,script,postDate) " +
                            "VALUES(?,?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).draftPosts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).draftPosts.get(i).postID);
                preparedStatementA.setString(3, allRegister.allRegisters.get(j).draftPosts.get(i).script);
                preparedStatementA.setString(4, String.valueOf(allRegister.allRegisters.get(j).draftPosts.get(i).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class viewPostRepository {

    public static void loadViewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM viewpost");
        while (resultSet.next()) {
            int i, j;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                    for (j = 0; j < allRegister.allPosts.size(); j++) {
                        if (allRegister.allPosts.get(j).postID.equals(resultSet.getString("postId"))) {
                            allRegister.allPosts.get(j).viewedUsers.add(allRegister.allRegisters.get(i));
                            allRegister.allRegisters.get(i).viewedPosts.add(allRegister.allPosts.get(j));
                            break;
                        }
                    }
                    break;
                }
            }

        }

        statement.close();
    }

    public static void insertViewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM viewpost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO viewpost(usersId,postId) " +
                            "VALUES(?,?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).draftPosts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).viewedPosts.get(i).postID);
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class followRepository {

    public static void loadfollows(RegisterMenu allRegister, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM follower");
        while (resultSet.next()) {
            int i, j;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (resultSet.getString("folloewerId").equals(allRegister.allRegisters.get(i))) {
                    for (j = 0; j < allRegister.allRegisters.size(); j++) {
                        if (resultSet.getString("followedId").equals(allRegister.allRegisters.get(j))) {
                            allRegister.allRegisters.get(i).folowings.add(allRegister.allRegisters.get(j));
                            allRegister.allRegisters.get(j).folowers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                    break;
                }
            }
        }

        statement.close();
    }

    public static void insertfollows(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM follower");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO follower(folloewerId, followedId) " +
                            "VALUES(?, ?)");
            for (i = 0; i < allRegister.allRegisters.get(j).folowings.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).folowings.get(i).userID);
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class CommentRepository {

    public static void loadPosts(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM comment");
        while (resultSet.next()) {
            int i;
            Comment myPost = new Comment();
            myPost.postID = resultSet.getString("postId");
            myPost.usersPostId = resultSet.getString("usersPostId");
            myPost.forwarded = resultSet.getString("forwarded");
            myPost.edited = resultSet.getString("edited");
            myPost.script = resultSet.getString("script");
            Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
            myPost.postDate = myDate;

            for (i = 0; i < allRegister.allPosts.size(); i++) {
                if (allRegister.allPosts.get(i).postID.equals(resultSet.getString("postIdOfComment"))) {
                    myPost.postOfTheComment = allRegister.allPosts.get(i);
                    allRegister.allPosts.get(i).postComments.add(myPost);
                    break;
                }
            }

            for (index = 0; index < allRegister.allRegisters.size(); index++) {
                if (allRegister.allRegisters.get(index).userID.equals(myPost.usersPostId)) {
                    allRegister.allRegisters.get(index).allComment.add(myPost);
                    allRegister.allRegisters.get(index).posts.add(myPost);
                    break;
                }
            }

        }

        statement.close();
    }

    public static void insertPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM comment");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO comment(postIdOfComment,postId,usersPostId,forwarded,edited,script,date) " +
                            "VALUES(?,?,?,?,?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).allComment.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).allComment.get(i).postOfTheComment.postID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).allComment.get(i).postID);
                preparedStatementA.setString(3, allRegister.allRegisters.get(j).allComment.get(i).usersPostId);
                preparedStatementA.setString(4, allRegister.allRegisters.get(j).allComment.get(i).forwarded);
                preparedStatementA.setString(5, allRegister.allRegisters.get(j).allComment.get(i).edited);
                preparedStatementA.setString(6, allRegister.allRegisters.get(j).allComment.get(i).script);
                preparedStatementA.setString(7, String.valueOf(allRegister.allRegisters.get(j).allComment.get(i).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }
        }
    }

}

class RequestMassageRepository {

    public static void loadRequestMassage(RegisterMenu allRegister, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM massagerequests");
        while (resultSet.next()) {
            int i;
            for (i = 0; i < allRegister.allRegisters.size(); i++) {
                if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                    if(resultSet.getString("1")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("1"));
                    }
                    else if(resultSet.getString("2")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("2"));
                    }
                    else if(resultSet.getString("3")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("3"));
                    }
                    else if(resultSet.getString("4")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("4"));
                    }
                    else if(resultSet.getString("5")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("5"));
                    }
                    else if(resultSet.getString("6")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("6"));
                    }
                    else if(resultSet.getString("7")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("7"));
                    }
                    else if(resultSet.getString("8")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("8"));
                    }
                    else if(resultSet.getString("9")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("9"));
                    }
                    else if(resultSet.getString("10")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("10"));
                    }
                    else if(resultSet.getString("11")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("11"));
                    }
                    else if(resultSet.getString("12")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("12"));
                    }
                    else if(resultSet.getString("13")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("13"));
                    }
                    else if(resultSet.getString("14")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("14"));
                    }
                    else if(resultSet.getString("15")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("15"));
                    }
                    else if(resultSet.getString("16")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("16"));
                    }
                    else if(resultSet.getString("17")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("17"));
                    }
                    else if(resultSet.getString("18")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("18"));
                    }
                    else if(resultSet.getString("19")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("19"));
                    }
                    else if(resultSet.getString("20")!=null) {
                        allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("20"));
                    }

                    break;
                }
            }


        }


        statement.close();
    }

    public static void insertRequestMassage(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM massagerequests");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO massagerequests(userId,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20) " +
                            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
            for(i=0 ; i<allRegister.allRegisters.get(j).massageRequests.size() ; i++){
                preparedStatementA.setString(22-allRegister.allRegisters.get(j).massageRequests.size()+i,allRegister.allRegisters.get(j).massageRequests.get(i));
            }
            preparedStatementA.executeUpdate();

        }
    }

}

class BussinessUserRepository {

    public static void loadBussinessUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM bussinesuser");
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
            BusinessUser myBussinesUser = new BusinessUser(user);
            myBussinesUser.userPhoneNumber = resultSet.getString("userPhonNumber");
            if(resultSet.getString("commercialGenre").equals("ARTS")){
                myBussinesUser.commercialGenre = ARTS;
            }
            else if(resultSet.getString("commercialGenre").equals("FASHION")){
                myBussinesUser.commercialGenre = FASHION;
            }
            else if(resultSet.getString("commercialGenre").equals("HEALTH_AND_CARE")){
                myBussinesUser.commercialGenre = HEALTH_AND_CARE;
            }
            else if(resultSet.getString("commercialGenre").equals("SCIENCE_AND_TECHNOLOGY")){
                myBussinesUser.commercialGenre = SCIENCE_AND_TECHNOLOGY;
            }
            else if(resultSet.getString("commercialGenre").equals("GAMING")){
                myBussinesUser.commercialGenre = GAMING;
            }
            else if(resultSet.getString("commercialGenre").equals("STOCK_MARKET")){
                myBussinesUser.commercialGenre = STOCK_MARKET;
            }
            allRegister.businessUsers.add(myBussinesUser) ;

        }

        statement.close();
    }

    public static void insertBussinessUsers(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM bussinesuser");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.businessUsers.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO bussinesuser(userType, userPassword, bio, name, userAccountType" +
                            " securityQuestion ,userId , gene_HEALTH_AND_CARE , gene_FASHION , gene_SCIENCE_AND_TECHNOLOGY , gene_STOCK_MARKET , gene_ARTS , gene_GAMING,userPhonNumber,commercialGenre) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setString(1, allRegister.businessUsers.get(j).userType);
            preparedStatementA.setString(2, allRegister.businessUsers.get(j).userPasswords);
            preparedStatementA.setString(3, allRegister.businessUsers.get(j).bio);
            preparedStatementA.setString(4, allRegister.businessUsers.get(j).name);
            preparedStatementA.setString(5, allRegister.businessUsers.get(j).userAccountType);
            preparedStatementA.setString(6, allRegister.businessUsers.get(j).securityQuestion);
            preparedStatementA.setString(7, allRegister.businessUsers.get(j).userID);
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(HEALTH_AND_CARE)) {
                    preparedStatementA.setInt(8, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(FASHION)) {
                    preparedStatementA.setInt(9, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(SCIENCE_AND_TECHNOLOGY)) {
                    preparedStatementA.setInt(10, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(STOCK_MARKET)) {
                    preparedStatementA.setInt(11, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers .get(j).favoriteGenres[i].equals(ARTS)) {
                    preparedStatementA.setInt(12, i);
                    break;
                }
            }
            for (i = 0; i < 6; i++) {
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(GAMING)) {
                    preparedStatementA.setInt(13, i);
                    break;
                }
            }
            preparedStatementA.setString(14,allRegister.businessUsers.get(j).userPhoneNumber);


            if(allRegister.businessUsers.get(j).commercialGenre.equals("ARTS")){
                preparedStatementA.setString(15,"ARTS");
            }
            else if(allRegister.businessUsers.get(j).commercialGenre.equals("FASHION")){
                preparedStatementA.setString(15,"FASHION");
            }
            else if(allRegister.businessUsers.get(j).commercialGenre.equals("HEALTH_AND_CARE")){
                preparedStatementA.setString(15,"HEALTH_AND_CARE");
            }
            else if(allRegister.businessUsers.get(j).commercialGenre.equals("SCIENCE_AND_TECHNOLOGY")){
                preparedStatementA.setString(15,"SCIENCE_AND_TECHNOLOGY");
            }
            else if(allRegister.businessUsers.get(j).commercialGenre.equals("GAMING")){
                preparedStatementA.setString(15,"GAMING");
            }
            else if(allRegister.businessUsers.get(j).commercialGenre.equals("STOCK_MARKET")){
                preparedStatementA.setString(15,"STOCK_MARKET");
            }

            preparedStatementA.executeUpdate();

        }
    }

}

/*class BussinessPostRepository {

    public static void loadBussinessPosts(RegisterMenu allRegister, Connection connection) throws SQLException {
        int index;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM bussinesspost");
        while (resultSet.next()) {
            int i;
            BusinessPost myPost = new BusinessPost();
            myPost.postID = resultSet.getString("postId");
            myPost.usersPostId = resultSet.getString("usersPostId");
            myPost.forwarded = resultSet.getString("forwarded");
            myPost.edited = resultSet.getString("edited");
            myPost.script = resultSet.getString("script");
            Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
            myPost.postDate = myDate;
            myPost.commercialPost=true ;
            for (index = 0; index < allRegister.allRegisters.size(); index++) {
                if (allRegister.allRegisters.get(index).userID.equals(myPost.usersPostId)) {
                    allRegister.allPosts.add(myPost);
                    break;
                }
            }

        }
        statement.close();
    }

    public static void insertBussinessPost(RegisterMenu allRegister, Connection connection) throws SQLException {
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

}*/

class likedBussinessPostRepository {

    public static void loadLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i , j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM likebussinesspost");
        while (resultSet.next()) {
            for(i=0 ; i<allRegister.allbussinessPost.size() ; i++){
                if(allRegister.allbussinessPost.get(i).postID.equals(resultSet.getString("postId"))){
                    for (j=0 ; j<allRegister.allRegisters.size() ; i++){
                        if(allRegister.allRegisters.get(j).userID.equals(resultSet.getString("userId"))){
                            LocalDate myDate ;
                            myDate = LocalDate.parse(resultSet.getString("likeDate")) ;
                            allRegister.allbussinessPost.get(i).liked.put(allRegister.allRegisters.get(j),myDate);
                            break;
                        }
                    }
                    break;
                }
            }

        }

        statement.close();
    }

    public static void insertLikedPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM likebussinesspost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allbussinessPost.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO likebussinesspost(usersId,postId,likeDate) " +
                            "VALUES(?, ?, ?)");
            for (Map.Entry<Person, LocalDate> personLocalDateEntry : allRegister.allbussinessPost.get(j).liked.entrySet()) {
                preparedStatementA.setString(1,personLocalDateEntry.getKey().userID);
                preparedStatementA.setString(2, allRegister.allbussinessPost.get(j).postID);
                preparedStatementA.setString(3,personLocalDateEntry.getValue().toString());
                preparedStatement.executeUpdate();
            }


        }
    }

}

class viewedBussinessPostRepository {

    public static void loadviewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i , j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM viewbussinesspost");
        while (resultSet.next()) {
            for(i=0 ; i<allRegister.allbussinessPost.size() ; i++){
                if(allRegister.allbussinessPost.get(i).postID.equals(resultSet.getString("postId"))){
                    for (j=0 ; j<allRegister.allRegisters.size() ; i++){
                        if(allRegister.allRegisters.get(j).userID.equals(resultSet.getString("userId"))){
                            LocalDate myDate ;
                            myDate = LocalDate.parse(resultSet.getString("viewDate")) ;
                            allRegister.allbussinessPost.get(i).viewed.put(allRegister.allRegisters.get(j),myDate);
                            break;
                        }
                    }
                    break;
                }
            }

        }

        statement.close();
    }

    public static void insertviewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM viewbussinesspost");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allbussinessPost.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO viewbussinesspost(usersId,postId,viewDate) " +
                            "VALUES(?, ?, ?)");
            for (Map.Entry<Person, LocalDate> personLocalDateEntry : allRegister.allbussinessPost.get(j).viewed.entrySet()) {
                preparedStatementA.setString(1,personLocalDateEntry.getKey().userID);
                preparedStatementA.setString(2, allRegister.allbussinessPost.get(j).postID);
                preparedStatementA.setString(3,personLocalDateEntry.getValue().toString());
                preparedStatement.executeUpdate();
            }


        }
    }

}

/*class chatRepository{

    public static void loadChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i , j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM chat");
        while (resultSet.next()) {
            Chat myChat = new Chat();
            for(i=0 ; i<allRegister.allRegisters.size() ; i++){
                if(allRegister.allRegisters.get(i).userID.equals(resultSet.getString("person1"))){
                    myChat.person1=allRegister.allRegisters.get(i);
                    break;
                }
            }
            for(j=0 ; j<allRegister.allRegisters.size() ; j++){
                if(allRegister.allRegisters.get(j).userID.equals(resultSet.getString("person2"))){
                    myChat.person2=allRegister.allRegisters.get(j);
                    break;
                }
            }
            myChat.blockState=resultSet.getString("blockState");
            allRegister.allRegisters.get(i).allPersonalChats.add(myChat) ;
            allRegister.allRegisters.get(j).allPersonalChats.add(myChat) ;

        }
        statement.close();
    }

    public static void insertChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM chat");
        preparedStatement.executeUpdate();
        PreparedStatement preparedStatementA = connection.prepareStatement(
                "INSERT INTO chat(person1,person2,blockState) " +
                        "VALUES(?, ?, ?)");
        for(i=0 ; i<allRegister.allRegisters.size() ; i++)
        preparedStatementA.setString(1,personLocalDateEntry.getKey().userID);
        preparedStatementA.setString(2, allRegister.allbussinessPost.get(j).postID);
        preparedStatementA.setString(3,personLocalDateEntry.getValue().toString());
        preparedStatement.executeUpdate();
    }

}*/






