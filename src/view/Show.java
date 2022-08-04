package view;

import media.*;
import controller.*;
import temporary.*;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Show {

    public static void show_account(Person myPerson) {
        int i;
        System.out.println("user name: " + myPerson.name);
        System.out.println("userId: " + myPerson.userID);
        System.out.println("***");
        System.out.println(myPerson.bio);
        System.out.println("posts " + myPerson.posts.size() + " followers " + myPerson.folowers.size() + " followings " + myPerson.folowings.size());

    }

    public static void show_allProfiles(RegisterMenu myRegester) {
        int i;
        for (i = 0; i < myRegester.allRegisters.size(); i++) {
            System.out.println(myRegester.allRegisters.get(i).name + "   userId: " + myRegester.allRegisters.get(i).userID + "   user Type: " + myRegester.allRegisters.get(i).userAccountType);
        }
    }

    public static void show_userProfile(RegisterMenu myRegister, Person myPerson, String id) {
        int i, j, flag = 0, ff = 0;
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(id)) {
                if (myRegister.allRegisters.get(i).userType.equals("private")) {
                    for (j = 0; j < myRegister.allRegisters.get(i).folowers.size(); j++) {
                        if (myRegister.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)) {
                            flag = 1;
                            break;
                        }
                    }
                } else {
                    flag = 1;
                }
                ff = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("user name: " + myRegister.allRegisters.get(i).name);
            System.out.println("userId: " + myRegister.allRegisters.get(i).userID);
            System.out.println("***");
            System.out.println(myRegister.allRegisters.get(i).bio);
            System.out.println("posts " + myRegister.allRegisters.get(i).posts.size() + " followers " + myRegister.allRegisters.get(i).folowers.size() + " followings " + myRegister.allRegisters.get(i).folowings.size());

        } else if (ff == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userFollowerList(RegisterMenu myRegister, String id) {
        int i, j, ff = 0;
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(id)) {
                for (j = 0; j < myRegister.allRegisters.get(i).folowers.size(); j++) {
                    System.out.println(myRegister.allRegisters.get(i).folowers.get(j).name + "   userId: " + myRegister.allRegisters.get(i).folowers.get(j).userID + "   user Type: " + myRegister.allRegisters.get(i).folowers.get(j).userAccountType);
                }
                ff = 1;
                break;
            }
        }
        if (ff == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userFollowingList(RegisterMenu myRegister, String id) {
        int i, j, ff = 0;
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(id)) {
                for (j = 0; j < myRegister.allRegisters.get(i).folowings.size(); j++) {
                    System.out.println(myRegister.allRegisters.get(i).folowings.get(j).name + "   userId: " + myRegister.allRegisters.get(i).folowings.get(j).userID + "   user Type: " + myRegister.allRegisters.get(i).folowings.get(j).userAccountType);
                }
                ff = 1;
                break;
            }
        }
        if (ff == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userRequsts(Person myPerson) {
        int i;
        for (i = myPerson.massageRequests.size() - 1; i >= 0; i--) {
            System.out.println(myPerson.massageRequests.get(i));
        }
    }

    public static void show_sbPosts(RegisterMenu myRegister, Person myPerson) {
        int i, j, flag = 0;
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(myPerson.userID)) {
                if (myRegister.allRegisters.get(i).userType.equals("private")) {
                    for (j = 0; j < myRegister.allRegisters.get(i).folowers.size(); j++) {
                        if (myRegister.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)) {
                            flag = 1;
                            break;
                        }
                    }
                } else {
                    flag = 1;
                }
                break;
            }
        }
        if (flag == 1) {
            for (i = 0; i < myPerson.posts.size(); i++) {
                System.out.println("id: " + myPerson.posts.get(i).postID + "  " + myPerson.posts.get(i).script + "  " + myPerson.posts.get(i).edited);
                System.out.println("liked " + myPerson.posts.get(i).likedUsers.size() + "  commented " + myPerson.posts.get(i).postComments.size());
                System.out.println("  time: " + myPerson.posts.get(i).postDate.toString());
                System.out.println("--------");
            }
        } else {
            System.out.println("account is private");
        }
    }

    public static void show_selectedPost(RegisterMenu myRegister, Post myPost) {
        int i, j, flag = 0;

        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(myPost.usersPostId)) {
                if (myRegister.allRegisters.get(i).userType.equals("private")) {
                    for (j = 0; j < myRegister.allRegisters.get(i).folowers.size(); j++) {
                        if (myRegister.allRegisters.get(i).folowers.get(j).userID.equals(myPost.usersPostId)) {
                            flag = 1;
                            break;
                        }
                    }
                } else {
                    flag = 1;
                }
                break;
            }
        }
        if (flag == 1) {
            System.out.println("id: " + myPost.postID + "  " + myPost.script);
            System.out.println("liked " + myPost.likedUsers.size() + "  commented " + myPost.postComments.size());
            System.out.println("time: " + myPost.postDate.toString());
            if (myPost.postComments.size() >= 2) {
                System.out.println("comments: " + myPost.postComments.get(myPost.postComments.size() - 1).script);
                System.out.println("          " + myPost.postComments.get(myPost.postComments.size() - 2).script);
            } else if (myPost.postComments.size() == 1) {
                System.out.println("comments: " + myPost.postComments.get(myPost.postComments.size() - 1).script);
            }
        } else {
            System.out.println("account is private");
        }
    }

    public static void show_postLikes(Post myPost) {
        int i;
        for (i = 0; i < myPost.likedUsers.size(); i++) {
            System.out.println(myPost.likedUsers.get(i).name + " userId: " + myPost.likedUsers.get(i).userID + " user type: " + myPost.likedUsers.get(i).userType);
        }
    }

    public static void show_postComments(Post myPost) {
        int i;
        for (i = 0; i < myPost.postComments.size(); i++) {
            System.out.println("userId: " + myPost.postComments.get(i).usersPostId + "   -" + myPost.postComments.get(i).script + " time:" + myPost.postComments.get(i).postDate.toString());
        }
    }

    public static void MainShow(Person myPerson, ArrayList<BusinessUser> myBussinesUsers) {
        int i;
        Person.makeMainPage(myPerson,myBussinesUsers);
        for (i = 0; i < myPerson.mainPagePostFinal.size(); i++) {
            System.out.println("id: " + myPerson.mainPagePostFinal.get(i).postID + "  " + myPerson.mainPagePostFinal.get(i).script + "  " + myPerson.mainPagePostFinal.get(i).edited);
            System.out.println("liked " + myPerson.mainPagePostFinal.get(i).likedUsers.size() + "commented " + myPerson.mainPagePostFinal.get(i).postComments.size());
            System.out.println("  time: " + myPerson.mainPagePostFinal.get(i).postDate.toString());
            System.out.println("--------");
        }
    }

    public static void show_allDirect(Person myPerson) {
        int i;
        for (i = 0; i < myPerson.allPersonalChats.size(); i++) {
            System.out.println(myPerson.allPersonalChats.get(i).person1.userID + " & " + myPerson.allPersonalChats.get(i).person2.userID);
            if (myPerson.allPersonalChats.get(i).allTexts.size() > 0) {
                System.out.println(myPerson.allPersonalChats.get(i).allTexts.get(myPerson.allPersonalChats.get(i).allTexts.size() - 1).script);
                System.out.println(myPerson.allPersonalChats.get(i).allTexts.get(myPerson.allPersonalChats.get(i).allTexts.size() - 1).postDate.toString());
            }
            System.out.println("---------------");

        }
    }

    public static void show_directWith(Chat myChat) {
        int i, j;
        for (i = 0; i < myChat.allTexts.size(); i++) {
            System.out.println("________________");
            System.out.println("userId: " + myChat.allTexts.get(i).usersPostId);
            System.out.println("postId: " + myChat.allTexts.get(i).postID);
            if (myChat.allTexts.get(i).getClass().toString().equals("Comment")) {
                for (j = 0; j < myChat.allReply.size(); j++) {
                    if (myChat.allReply.get(j).postID.equals(myChat.allTexts.get(i).postID)) {
                        System.out.println("   -reply: " + myChat.allReply.get(j).postOfTheComment.script.substring(0, 4) + "...");
                        break;
                    }
                }
            }
            System.out.println("-" + myChat.allTexts.get(i).script);
            System.out.println(myChat.allTexts.get(i).postDate.toString());
            System.out.println("liked: " + myChat.allTexts.get(i).likedUsers.size());
            System.out.println(myChat.allTexts.get(i).edited + "    " + myChat.allTexts.get(i).forwarded);
        }
    }

    public static void show_searchResult(ArrayList<Post> searchedPost) {
        int i;
        if (searchedPost.size() == 0) {
            System.out.println("no result");
        } else {
            System.out.println("the result");
            for (i = 0; i < searchedPost.size(); i++) {
                System.out.println("________________");
                System.out.println("userId: " + searchedPost.get(i).usersPostId);
                System.out.println("postId: " + searchedPost.get(i).postID);
                System.out.println(searchedPost.get(i).script);
            }
        }
    }

    public static void show_selectedDm(Person myPerson, String postIdString) {
        int i, j, ii, jj, ff = 0, gg = 0;
        for (i = 0; i < myPerson.allPersonalChats.size(); i++) {
            for (j = 0; j < myPerson.allPersonalChats.get(i).allTexts.size(); j++) {
                if (myPerson.allPersonalChats.get(i).allTexts.get(j).postID.equals(postIdString)) {
                    System.out.println("userId: " + myPerson.allPersonalChats.get(i).allTexts.get(j).usersPostId);
                    System.out.println("postId: " + myPerson.allPersonalChats.get(i).allTexts.get(j).postID);
                    System.out.println("-" + myPerson.allPersonalChats.get(i).allTexts.get(j).script);
                    System.out.println(myPerson.allPersonalChats.get(i).allTexts.get(j).postDate.toString());
                    System.out.println("liked: " + myPerson.allPersonalChats.get(i).allTexts.get(j).likedUsers.size());
                    System.out.println(myPerson.allPersonalChats.get(i).allTexts.get(j).edited + "   " + myPerson.allPersonalChats.get(i).allTexts.get(j).forwarded);
                    ff = 1;
                    break;
                }
            }
            if (ff == 1) {
                break;
            }
        }
        if (ff == 0) {
            for (ii = 0; ii < myPerson.allMyGroap.size(); ii++) {
                for (jj = 0; jj < myPerson.allMyGroap.get(ii).allTexts.size(); jj++) {
                    if (myPerson.allMyGroap.get(ii).allTexts.get(jj).postID.equals(postIdString)) {

                        gg = 1;
                        break;
                    }
                }
                if (gg == 1) {
                    break;
                }
            }
        }
        if (ff == 0 && gg == 0) {
            System.out.println("incorrect postId");
        }
    }

    public static void show_allGroup(Person myPerson) {
        int i;
        for (i = 0; i < myPerson.allMyGroap.size(); i++) {
            System.out.println(myPerson.allMyGroap.get(i).groupName + "   id:" + myPerson.allMyGroap.get(i).groupId);
            System.out.println(String.valueOf(myPerson.allMyGroap.get(i).groupUsers.size()) + "member");
            System.out.println("---------------");
        }
    }

    public static void show_groupUsers(Group myGroup) {
        int i;
        System.out.println(myGroup.groupName);
        System.out.println("*****");
        for (i = 0; i < myGroup.groupUsers.size(); i++) {
            System.out.println(myGroup.groupUsers.get(i).name + "  id:" + myGroup.groupUsers.get(i).userID);
            System.out.println("---------------");
        }
    }

    public static void show_currentGroup(Group myGroup) {
        int i , j ;
        System.out.println(myGroup.groupName);
        System.out.println("groupId: "+myGroup.groupId);
        System.out.println(myGroup.groupUsers.size()+" member");
        System.out.println("********");
        for (i=0 ; i<myGroup.allTexts.size() ; i++){
            System.out.println("user: "+myGroup.allTexts.get(i).usersPostId);
            System.out.println("postId: "+myGroup.allTexts.get(i).postID);
            if (myGroup.allTexts.get(i).getClass().toString().equals("Comment")) {
                for (j = 0; j < myGroup.allReply.size(); j++) {
                    if (myGroup.allReply.get(j).postID.equals(myGroup.allTexts.get(i).postID)) {
                        System.out.println("   -reply: " + myGroup.allReply.get(j).postOfTheComment.script.substring(0, 4) + "...");
                        break;
                    }
                }
            }
            System.out.println("-" + myGroup.allTexts.get(i).script);
            System.out.println(myGroup.allTexts.get(i).postDate.toString());
            System.out.println("liked: " + myGroup.allTexts.get(i).likedUsers.size());
            System.out.println(myGroup.allTexts.get(i).edited + "    " + myGroup.allTexts.get(i).forwarded);
        }
    }

    public static void show_suggestedPerson(Person myPerson){
        ArrayList<Person> suggestedPerson = Commercial.sortSuggestedPerson(myPerson);
        for (int i = 0; i < 5 && i<suggestedPerson.size(); i++) {
            System.out.println("name : " + suggestedPerson.get(i).name + " - " +
                                "userId : " + suggestedPerson.get(i).userID);
        }
    }

    public static void show_mainPosts(Person person , ArrayList<BusinessUser> business){

        for (int i = 0; i < person.mainPagePostFinal.size() && i < 10; i++) {
            System.out.println(person.mainPagePostFinal.get(i).usersPostId + " : " +
                    person.mainPagePostFinal.get(i).script + "\t" +
                    person.mainPagePostFinal.get(i).postDate);
        }

    }

    public static void show_stat(BusinessPost myPost){
        System.out.println("view in days:");
        System.out.println("days passed\tviews");
        ArrayList<Integer> views = myPost.eachDayView();
        for (int i = 0; i < views.size(); i++) {
            System.out.println(i + "\t" + views.get(i));
        }
        for (int i = 0; i < 20; i++) {
            System.out.print("_");
        }
        System.out.println();
        System.out.println("likes in days:");
        System.out.println("days passed\tlikes");
        ArrayList<Integer> likes = myPost.eachDayLike();
        for (int i = 0; i < likes.size(); i++) {
            System.out.println(i + "\t" + likes.get(i));
        }
        for (int i = 0; i < 20; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    public static void show_searchName(ArrayList<Person> myResult){
        int i;
        for(i=0 ; i<myResult.size() ; i++){
            System.out.println(myResult.get(i).name+"  id: "+myResult.get(i).userID);
            System.out.println(myResult.get(i).userAccountType);
            System.out.println("---------------");
        }
    }


}


