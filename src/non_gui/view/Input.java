package non_gui.view;

import non_gui.controller.*;
import non_gui.media.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public Scanner sc = new Scanner(System.in);
    public RegisterMenu myRegister = new RegisterMenu();
    public String sample = new String();


    public int i, j;
    public int registerMenu = 0, accountMenu = 0;
    public int registerflag = 0, loginflag = 0, successfulLog = 0, deleteAccountflag = 0, successfulDeleteAccount, postflag = 0, selectPostFlag = 0;
    public int startChat = 0 , enterGroup=0 ;

    public void backToDefault() {
        accountMenu = 0;
        registerflag = 0;
        loginflag = 0;
        successfulLog = 0;
        deleteAccountflag = 0;
        successfulDeleteAccount = 0;
        postflag = 0;
        selectPostFlag = 0;
        startChat = 0;
        enterGroup=0;
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
                        "confirmFollowRequest [request number]\n" +
                        "creat post\n" +
                        "add_text [text]\n" +
                        "post\n" +
                        "editPost [postId] -[text]\n" +
                        "showPosts [userId]\n" +
                        "selectPost [userId] [postId]\n" +
                        "showLikes [userId] [postId]\n" +
                        "showComments [userId] [postId]\n" +
                        "like [userId] [postId]\n" +
                        "comment [userId] [postId] -[text]\n" +
                        "deselect\n" +
                        "enterMainPage\n" +
                        "ChatWith [userId]\n" +
                        "addDm -[text]\n" +
                        "editDm [postId] -[text]\n" +
                        "likeDm [postId]\n" +
                        "replyDm [postId] -[text]\n" +
                        "forward [postId] [sbUserId]\n" +
                        "deleteDm [postId]\n" +
                        "exit Chat\n" +
                        "showAllPersonalDms\n" +
                        "showChatWith [userId]\n" +
                        "block [userId]\n" +
                        "search -[text]\n" +
                        "showSelectedDm [postId]"
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

            else if(split[0].equals("choose_accountType")){ // ToDo
                if (successfulLog == 1) {
                    if (split[1].equals("General_Account")){
                        if (myRegister.allRegisters.get(myRegister.logedInAccount).userAccountType
                                .equals("Business_Account")){
                            Edit.changeAccountTypeToGeneral((BusinessUser)
                                    myRegister.allRegisters.get(myRegister.logedInAccount));
                            System.out.println("successful change");
                        } else {
                            System.out.println("your account is already general");
                        }

                    } else if (split[1].equals("Business_Account")) {
                        System.out.println("Enter your business phoneNumber");
                        String phoneNumber = sc.nextLine();
                        String regexStr = "^(\\d{4,17})$";
                        Pattern pattern = Pattern.compile(regexStr);
                        Matcher matcher  = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            if (myRegister.allRegisters.get(myRegister.logedInAccount).userAccountType
                                    .equals("General_Account")) {
                                BusinessUser myBusinessUser =Edit.changeAccountTypeToBusiness
                                        (myRegister.allRegisters.get(myRegister.logedInAccount), phoneNumber);
                                myRegister.businessUsers.add(myBusinessUser);
                                for (BusinessUser businessUser : myRegister.businessUsers) {
                                    System.out.println(businessUser.name);
                                }
                                myRegister.allRegisters.add(myBusinessUser);
                                for (Person allRegister : myRegister.allRegisters) {
                                    System.out.println(allRegister.name);
                                }
                                myRegister.allRegisters.remove(myRegister.logedInAccount);
                                for (Person allRegister : myRegister.allRegisters) {
                                    System.out.println(allRegister.name);
                                }
                                myRegister.logedInAccount = myRegister.allRegisters.size() - 1;
                                System.out.println(myRegister.logedInAccount);
                                System.out.println("successful change");
                            } else {
                                System.out.println("your account is already Business_Account");
                            }
                        } else {
                            System.out.println("Invalid phoneNumber format");
                        }
                    } else {
                        System.out.println("choose between General_Account or Business_Account");
                    }
                }
                else{
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
                backToDefault();
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

            else if (split[0].equals("editPost")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).posts.size(); i++) {
                    if (myRegister.allRegisters.get(myRegister.logedInAccount).posts.get(i).postID.equals(split[1])) {
                        Post.editPost(myRegister.allRegisters.get(myRegister.logedInAccount).posts.get(i), sample.substring(sample.indexOf('-') + 1));
                        ff = 1;
                        System.out.println("post is edited");
                        break;
                    }
                }
                if (ff == 0) {
                    System.out.println("you only can edit your own posts");
                }
            }

            else if (split[0].equals("showPosts")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                        Show.show_sbPosts(myRegister, myRegister.allRegisters.get(i));
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    System.out.println("the userId is incorrect");
                }
            }

            else if (split[0].equals("selectPost")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                        for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                            if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                Show.show_selectedPost(myRegister, myRegister.allRegisters.get(i).posts.get(j));
                                ff = 1;
                                selectPostFlag = 1;
                                myRegister.allRegisters.get(i).selectedPostId = split[2];
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

            else if (selectPostFlag == 1) {

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

                else if (sample.equals("deselect")) {
                    selectPostFlag = 0;
                    System.out.println("post is deselected");

                }

                else if (split[0].equals("like")) {
                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Post.likePost(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.allRegisters.get(i).posts.get(j));
                                    System.out.println("post is liked");
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

                else if (split[0].equals("comment")) {

                    int ff = 0, i, j;
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(i).posts.size(); j++) {
                                if (myRegister.allRegisters.get(i).posts.get(j).postID.equals(split[2])) {
                                    Post.commentPost(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.allRegisters.get(i).posts.get(j), sample.substring(sample.indexOf('-') + 1));
                                    ff = 1;
                                    System.out.println("comment is added");
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

            else if (sample.equals("enterMainPage")) {
                myRegister.allRegisters.get(myRegister.logedInAccount).makeMainPage();
                Show.MainShow(myRegister.allRegisters.get(myRegister.logedInAccount));
            }

            else if (split[0].equals("ChatWith")) {
                int ff = 0, fg = 0;
                for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); i++) {
                    if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(split[1])) {
                        if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).blockState.equals("blocked")) {
                            System.out.println("the chat is blocked");
                        } else {
                            Communication.countinueChatting(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            startChat = 1;
                            System.out.println("you have entered the chat");
                        }
                        ff = 1;
                        break;
                    } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(split[1])) {
                        if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).blockState.equals("blocked")) {
                            System.out.println("the chat is blocked");
                        } else {
                            Communication.countinueChatting(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            startChat = 1;
                            System.out.println("you have entered the chat");
                        }
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    for (i = 0; i < myRegister.allRegisters.size(); i++) {
                        if (myRegister.allRegisters.get(i).userID.equals(split[1]) && i != myRegister.logedInAccount) {
                            Communication.StartNewChat(myRegister, myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.allRegisters.get(i));
                            startChat = 1;
                            System.out.println("you have started a new chat");
                            fg = 1;
                            break;
                        }
                    }
                    if (fg == 0) {
                        System.out.println("userId is incorrect");
                    }
                }
            }

            else if (startChat == 1) {

                if (split[0].equals("addDm")) {
                    if (myRegister.chatOnBord.blockState.equals("blocked")) {
                        System.out.println("the chat is blocked");
                    } else {
                        Communication.DMing(myRegister.chatOnBord, myRegister.allRegisters.get(myRegister.logedInAccount), sample.substring(1 + sample.indexOf('-')));
                        System.out.println("dm is added");
                    }
                }

                else if (split[0].equals("editDm")) {
                    int ff = 0;
                    if (myRegister.chatOnBord.person1.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                            if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person1Texts.size() - 15) {
                                if (myRegister.chatOnBord.person1Texts.get(i).forwarded.equals("")) {
                                    System.out.println("dm is edited");
                                    Communication.editDmInChat(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i), sample.substring(1 + sample.indexOf('-')));
                                } else {
                                    System.out.println("you can't edit this DM");
                                }
                                ff = 1;
                                break;
                            }
                        }
                    } else if (myRegister.chatOnBord.person2.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person2Texts.size(); i++) {
                            if (myRegister.chatOnBord.person2Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person2Texts.size() - 15) {
                                if (myRegister.chatOnBord.person2Texts.get(i).forwarded.equals("")) {
                                    Communication.editDmInChat(myRegister.chatOnBord, myRegister.chatOnBord.person2Texts.get(i), sample.substring(1 + sample.indexOf('-')));
                                } else {
                                    System.out.println("you can't edit this DM");
                                }
                                ff = 1;
                                break;
                            }
                        }
                    } else if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }

                else if (split[0].equals("likeDm")) {
                    int ff = 0;
                    if (myRegister.chatOnBord.person1.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person2Texts.size(); i++) {
                            if (myRegister.chatOnBord.person2Texts.get(i).postID.equals(split[1])) {
                                Communication.likeDm(myRegister.chatOnBord, myRegister.chatOnBord.person2Texts.get(i), myRegister.chatOnBord.person1);
                                System.out.println("DM is liked");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (myRegister.chatOnBord.person2.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                            if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1])) {
                                Communication.likeDm(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i), myRegister.chatOnBord.person2);
                                System.out.println("DM is liked");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }

                else if (split[0].equals("replyDm")) {
                    int ff = 0;
                    for (i = 0; i < myRegister.chatOnBord.allTexts.size(); i++) {
                        if (myRegister.chatOnBord.allTexts.get(i).postID.equals(split[1])) {
                            Communication.replyChat(myRegister.chatOnBord, myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount), sample.substring(1 + sample.indexOf('-')));
                            System.out.println("replied successfully");
                            ff = 1;
                            break;
                        }
                    }
                    if (ff == 0) {
                        System.out.println("incorrect postId");
                    }
                }

                else if (split[0].equals("forward")) {

                    int ff = 0, j;
                    for (i = 0; i < myRegister.chatOnBord.allTexts.size(); i++) {
                        if (myRegister.chatOnBord.allTexts.get(i).postID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); j++) {
                                if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j).person1.userID.equals(split[2])) {
                                    Communication.forwardDm(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j));
                                    ff = 1;
                                    break;
                                } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j).person2.userID.equals(split[2])) {
                                    Communication.forwardDm(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j));
                                    ff = 1;
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }


                else if (split[0].equals("deleteDm")) {
                    int ff = 0;
                    if (myRegister.chatOnBord.person1.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                            if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person1Texts.size() - 15) {
                                Communication.deleteDmChat(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i));
                                myRegister.chatOnBord.person1Texts.remove(i);
                                System.out.println("DM is deleted");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (myRegister.chatOnBord.person2.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person2Texts.size(); i++) {
                            if (myRegister.chatOnBord.person2Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person2Texts.size() - 15) {
                                Communication.deleteDmChat(myRegister.chatOnBord, myRegister.chatOnBord.person2Texts.get(i));
                                myRegister.chatOnBord.person2Texts.remove(i);
                                System.out.println("DM is deleted");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }

                else if (sample.equals("exit Chat")) {
                    startChat = 0;
                    System.out.println("you have exited the chat");
                }

                else if (split[0].equals("showChatWith")) {
                    int ff = 0;
                    for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); i++) {
                        if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(split[1])) {
                            Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            ff = 1;
                            break;
                        } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(split[1])) {
                            Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            ff = 1;
                            break;
                        }
                    }
                    if (ff == 0) {
                        System.out.println("you have no DM with this person");
                    }
                }


            }

            else if (sample.equals("showAllPersonalDms")) {
                Show.show_allDirect(myRegister.allRegisters.get(myRegister.logedInAccount));
            }

            else if (split[0].equals("showChatWith")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); i++) {
                    if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(split[1])) {
                        Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                        ff = 1;
                        break;
                    } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(split[1])) {
                        Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    System.out.println("you have no DM with this person");
                }
            }

            else if(split[0].equals("search")) {
                ArrayList<Post> searchedPost = new ArrayList<>() ;
                Communication.searchPost(myRegister.allRegisters.get(myRegister.logedInAccount),searchedPost,sample.substring(1+sample.indexOf('-')));
                Show.show_searchResult(searchedPost);

            }

            else if (split[0].equals("showSelectedDm")){
                Show.show_selectedDm(myRegister.allRegisters.get(myRegister.logedInAccount),split[1]);
            }

            else if (split[0].equals("block")) {
                int ff = 0;
                for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); i++) {
                    if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(split[1])) {
                        myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).blockState = "blocked";
                        System.out.println("you have blocked this person");
                        ff = 1;
                        break;
                    }
                    else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(split[1])) {
                        myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).blockState = "blocked";
                        System.out.println("you have blocked this person");
                        ff = 1;
                        break;
                    }
                }
                if (ff == 0) {
                    System.out.println("you don't have chat with this person");
                }
            }

            else if (split[0].equals("creatGroup")){
                Group.creatGroup(myRegister.allRegisters.get(myRegister.logedInAccount),sample.substring(1+sample.indexOf('-')));
                System.out.println("group is created");
            }

            else if (split[0].equals("showAllGroups")){
                Show.show_allGroup(myRegister.allRegisters.get(myRegister.logedInAccount));
            }

            else if (split[0].equals("enterGroup")){

                int ff=0 ;
                for(i=0 ; i<myRegister.allRegisters.get(myRegister.logedInAccount).allMyGroap.size() ; i++){
                    if(myRegister.allRegisters.get(myRegister.logedInAccount).allMyGroap.get(i).groupId.equals(split[1])){
                        myRegister.grouponBord=myRegister.allRegisters.get(myRegister.logedInAccount).allMyGroap.get(i) ;
                        enterGroup=1 ;
                        System.out.println("you have entered the group");
                        ff=1 ;
                        break;
                    }
                }
                if(ff==0){
                    System.out.println("there is no such group");
                }
            }

            else if (enterGroup==1){

                if (split[0].equals("addDm")) {
                    Group.DMing(myRegister.grouponBord, myRegister.allRegisters.get(myRegister.logedInAccount), sample.substring(1 + sample.indexOf('-')));
                    System.out.println("dm is added");
                }

                else if (split[0].equals("editDm")) {
                    int ff = 0;
                    for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                        if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person1Texts.size() - 15) {
                            if (myRegister.chatOnBord.person1Texts.get(i).forwarded.equals("")) {
                                System.out.println("dm is edited");
                                Communication.editDmInChat(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i), sample.substring(1 + sample.indexOf('-')));
                            }
                            else {
                                System.out.println("you can't edit this DM");
                            }
                            ff = 1;
                            break;
                        }
                    }

                    if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }
