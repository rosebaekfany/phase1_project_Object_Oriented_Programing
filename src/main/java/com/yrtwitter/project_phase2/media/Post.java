package com.yrtwitter.project_phase2.media;

import java.util.*;

import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.temporary.*;
import com.yrtwitter.project_phase2.view.*;
import com.yrtwitter.project_phase2.controller.*;
import javafx.scene.image.Image;


public class Post {
    public String script = new String();

    //public Image postImage ;
    public boolean commercialPost = false;
    public Media media = new Media();
    public String imagePath = new String();
    public String postID = new String();
    public String usersPostId = new String();
    public ArrayList<Person> likedUsers = new ArrayList<>();
    public ArrayList<Person> viewedUsers = new ArrayList<>();
    public ArrayList<Comment> postComments = new ArrayList<>();
    public Date postDate = new Date();
    public String edited = new String("");
    public String forwarded = new String("");

    void putMedia() {

    }

    public ArrayList<Person> getUnlikedUsers() {
        ArrayList<Person> unlikedUsers = new ArrayList<>();
        for (Person viewedUser : viewedUsers) {
            if (!likedUsers.contains(viewedUser)) {
                unlikedUsers.add(viewedUser);
            }
        }
        return unlikedUsers;
    }

    public static void writePost(RegisterMenu myRegister, String text,String imageName) {
        Post newPost = new Post();
        //Image postImage= new Image(Post.class.getResourceAsStream("/images/"+imageName));
        newPost.imagePath=imageName;
        newPost.script = text;
        Date postDate = new Date();
        newPost.postDate = Calendar.getInstance().getTime();
        newPost.postID = "@" + String.valueOf(myRegister.allRegisters.get(myRegister.logedInAccount).posts.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "*****";
        newPost.usersPostId = myRegister.allRegisters.get(myRegister.logedInAccount).userID;
        myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.add(newPost);
    }

    public static void writePost(RegisterMenu myRegister, String text , Image image){

    }

    public static void post(RegisterMenu myRegister) {
        int i ;
        myRegister.allRegisters.get(myRegister.logedInAccount).posts.add(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1));
        if(myRegister.allRegisters.get(myRegister.logedInAccount).userAccountType.equals("Business_Account")){
            myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).commercialPost=true;
            BusinessPost myBussinessPost = new BusinessPost();
            myBussinessPost.usersPostId=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).usersPostId;
            myBussinessPost.postDate=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).postDate;
            myBussinessPost.postID=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).postID;
            myBussinessPost.postComments=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).postComments;
            myBussinessPost.forwarded=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).forwarded;
            myBussinessPost.edited=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).edited;
            myBussinessPost.script=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).script;
            myBussinessPost.commercialPost=true;
            myBussinessPost.likedUsers=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).likedUsers;
            myBussinessPost.viewedUsers=myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).viewedUsers;
            myRegister.allbussinessPost.add(myBussinessPost);
        }
        myRegister.allPosts.add(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1)) ;
        myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.remove(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1) ;

    }

    public static void editPost(Post myPost, String myString) {
        myPost.script = myString;
        myPost.edited = "edited";
    }

    public static void likePost(Person myPerson, Post myPost) {
        int i;
        myPost.likedUsers.add(myPerson);
        myPerson.likedPhotoes.add(myPost);
    }

    public static void commentPost(Person myPerson, Post myPost, String newString) {
        Comment newComment = new Comment();
        newComment.script = newString;
        Date postDate = new Date();
        newComment.postDate = Calendar.getInstance().getTime();
        newComment.postID = "@" + String.valueOf(myPerson.allComment.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "***";
        newComment.usersPostId = myPerson.userID;
        newComment.postOfTheComment = myPost;

        myPost.postComments.add(newComment);
        myPerson.allComment.add(newComment);
    }

}