package controller;

import view.*;
import media.*;

import java.util.ArrayList;
import java.util.Calendar;

public class Communication {

    public static void followSb(RegisterMenu myRegester, Person myPerson, String id) {
        int i, flag = 0;
        for (i = 0; i < myRegester.allRegisters.size(); i++) {
            if (myRegester.allRegisters.get(i).userID.equals(id)) {
                if (myRegester.allRegisters.get(i).userType.equals("private")) {
                    myRegester.allRegisters.get(i).massageRequests.add(myPerson.userID + " wants to follow you!");
                    System.out.println("you have requested " + id + " to follow you");
                } else {
                    myRegester.allRegisters.get(i).folowers.add(myPerson);
                    myPerson.folowings.add(myRegester.allRegisters.get(i));
                    System.out.println(id + " is now added to your followings");
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void unfollowSb(RegisterMenu myRegester, Person myPerson, String id) {
        int i, j, h, flag = 0;
        for (i = 0; i < myRegester.allRegisters.size(); i++) {
            if (myRegester.allRegisters.get(i).userID.equals(id)) {
                for (j = 0; j < myRegester.allRegisters.get(i).folowers.size(); j++) {
                    if (myRegester.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)) {
                        myRegester.allRegisters.get(i).folowers.remove(j);
                        for (h = 0; h < myPerson.folowings.size(); h++) {
                            if (myPerson.folowings.get(h).equals(myRegester.allRegisters.get(i).userID)) {
                                myPerson.folowings.remove(h);
                                System.out.println("you no longer follow " + myRegester.allRegisters.get(i).userID);
                                break;
                            }
                        }
                        break;
                    }
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void removeFollower(RegisterMenu myRegester, Person myPerson, String id) {
        int i, flag = 0;
        for (i = 0; i < myPerson.folowers.size(); i++) {
            if (myPerson.folowers.get(i).userID.equals(id)) {
                System.out.println(id + " is removed from your folowers");
                myPerson.folowers.remove(i);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    //personal chat
    public static void StartNewChat(RegisterMenu myRegister, Person myPerson1, Person myPerson2) {
        Chat newChat = new Chat();
        newChat.person1 = myPerson1;
        newChat.person2 = myPerson2;
        myPerson1.allPersonalChats.add(newChat);
        myPerson2.allPersonalChats.add(newChat);
        myRegister.chatOnBord = newChat;

    }

    public static void countinueChatting(RegisterMenu myRegister, Chat myChat) {
        myRegister.chatOnBord = myChat;
    }

    public static void DMing(Chat myChat, Person myPerson, String newText) {

        Post newDm = new Post();
        newDm.postDate = Calendar.getInstance().getTime();
        newDm.script = newText;
        newDm.usersPostId = myPerson.userID;
        newDm.postID = "@" + String.valueOf(myChat.allTexts.size()) + "*-*";
        myChat.allTexts.add(newDm);
        if (myPerson.userID.equals(myChat.person1.userID)) {
            myChat.person1Texts.add(newDm);
        } else if (myPerson.userID.equals(myChat.person2.userID)) {
            myChat.person2Texts.add(newDm);
        }

    }

    public static void editDmInChat(Chat myChat, Post myDm, String newText) {
        int num, i, ff = 0;
        myDm.script = newText;
        myDm.edited = "edited";
        for (i = 0; i < myChat.allTexts.size(); i++) {
            if (myChat.allTexts.get(i).postID.equals(myDm.postID)) {
                myChat.allTexts.get(i).script = newText;
                myChat.allTexts.get(i).edited = "edited";
                break;
            }
        }
    }

    public static void deleteDmChat(Chat myChat, Post myDm) {
        int i;
        for (i = 0; i < myChat.allTexts.size(); i++) {
            if (myChat.allTexts.get(i).postID.equals(myDm.postID)) {
                myChat.allTexts.remove(i);
            }
        }
    }

    public static void likeDm(Chat myChat, Post myDm, Person myPerson) {
        int i;
        myDm.likedUsers.add(myPerson);
        for (i = 0; i < myChat.allTexts.size(); i++) {
            if (myChat.allTexts.get(i).postID.equals(myDm.postID)) {
                myChat.allTexts.get(i).likedUsers.add(myPerson);
            }
        }
    }

    public static void replyChat(Chat myChat, Post myPost, Person myPerson, String newText) {
        Comment newReply = new Comment();
        newReply.script = newText;
        newReply.postDate = Calendar.getInstance().getTime();
        newReply.postOfTheComment = myPost;
        newReply.postID = "@" + String.valueOf(myPost.postComments.size()) + "**-**";
        newReply.usersPostId = myPerson.userID;
        myChat.allTexts.add(newReply);
        myChat.allReply.add(newReply);
        if (myPerson.userID.equals(myChat.person1.userID)) {
            myChat.person1Texts.add(newReply);
        } else if (myPerson.userID.equals(myChat.person2.userID)) {
            myChat.person2Texts.add(newReply);
        }
        myPost.postComments.add(newReply);

    }

    public static void forwardDm(Person myPerson, Post myDm, Chat myChat) {
        Post newPost = new Post();
        newPost.forwarded = "forwarded";
        newPost.usersPostId = myPerson.userID;
        newPost.postDate = Calendar.getInstance().getTime();
        newPost.script = myDm.script;
        newPost.postID = "@" + String.valueOf(myChat.allTexts.size()) + "*-*";
        myChat.allTexts.add(newPost);
        if (myPerson.userID.equals(myChat.person1.userID)) {
            myChat.person1Texts.add(newPost);
        } else if (myPerson.userID.equals(myChat.person2.userID)) {
            myChat.person2Texts.add(newPost);
        }

    }

    public static void searchPost(Person myPerson,ArrayList<Post> searchedPost , String text){
         int i , j , ii , jj;
         for(i=0 ; i<myPerson.allPersonalChats.size() ; i++){
             for (j=0 ; j<myPerson.allPersonalChats.get(i).allTexts.size() ; j++){
                 if(myPerson.allPersonalChats.get(i).allTexts.get(j).script.indexOf(text)!=-1){
                     searchedPost.add(myPerson.allPersonalChats.get(i).allTexts.get(j)) ;
                 }
             }
         }
        for(ii=0 ; ii<myPerson.allMyGroap.size() ; ii++){
            for (jj=0 ; jj<myPerson.allMyGroap.get(ii).allTexts.size() ; jj++){
                if(myPerson.allMyGroap.get(ii).allTexts.get(jj).script.indexOf(text)!=-1){
                    searchedPost.add(myPerson.allMyGroap.get(ii).allTexts.get(jj)) ;
                }
            }
        }
    }


}