/*
                else if (split[0].equals("likeDm")) {
                    int ff = 0;
                    if (myRegister.chatOnBord.person1.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person2Texts.size(); i++) {
                            if (myRegister.chatOnBord.person2Texts.get(i).postID.equals(split[1])) {
                                Communication.likeDm(myRegister.chatOnBord, myRegister.chatOnBord.person2Texts.get(i), myRegister.chatOnBord.person1);
                                System.out.println("DM is liked");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (myRegister.chatOnBord.person2.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                            if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1])) {
                                Communication.likeDm(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i), myRegister.chatOnBord.person2);
                                System.out.println("DM is liked");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }

                else if (split[0].equals("replyDm")) {
                    int ff = 0;
                    for (i = 0; i < myRegister.chatOnBord.allTexts.size(); i++) {
                        if (myRegister.chatOnBord.allTexts.get(i).postID.equals(split[1])) {
                            Communication.replyChat(myRegister.chatOnBord, myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount), sample.substring(1 + sample.indexOf('-')));
                            System.out.println("replied successfully");
                            ff = 1;
                            break;
                        }
                    }
                    if (ff == 0) {
                        System.out.println("incorrect postId");
                    }
                }

                else if (split[0].equals("forward")) {

                    int ff = 0, j;
                    for (i = 0; i < myRegister.chatOnBord.allTexts.size(); i++) {
                        if (myRegister.chatOnBord.allTexts.get(i).postID.equals(split[1])) {
                            for (j = 0; j < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); j++) {
                                if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j).person1.userID.equals(split[2])) {
                                    Communication.forwardDm(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j));
                                    ff = 1;
                                    break;
                                } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j).person2.userID.equals(split[2])) {
                                    Communication.forwardDm(myRegister.allRegisters.get(myRegister.logedInAccount), myRegister.chatOnBord.allTexts.get(i), myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(j));
                                    ff = 1;
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }


                else if (split[0].equals("deleteDm")) {
                    int ff = 0;
                    if (myRegister.chatOnBord.person1.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person1Texts.size(); i++) {
                            if (myRegister.chatOnBord.person1Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person1Texts.size() - 15) {
                                Communication.deleteDmChat(myRegister.chatOnBord, myRegister.chatOnBord.person1Texts.get(i));
                                myRegister.chatOnBord.person1Texts.remove(i);
                                System.out.println("DM is deleted");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (myRegister.chatOnBord.person2.userID.equals(myRegister.allRegisters.get(myRegister.logedInAccount).userID)) {
                        for (i = 0; i < myRegister.chatOnBord.person2Texts.size(); i++) {
                            if (myRegister.chatOnBord.person2Texts.get(i).postID.equals(split[1]) && i >= myRegister.chatOnBord.person2Texts.size() - 15) {
                                Communication.deleteDmChat(myRegister.chatOnBord, myRegister.chatOnBord.person2Texts.get(i));
                                myRegister.chatOnBord.person2Texts.remove(i);
                                System.out.println("DM is deleted");
                                ff = 1;
                                break;
                            }
                        }
                    } else if (ff == 0) {
                        System.out.println("you dont have the access");
                    }
                }

                else if (sample.equals("exit Chat")) {
                    startChat = 0;
                    System.out.println("you have exited the chat");
                }

                else if (split[0].equals("showChatWith")) {
                    int ff = 0;
                    for (i = 0; i < myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.size(); i++) {
                        if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person1.userID.equals(split[1])) {
                            Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            ff = 1;
                            break;
                        } else if (myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i).person2.userID.equals(split[1])) {
                            Show.show_directWith(myRegister.allRegisters.get(myRegister.logedInAccount).allPersonalChats.get(i));
                            ff = 1;
                            break;
                        }
                    }
                    if (ff == 0) {
                        System.out.println("you have no DM with this person");
                    }
                }*/

            }








        }


    }


}
