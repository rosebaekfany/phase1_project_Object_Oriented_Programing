package view;

import media.*;
import controller.*;
import temporary.*;

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
            if(myPost.postComments.size()>=2) {
                System.out.println("comments: " + myPost.postComments.get(myPost.postComments.size() - 1).script);
                System.out.println("          " + myPost.postComments.get(myPost.postComments.size() - 2).script);
            }
            else if(myPost.postComments.size()==1){
                System.out.println("comments: " + myPost.postComments.get(myPost.postComments.size() - 1).script);
            }
        }
        else {
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

    public static void MainShow(Person myPerson) {
        int i;
        myPerson.makeMainPage();
        for (i = 0; i < myPerson.mainPagePost.size(); i++) {
            System.out.println("id: " + myPerson.mainPagePost.get(i).postID + "  " + myPerson.mainPagePost.get(i).script + "  " + myPerson.mainPagePost.get(i).edited);
            System.out.println("liked " + myPerson.mainPagePost.get(i).likedUsers.size() + "commented " + myPerson.posts.get(i).postComments.size());
            System.out.println("  time: " + myPerson.mainPagePost.get(i).postDate.toString());
            System.out.println("--------");
        }
    }


}
