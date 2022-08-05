
package com.yrtwitter.project_phase2.controller;

import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.temporary.*;
import com.yrtwitter.project_phase2.view.*;
import com.yrtwitter.project_phase2.controller.*;

import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.*;
import java.util.*;
import java.util.Date;

import static com.yrtwitter.project_phase2.temporary.CommercialGenres.*;


public class DatabaseUpdate {
    public static void loadAll(RegisterMenu allRegister, Connection conn) throws SQLException {
        UserRepository.loadUsers(allRegister, conn);
        PostRepository.loadPosts(allRegister, conn);
        likedPostRepository.loadLikedPost(allRegister, conn);
        draftPostRepository.loadDraftPost(allRegister, conn);
        viewPostRepository.loadViewPost(allRegister, conn);
        followRepository.loadfollows(allRegister, conn);
        CommentRepository.loadPosts(allRegister, conn);
        RequestMassageRepository.loadRequestMassage(allRegister, conn);
        BussinessUserRepository.loadBussinessUsers(allRegister, conn);
        likedBussinessPostRepository.loadLikedPost(allRegister, conn);
        viewedBussinessPostRepository.loadviewPost(allRegister, conn);
        chatRepository.loadChat(allRegister, conn);
        groupRepasitory.loadGroup(allRegister, conn);
        chatMassageReasitory.loadMassageChat(allRegister, conn);
        groupMassageReasitory.loadMassageGroup(allRegister, conn);

    }

