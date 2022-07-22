package view;

import controller.*;
import media.*;

import java.util.*;
import java.util.regex.Pattern;

public class Input {
    public Scanner sc = new Scanner(System.in);
    public RegisterMenu myRegister = new RegisterMenu();
    public String sample = new String();


    public int i, j;
    public int registerMenu = 0, accountMenu = 0;
    public int registerflag = 0, loginflag = 0, successfulLog = 0, deleteAccountflag = 0, successfulDeleteAccount, postflag = 0 , selectPostFlag=0  ;
    //public int ;

    public void backToDefault() {

    }

    public void register_menu() {
        System.out.println("Twitter");
        System.out.println("by yekta and rosa");
        registerMenu = 1;

    }

    public void inputRegister() {

        sample = sc.nextLine();
        String[] split;
        split = sample.split(" ");

        if (split[0].equals("register")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                registerflag = 1;
            } else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                registerflag = 1;
            } else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        System.out.println("a user exists with this username");
                        registerflag = 1;
                    }
                }
                if (registerflag == 0) {
                    Person newPerson = new Person();
                    newPerson.name = split[1];
                    newPerson.userPasswords = split[2];
                    newPerson.securityQuestion = split[3];
                    newPerson.userID = "@" + String.valueOf(myRegister.allRegisters.size()) + "***";
                    myRegister.allRegisters.add(newPerson);
                    System.out.println("register successful");
                }
            }

        }

        else if (split[0].equals("login")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                loginflag = 1;
            } else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                loginflag = 1;
            } else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        if (myRegister.allRegisters.get(i).userPasswords.equals(split[2])) {
                            System.out.println("login successful");
                            successfulLog = 1;
                            myRegister.logedInAccount = i;
                            accountMenu = 1;
                            break;
                        } else {
                            System.out.println("incorrect password");
                            loginflag = 1;
                            break;
                        }
                    }
                }
                if (successfulLog == 0 && loginflag == 0) {
                    System.out.println("no user exists with this username");
                    loginflag = 1;
                }
            }
        }

        else if (split[0].equals("deleteAccount")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                deleteAccountflag = 1;
            } else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                deleteAccountflag = 1;
            } else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        if (myRegister.allRegisters.get(i).userPasswords.equals(split[2])) {
                            System.out.println("removed " + split[1] + " successfully");
                            successfulDeleteAccount = 1;
                            myRegister.allRegisters.remove(i);
                            deleteAccountflag = 0;
                            break;
                        } else {
                            System.out.println("incorrect password");
                            deleteAccountflag = 1;
                            break;
                        }
                    }
                }
                if (successfulDeleteAccount == 0 && deleteAccountflag == 0) {
                    System.out.println("no user exists with this username");
                    deleteAccountflag = 1;
                }
            }
        }

        else if (sample.equals("exitApp")) {
            registerMenu = 0;
            System.out.println("program ended");
        }

        else if (split[0].equals("forget_password")) {
            //System.out.println("[user name] [your favorite flower's name] [new password]");
            for (i = 0; i < myRegister.allRegisters.size(); i++) {
                if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                    if (myRegister.allRegisters.get(i).securityQuestion.equals(split[2])) {
                        System.out.println("password is changed");
                        myRegister.allRegisters.get(i).userPasswords = split[3];
                    }
                }
            }
        }

        else if (sample.equals("help") && registerMenu == 1 && accountMenu == 0) {
            System.out.println("register [user_name] [password] [your favorite flower's name] \n" +
                    "login [user_name] [password] \n" +
                    "deleteAccount [user_name] [password] \n" +
                    "exitApp\n" +
                    "forget_password [user name] [your favorite flower's name] [new password]\n");
        }


        if (accountMenu == 1) {

            if (sample.equals("help") && accountMenu == 1) {
                System.out.println("exitApp \n" +
                        "change_username [user_name]\n" +
                        "change_password [user_pass]\n" +
                        "change_userId [user_Id]\n" +
                        "change_bio [user_bio]\n" +
                        "choose_accountType [user_AT]\n" +
                        "change_userType [UT]\n" +
                        "showMyAccount\n" +
                        "log out\n" +
                        "showAllUser\n" +
                        "showProfile [userId]\n" +
                        "follow [userId]\n" +
                        "unfollow [userId]\n" +
                        "removeFollower [userId]\n" +
                        "showFollowerList [userId]\n" +
                        "showFollowingList [userId]\n" +
                        "showMyRequests\n" +
                        "confirmFollowRequest [request nmber]\n" +
                        ""
                );
            }

            else if (split[0].equals("change_username")) {
                if (successfulLog == 1) {
                    Edit.changeUsername(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("change_password")) {
                if (successfulLog == 1) {
                    Edit.changePassword(myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("change_userId")) {
                if (successfulLog == 1) {
                    Edit.changeUserId(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("change_bio")) {
                if (successfulLog == 1) {
                    Edit.changeBio(myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("choose_accountType")) {
                if (successfulLog == 1) {
                    Edit.changeAccountType(myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("change_userType")) {
                if (successfulLog == 1) {
                    Edit.changeUserType(myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (split[0].equals("showMyAccount")) {
                if (successfulLog == 1) {
                    Show.show_account(myRegister.allRegisters.get(myRegister.logedInAccount));
                } else {
                    System.out.println("please login first!");
                }
            }

            else if (sample.equals("log out")) {
                successfulLog = 0;
                myRegister.logedInAccount = -1;
                System.out.println("you logged out");
            }

            else if (sample.equals("showAllUser")) {
                Show.show_allProfiles(myRegister);
            }

            else if (split[0].equals("showProfile")) {
                Show.show_userProfile(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
            }

            else if (split[0].equals("follow")) {
                Communication.followSb(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
            }

            else if (split[0].equals("unfollow")) {
                Communication.unfollowSb(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
            }

            else if (split[0].equals("removeFollower")) {
                Communication.removeFollower(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
            }

            else if (split[0].equals("showFollowerList")) {
                Show.show_userFollowerList(myRegister, split[1]);
            }

            else if (split[0].equals("showFollowingList")) {
                Show.show_userFollowingList(myRegister, split[1]);
            }

            else if (sample.equals("showMyRequests")) {
                Show.show_userRequsts(myRegister.allRegisters.get(myRegister.logedInAccount));
            }

            else if (split[0].equals("confirmFollowRequest")) {
                Edit.confirmFollow(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), split[1]);
            }

            else if (sample.equals("creat post")) {
                postflag = 1;
            }

            else if (postflag == 1) {

                if (split[0].equals("add_text")) {
                    Post.writePost(myRegister, sample.substring(9));
                    System.out.println("the newPost is now in your drafts");
                }

                else if (sample.equals("post")) {
                    System.out.println(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1).postID + " has successfully posted");
                    Post.post(myRegister);
                    postflag = 0;
                }

            }

            else if (split[0].equals("editPost")){
                int ff = 0;
                for(i=0 ; i<myRegister.allRegisters.get(myRegister.logedInAccount).posts.size() ; i++){
                    if(myRegister.allRegisters.get(myRegister.logedInAccount).posts.get(i).postID.equals(split[1])){
                        Post.editPost( myRegister.allRegisters.get(myRegister.logedInAccount).posts.get(i), sample.substring(sample.indexOf('-')+1) );
                        ff=1 ;
                        break;
                    }
                }
                if(ff==0){
                    System.out.println("you only can edit your own posts");
                }
            }

            else if (split[0].equals("showPosts")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                        Show.show_sbPosts(myRegister,myRegister.allRegisters.get(i));
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    System.out.println("the userId is incorrect");
                }
            }

            else if(split[0].equals("selectPost")){
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                        for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                            if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                Show.show_selectedPost(myRegister,myRegister.allRegisters.get(i).posts.get(j));
                                ff = 1;
                                selectPostFlag=1 ;
                                myRegister.allRegisters.get(i).selectedPostId = split[2] ;
                                break;
                            }
                        }
                    }
                    break;
                }

                if (ff == 0) {
                    System.out.println("the postId is incorrect");
                }
            }

            else if(selectPostFlag==1) {

                if (split[0].equals("showLikes")) {
                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Show.show_postLikes(myRegister.allRegisters.get(i).posts.get(j));
                                    ff = 1;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    if (ff == 0) {
                        System.out.println("the postId is incorrect");
                    }

                }

                else if (split[0].equals("showComments")) {

                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Show.show_postComments(myRegister.allRegisters.get(i).posts.get(j));
                                    ff = 1;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    if (ff == 0) {
                        System.out.println("the postId is incorrect");
                    }
                }

                else if(sample.equals("deselect")){
                    selectPostFlag=0 ;

                }

                else if(split[0].equals("like")){
                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Post.likePost(myRegister.allRegisters.get(myRegister.logedInAccount) , myRegister.allRegisters.get(i).posts.get(j) );
                                    ff = 1;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    if (ff == 0) {
                        System.out.println("the postId is incorrect");
                    }
                }

                else if(split[0].equals("comment")){

                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Post.commentPost(myRegister.allRegisters.get(myRegister.logedInAccount) , myRegister.allRegisters.get(i).posts.get(j) , split[3] );
                                    ff = 1;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    if (ff == 0) {
                        System.out.println("the postId is incorrect");
                    }

                }

            }

            else if(sample.equals("enterMainPage")){
                myRegister.allRegisters.get(myRegister.logedInAccount).makeMainPage() ;
                Show.MainShow(myRegister.allRegisters.get(myRegister.logedInAccount));
            }



        }


    }


}