    public static void insertAll(RegisterMenu allRegister, Connection conn) throws SQLException {
        UserRepository.insertUsers(allRegister, conn);
        PostRepository.insertPost(allRegister, conn);
        ;
        likedPostRepository.insertLikedPost(allRegister, conn);
        draftPostRepository.insertDraftPost(allRegister, conn);
        viewPostRepository.insertViewPost(allRegister, conn);
        followRepository.insertfollows(allRegister, conn);
        CommentRepository.insertPost(allRegister, conn);
        RequestMassageRepository.insertRequestMassage(allRegister, conn);
        BussinessUserRepository.insertBussinessUsers(allRegister, conn);
        likedBussinessPostRepository.insertLikedPost(allRegister, conn);
        viewedBussinessPostRepository.insertviewPost(allRegister, conn);
        chatRepository.insertChat(allRegister, conn);
        groupRepasitory.insertGroup(allRegister, conn);
        chatMassageReasitory.insertNassageChat(allRegister, conn);
        groupMassageReasitory.insertMassageGroup(allRegister, conn);
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
            if (resultSet.getString("userId").equals("1")) {
            } else {
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
                    "INSERT INTO allregister(userType, userPassword, bio, name, userAccountType , securityQuestion ,userId , gene_HEALTH_AND_CARE , gene_FASHION , gene_SCIENCE_AND_TECHNOLOGY , gene_STOCK_MARKET , gene_ARTS , gene_GAMING) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

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
            if (resultSet.getString("postId").equals("1")) {
            } else {
                int i;
                Post myPost = new Post();
                myPost.postID = resultSet.getString("postId");
                myPost.usersPostId = resultSet.getString("usersPostId");
                myPost.forwarded = resultSet.getString("forwarded");
                myPost.edited = resultSet.getString("edited");
                myPost.script = resultSet.getString("script");
                Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
                myPost.postDate = myDate;
                if (resultSet.getInt("BorG") == 0) {
                    myPost.commercialPost = false;
                } else if (resultSet.getInt("BorG") == 1) {
                    myPost.commercialPost = true;
                }
                for (index = 0; index < allRegister.allRegisters.size(); index++) {
                    if (allRegister.allRegisters.get(index).userID.equals(myPost.usersPostId)) {
                        allRegister.allRegisters.get(index).posts.add(myPost);
                        allRegister.allPosts.add(myPost);
                        break;
                    }
                }
                if (myPost.commercialPost) {
                    BusinessPost myBussinessPost = new BusinessPost();
                    myBussinessPost.commercialPost = true;
                    myBussinessPost.postID = myPost.postID;
                    myBussinessPost.usersPostId = myPost.usersPostId;
                    myBussinessPost.postDate = myPost.postDate;
                    myBussinessPost.script = myPost.postID;
                    myBussinessPost.edited = myPost.edited;
                    myBussinessPost.forwarded = myPost.forwarded;
                    allRegister.allbussinessPost.add(myBussinessPost);
                }
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
                if (allRegister.allRegisters.get(j).posts.get(i).commercialPost) {
                    preparedStatementA.setInt(7, 1);
                } else {
                    preparedStatementA.setInt(7, 0);
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
            if (resultSet.getString("id").equals("1")) {
            } else {
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
                    "INSERT INTO likephoto(userId,postId,id) " +
                            "VALUES(?, ?, ?)");
            for (i = 0; i < allRegister.allRegisters.get(j).likedPhotoes.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).likedPhotoes.get(i).postID);
                preparedStatementA.setString(3,String.valueOf(Calendar.getInstance().getTime().getTime()));
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
            if (resultSet.getString("postId").equals("1")) {
            } else {
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
            if (resultSet.getString("id").equals("1")) {
            } else {
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
                    "INSERT INTO viewpost(userId,postId,id) " +
                            "VALUES(?,?,?)");
            for (i = 0; i < allRegister.allRegisters.get(j).viewedPosts.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).viewedPosts.get(i).postID);
                preparedStatementA.setString(3,String.valueOf(Calendar.getInstance().getTime().getTime()));

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
            if (resultSet.getString("id").equals("1")) {
            } else {
                int i, j;
                for (i = 0; i < allRegister.allRegisters.size(); i++) {
                    if (resultSet.getString("folloewerId").equals(allRegister.allRegisters.get(i).userID)) {
                        for (j = 0; j < allRegister.allRegisters.size(); j++) {
                            if (resultSet.getString("followedId").equals(allRegister.allRegisters.get(j).userID)) {
                                allRegister.allRegisters.get(i).folowings.add(allRegister.allRegisters.get(j));
                                allRegister.allRegisters.get(j).folowers.add(allRegister.allRegisters.get(i));
                                break;
                            }
                        }
                        break;
                    }
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
                    "INSERT INTO follower(folloewerId, followedId,id) " +
                            "VALUES(?, ?, ?)");
            for (i = 0; i < allRegister.allRegisters.get(j).folowings.size(); i++) {
                preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
                preparedStatementA.setString(2, allRegister.allRegisters.get(j).folowings.get(i).userID);
                preparedStatementA.setString(3, String.valueOf(Calendar.getInstance().getTime().getTime()));

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
            if (resultSet.getString("postId").equals("1")) {
            } else {
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
            if (resultSet.getString("userId").equals("1")) {
            } else {
                int i;
                for (i = 0; i < allRegister.allRegisters.size(); i++) {
                    if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("userId"))) {
                        if (resultSet.getString("one").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("one"));
                        }
                        if (resultSet.getString("two").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("two"));
                        }
                        if (resultSet.getString("three").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("three"));
                        }
                        if (resultSet.getString("four").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("four"));
                        }
                        if (resultSet.getString("five").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("five"));
                        }
                        if (resultSet.getString("six").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("six"));
                        }
                        if (resultSet.getString("seven").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("seven"));
                        }
                        if (resultSet.getString("eight").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("eight"));
                        }
                        if (resultSet.getString("nine").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("nine"));
                        }
                        if (resultSet.getString("ten").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("ten"));
                        }
                        if (resultSet.getString("eleven").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("eleven"));
                        }
                        if (resultSet.getString("twelve").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("twelve"));
                        }
                        if (resultSet.getString("thirteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("thirteen"));
                        }
                        if (resultSet.getString("fourteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("fourteen"));
                        }
                        if (resultSet.getString("fifteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("fifteen"));
                        }
                        if (resultSet.getString("sixteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("sixteen"));
                        }
                        if (resultSet.getString("seventeen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("seventeen"));
                        }
                        if (resultSet.getString("eightteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("eightteen"));
                        }
                        if (resultSet.getString("nineteen").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("nineteen"));
                        }
                        if (resultSet.getString("twenty").equals(" ")) {
                        } else {
                            allRegister.allRegisters.get(i).massageRequests.add(resultSet.getString("twenty"));
                        }

                        break;
                    }
                }
            }

        }


        statement.close();
    }

    public static void insertRequestMassage(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i = 0, j, h;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM massagerequests");
        preparedStatement.executeUpdate();
        for (j = 0; j < allRegister.allRegisters.size(); j++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO massagerequests(userId,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eightteen,nineteen,twenty) " +
                            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatementA.setString(1, allRegister.allRegisters.get(j).userID);
            for (i = 0; i < allRegister.allRegisters.get(j).massageRequests.size(); i++) {
                preparedStatementA.setString(22 - allRegister.allRegisters.get(j).massageRequests.size() + i, allRegister.allRegisters.get(j).massageRequests.get(i));
            }
            if (i < 20) {
                for (h = 2; h < 22 - i; h++)
                    preparedStatementA.setString(h, " ");
                /*preparedStatementA.setString(3," ");
                preparedStatementA.setString(4," ");
                preparedStatementA.setString(5," ");
                preparedStatementA.setString(6," ");
                preparedStatementA.setString(7," ");
                preparedStatementA.setString(8," ");
                preparedStatementA.setString(9," ");
                preparedStatementA.setString(10," ");
                preparedStatementA.setString(11," ");
                preparedStatementA.setString(12," ");
                preparedStatementA.setString(13," ");
                preparedStatementA.setString(14," ");
                preparedStatementA.setString(15," ");
                preparedStatementA.setString(16," ");
                preparedStatementA.setString(17," ");
                preparedStatementA.setString(18," ");
                preparedStatementA.setString(19," ");
                preparedStatementA.setString(20," ");
                preparedStatementA.setString(21," ");*/


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
            if (resultSet.getString("userId").equals("1")) {
            } else {
                int i;
                Person user = new Person();
                user.userID = (resultSet.getString("userId"));
                user.userType = (resultSet.getString("userType"));
                user.securityQuestion = (resultSet.getString("securityQuestion"));
                user.name = (resultSet.getString("name"));
                user.userAccountType = "Business_Account";
                user.bio = (resultSet.getString("bio"));
                user.userPasswords = (resultSet.getString("userPassword"));
                /*for (i = 0; i < 6; i++) {
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

                }*/
                BusinessUser myBussinesUser = new BusinessUser(user);
                myBussinesUser.userPhoneNumber = resultSet.getString("userPhonNumber");
                if (resultSet.getString("commercialGenre").equals("ARTS")) {
                    myBussinesUser.commercialGenre = ARTS;
                } else if (resultSet.getString("commercialGenre").equals("FASHION")) {
                    myBussinesUser.commercialGenre = FASHION;
                } else if (resultSet.getString("commercialGenre").equals("HEALTH_AND_CARE")) {
                    myBussinesUser.commercialGenre = HEALTH_AND_CARE;
                } else if (resultSet.getString("commercialGenre").equals("SCIENCE_AND_TECHNOLOGY")) {
                    myBussinesUser.commercialGenre = SCIENCE_AND_TECHNOLOGY;
                } else if (resultSet.getString("commercialGenre").equals("GAMING")) {
                    myBussinesUser.commercialGenre = GAMING;
                } else if (resultSet.getString("commercialGenre").equals("STOCK_MARKET")) {
                    myBussinesUser.commercialGenre = STOCK_MARKET;
                }
                allRegister.businessUsers.add(myBussinesUser);
            }
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
                    "INSERT INTO bussinesuser(userType, userPassword, bio, name, userAccountType , securityQuestion ,userId , gene_HEALTH_AND_CARE , gene_FASHION , gene_SCIENCE_AND_TECHNOLOGY , gene_STOCK_MARKET , gene_ARTS , gene_GAMING,userPhonNumber,commercialGenre) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
                if (allRegister.businessUsers.get(j).favoriteGenres[i].equals(ARTS)) {
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
            preparedStatementA.setString(14, allRegister.businessUsers.get(j).userPhoneNumber);


            if (allRegister.businessUsers.get(j).commercialGenre.equals(ARTS)) {
                preparedStatementA.setString(15, "ARTS");
            } else if (allRegister.businessUsers.get(j).commercialGenre.equals(FASHION)) {
                preparedStatementA.setString(15, "FASHION");
            } else if (allRegister.businessUsers.get(j).commercialGenre.equals(HEALTH_AND_CARE)) {
                preparedStatementA.setString(15, "HEALTH_AND_CARE");
            } else if (allRegister.businessUsers.get(j).commercialGenre.equals(SCIENCE_AND_TECHNOLOGY)) {
                preparedStatementA.setString(15, "SCIENCE_AND_TECHNOLOGY");
            } else if (allRegister.businessUsers.get(j).commercialGenre.equals(GAMING)) {
                preparedStatementA.setString(15, "GAMING");
            } else if (allRegister.businessUsers.get(j).commercialGenre.equals(STOCK_MARKET)) {
                preparedStatementA.setString(15, "STOCK_MARKET");
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
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM likebussinesspost");
        while (resultSet.next()) {
            if (resultSet.getString("id").equals("1")) {
            } else {
                for (i = 0; i < allRegister.allbussinessPost.size(); i++) {
                    if (allRegister.allbussinessPost.get(i).postID.equals(resultSet.getString("postId"))) {
                        for (j = 0; j < allRegister.allRegisters.size(); j++) {
                            if (allRegister.allRegisters.get(j).userID.equals(resultSet.getString("userId"))) {
                                LocalDate myDate;
                                myDate = LocalDate.parse(resultSet.getString("likeDate"));
                                allRegister.allbussinessPost.get(i).liked.put(allRegister.allRegisters.get(j), myDate);
                                break;
                            }
                        }
                        break;
                    }
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
                    "INSERT INTO likebussinesspost(userId,postId,likeDate,id) " +
                            "VALUES(?, ?, ?,?)");
            for (Map.Entry<Person, LocalDate> personLocalDateEntry : allRegister.allbussinessPost.get(j).liked.entrySet()) {
                preparedStatementA.setString(1, personLocalDateEntry.getKey().userID);
                preparedStatementA.setString(2, allRegister.allbussinessPost.get(j).postID);
                preparedStatementA.setString(3, personLocalDateEntry.getValue().toString());
                preparedStatementA.setString(4,String.valueOf(Calendar.getInstance().getTime().getTime()));
                preparedStatementA.executeUpdate();
            }


        }
    }

}

class viewedBussinessPostRepository {

    public static void loadviewPost(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM viewbussinesspost");
        while (resultSet.next()) {
            if (resultSet.getString("id").equals("1")) {
            } else {
                for (i = 0; i < allRegister.allbussinessPost.size(); i++) {
                    if (allRegister.allbussinessPost.get(i).postID.equals(resultSet.getString("postId"))) {
                        for (j = 0; j < allRegister.allRegisters.size(); j++) {
                            if (allRegister.allRegisters.get(j).userID.equals(resultSet.getString("userId"))) {
                                LocalDate myDate;
                                myDate = LocalDate.parse(resultSet.getString("viewDate"));
                                allRegister.allbussinessPost.get(i).viewed.put(allRegister.allRegisters.get(j), myDate);
                                break;
                            }
                        }
                        break;
                    }
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
                    "INSERT INTO viewbussinesspost(userId,postId,viewDate,id) " +
                            "VALUES(?, ?, ?,?)");
            for (Map.Entry<Person, LocalDate> personLocalDateEntry : allRegister.allbussinessPost.get(j).viewed.entrySet()) {
                preparedStatementA.setString(1, personLocalDateEntry.getKey().userID);
                preparedStatementA.setString(2, allRegister.allbussinessPost.get(j).postID);
                preparedStatementA.setString(3, personLocalDateEntry.getValue().toString());
                preparedStatementA.setString(4,String.valueOf(Calendar.getInstance().getTime().getTime()));
                preparedStatementA.executeUpdate();
            }


        }
    }

}

class chatRepository {

    public static void loadChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM chat");
        while (resultSet.next()) {
            if (resultSet.getString("chatId").equals("1")) {
            } else {
                Chat myChat = new Chat();
                for (i = 0; i < allRegister.allRegisters.size(); i++) {
                    if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("person1"))) {
                        myChat.person1 = allRegister.allRegisters.get(i);
                        break;
                    }
                }
                for (j = 0; j < allRegister.allRegisters.size(); j++) {
                    if (allRegister.allRegisters.get(j).userID.equals(resultSet.getString("person2"))) {
                        myChat.person2 = allRegister.allRegisters.get(j);
                        break;
                    }
                }
                myChat.blockState = resultSet.getString("blockState");
                myChat.chatId = resultSet.getString("chatId");
                allRegister.allRegisters.get(i).allPersonalChats.add(myChat);
                allRegister.allRegisters.get(j).allPersonalChats.add(myChat);
                allRegister.allRegistersPersonalChats.add(myChat);
            }
        }
        statement.close();
    }

    public static void insertChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM chat");
        preparedStatement.executeUpdate();
        for (i = 0; i < allRegister.allRegistersPersonalChats.size(); i++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO chat(person1,person2,blockState,chatId) " +
                            "VALUES(?, ?, ?,?)");
            preparedStatementA.setString(1, allRegister.allRegistersPersonalChats.get(i).person1.userID);
            preparedStatementA.setString(2, allRegister.allRegistersPersonalChats.get(i).person2.userID);
            preparedStatementA.setString(3, allRegister.allRegistersPersonalChats.get(i).blockState);
            preparedStatementA.setString(4, allRegister.allRegistersPersonalChats.get(i).chatId);

            preparedStatementA.executeUpdate();
        }

    }

}

class groupRepasitory {

    public static void loadGroup(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM groupp");
        while (resultSet.next()) {
            if (resultSet.getString("groupId").equals("1")) {
            } else {
                Group myGroup = new Group();
                myGroup.groupId = resultSet.getString("groupId");
                myGroup.groupId = resultSet.getString("admin");
                myGroup.groupName = resultSet.getString("groupName");
                if (resultSet.getString("1u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("1u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("2u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("2u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("3u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("3u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("4u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("4u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("5u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("5u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("6u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("6u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("7u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("7u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("8u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("8u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("9u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("9u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("10u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("10u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("11u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("11u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("12u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("12u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("13u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("13u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("14u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("14u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("15u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("15u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("16u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("16u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("17u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("17u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("18u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("18u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("19u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("19u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("20u").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("20u"))) {
                            myGroup.groupUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }

                if (resultSet.getString("1b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("1b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("2b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("2b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("3b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("3b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("4b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("4b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("5b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("5b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("6b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("6b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("7b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("7b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("8b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("8b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("9b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("9b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                if (resultSet.getString("10b").equals(" ")) {
                } else {
                    for (i = 0; i < allRegister.allRegisters.size(); i++) {
                        if (allRegister.allRegisters.get(i).userID.equals(resultSet.getString("10b"))) {
                            myGroup.bannedUsers.add(allRegister.allRegisters.get(i));
                            break;
                        }
                    }
                }
                allRegister.allRegisterGroup.add(myGroup);
            }
        }
        statement.close();
    }

    public static void insertGroup(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j, h;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM groupp");
        preparedStatement.executeUpdate();
        for (i = 0; i < allRegister.allRegisterGroup.size(); i++) {
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO groupp(groupName,admin,groupId,1u,2u,3u,4u,5u,6u,7u,8u,9u,10u,11u,12u,13u,14u,15u,16u,17u,18u,19u,20u,1b,2b,3b,4b,5b,6b,7b,8b,9b,10b) " +
                            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatementA.setString(1, allRegister.allRegisterGroup.get(i).groupName);
            preparedStatementA.setString(2, allRegister.allRegisterGroup.get(i).admin.userID);
            preparedStatementA.setString(3, allRegister.allRegisterGroup.get(i).groupId);
            for (j = 0; j < allRegister.allRegisterGroup.get(i).groupUsers.size(); j++) {
                preparedStatementA.setString(4 + j, allRegister.allRegisterGroup.get(i).groupUsers.get(j).userID);
            }
            if (j < 20) {
                for (h = j + 4; h < 24; h++) {
                    preparedStatementA.setString(h, " ");
                }
            }
            for (j = 0; j < allRegister.allRegisterGroup.get(i).bannedUsers.size(); j++) {
                preparedStatementA.setString(23 + j, allRegister.allRegisterGroup.get(i).bannedUsers.get(j).userID);
            }
            if (j < 10) {
                for (h = j + 23; h < 34; h++) {
                    preparedStatementA.setString(h, " ");
                }
            }
            preparedStatementA.executeUpdate();
        }
    }

}

class chatMassageReasitory {

    public static void loadMassageChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM allpersonalchat");
        while (resultSet.next()) {
            if (resultSet.getString("chatId").equals("1")) {
            } else {
                Comment myPost = new Comment();
                myPost.postID = resultSet.getString("postId");
                myPost.usersPostId = resultSet.getString("usersPostId");
                myPost.forwarded = resultSet.getString("forwarded");
                myPost.edited = resultSet.getString("edited");
                myPost.script = resultSet.getString("script");
                Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
                myPost.postDate = myDate;
                if (resultSet.getInt("BorG") == 0) {
                    myPost.commercialPost = false;
                } else if (resultSet.getInt("BorG") == 1) {
                    myPost.commercialPost = true;
                }

                for (i = 0; i < allRegister.allRegistersPersonalChats.size(); i++) {
                    if (allRegister.allRegistersPersonalChats.get(i).person1.userID.equals(resultSet.getString("person1"))) {
                        for (j = 0; j < allRegister.allRegistersPersonalChats.get(i).allTexts.size(); j++) {
                            if (allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).postID.equals(resultSet.getString("postOfComment"))) {
                                myPost.postOfTheComment = allRegister.allRegistersPersonalChats.get(i).allTexts.get(j);

                                break;
                            }
                        }
                        break;
                    }
                }

                for (i = 0; i < allRegister.allRegistersPersonalChats.size(); i++) {
                    if (allRegister.allRegistersPersonalChats.get(i).person1.userID.equals(resultSet.getString("person1")) && allRegister.allRegistersPersonalChats.get(i).person2.userID.equals(resultSet.getString("person2"))) {
                        allRegister.allRegistersPersonalChats.get(i).allTexts.add(myPost);
                        if (myPost.usersPostId.equals(allRegister.allRegistersPersonalChats.get(i).person1.userID)) {
                            allRegister.allRegistersPersonalChats.get(i).person1Texts.add(myPost);
                            break;
                        } else if (myPost.usersPostId.equals(allRegister.allRegistersPersonalChats.get(i).person2.userID)) {
                            allRegister.allRegistersPersonalChats.get(i).person2Texts.add(myPost);
                            break;
                        }
                        break;
                    }
                }
            }

        }
        statement.close();
    }

    public static void insertNassageChat(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j, h, ff = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM allpersonalchat");
        preparedStatement.executeUpdate();
        for (i = 0; i < allRegister.allRegistersPersonalChats.size(); i++) {
            for (j = 0; j < allRegister.allRegistersPersonalChats.get(i).allTexts.size(); j++) {
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO allpersonalchat(person1,person2,postId,usersPostId,forwarded,edited,script,postOfComment,postDate,chatId) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatementA.setString(1, allRegister.allRegistersPersonalChats.get(i).person1.userID);
                preparedStatementA.setString(2, allRegister.allRegistersPersonalChats.get(i).person2.userID);
                preparedStatementA.setString(3, allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).postID);
                preparedStatementA.setString(4, allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).usersPostId);
                preparedStatementA.setString(5, allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).forwarded);
                preparedStatementA.setString(6, allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).edited);
                preparedStatementA.setString(7, allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).script);
                for (h = 0; h < allRegister.allRegistersPersonalChats.get(i).allReply.size(); h++) {
                    if (allRegister.allRegistersPersonalChats.get(i).allReply.get(h).postID.equals(allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).postID)) {
                        preparedStatementA.setString(8, allRegister.allRegistersPersonalChats.get(i).allReply.get(h).postOfTheComment.postID);
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    preparedStatementA.setString(8, " ");
                }
                preparedStatementA.setString(9, String.valueOf(allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).postDate.getTime()));
                preparedStatementA.setString(10, allRegister.allRegistersPersonalChats.get(i).chatId);

                preparedStatementA.executeUpdate();
            }

        }
    }

}

class groupMassageReasitory {

    public static void loadMassageGroup(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM allgroups");
        while (resultSet.next()) {
            if (resultSet.getString("groupId").equals("1")) {
            } else {
                Comment myPost = new Comment();
                myPost.postID = resultSet.getString("postId");
                myPost.usersPostId = resultSet.getString("usersPostId");
                myPost.forwarded = resultSet.getString("forwarded");
                myPost.edited = resultSet.getString("edited");
                myPost.script = resultSet.getString("script");
                Date myDate = new Date(Long.parseLong(resultSet.getString("postDate")));
                myPost.postDate = myDate;
                if (resultSet.getInt("BorG") == 0) {
                    myPost.commercialPost = false;
                } else if (resultSet.getInt("BorG") == 1) {
                    myPost.commercialPost = true;
                }

                for (i = 0; i < allRegister.allRegisterGroup.size(); i++) {
                    if (allRegister.allRegisterGroup.get(i).groupId.equals(resultSet.getString("groupId"))) {
                        for (j = 0; j < allRegister.allRegisterGroup.get(i).allTexts.size(); j++) {
                            if (allRegister.allRegisterGroup.get(i).allTexts.get(j).postID.equals(resultSet.getString("postOfComment"))) {
                                myPost.postOfTheComment = allRegister.allRegisterGroup.get(i).allTexts.get(j);
                                break;
                            }
                        }
                        break;
                    }
                }

                for (i = 0; i < allRegister.allRegisterGroup.size(); i++) {
                    if (allRegister.allRegisterGroup.get(i).groupId.equals(resultSet.getString("groupId"))) {
                        allRegister.allRegisterGroup.get(i).allTexts.add(myPost);
                        break;
                    }
                }
            }
        }
        statement.close();
    }

    public static void insertMassageGroup(RegisterMenu allRegister, Connection connection) throws SQLException {
        int i, j, h, ff = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM allgroups");
        preparedStatement.executeUpdate();

        for (i = 0; i < allRegister.allRegisterGroup.size(); i++) {
            for (j = 0; j < allRegister.allRegisterGroup.get(i).allTexts.size(); j++) {
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO allgroups(groupId,postId,usersPostId,forwarded,edited,script,postIdOfComment,postDate) " +
                                "VALUES( ?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatementA.setString(1, allRegister.allRegisterGroup.get(i).groupId);
                preparedStatementA.setString(2, allRegister.allRegisterGroup.get(i).allTexts.get(j).postID);
                preparedStatementA.setString(3, allRegister.allRegisterGroup.get(i).allTexts.get(j).usersPostId);
                preparedStatementA.setString(4, allRegister.allRegisterGroup.get(i).allTexts.get(j).forwarded);
                preparedStatementA.setString(5, allRegister.allRegisterGroup.get(i).allTexts.get(j).edited);
                preparedStatementA.setString(6, allRegister.allRegisterGroup.get(i).allTexts.get(j).script);
                for (h = 0; h < allRegister.allRegisterGroup.get(i).allReply.size(); h++) {
                    if (allRegister.allRegisterGroup.get(i).allReply.get(h).postID.equals(allRegister.allRegistersPersonalChats.get(i).allTexts.get(j).postID)) {
                        preparedStatementA.setString(7, allRegister.allRegisterGroup.get(i).allReply.get(h).postOfTheComment.postID);
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    preparedStatementA.setString(7, " ");
                }
                preparedStatementA.setString(8, String.valueOf(allRegister.allRegisterGroup.get(i).allTexts.get(j).postDate.getTime()));
                preparedStatementA.executeUpdate();
            }

        }
    }

}





