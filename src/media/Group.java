package media;

import java.util.*;

import controller.*;
import temporary.*;
import view.*;

public class Group {
    public String groupName = new String();
    public Person admin = new Person();
    public ArrayList<Person> groupUsers = new ArrayList<>();
    public ArrayList<Person> bannedUsers = new ArrayList<>();
    public ArrayList<Post> allTexts = new ArrayList<>();
    public ArrayList<Comment> allReply = new ArrayList<>();
    //String[] adminID = new String[50] ;
    public String groupId = new String();

    public static void creatGroup(Person myPerson, String groupName) {
        Group newGroup = new Group();
        newGroup.groupName = groupName;
        newGroup.groupId = "@" + String.valueOf(myPerson.allMyGroap.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "**__**";
        newGroup.groupUsers.add(myPerson);
        newGroup.admin = myPerson;
        newGroup.groupUsers.add(myPerson);
        myPerson.allMyGroap.add(newGroup);
    }

    public static void DMing(Group myGroup, Person myPerson, String newText) {

        Post newDm = new Post();
        newDm.postDate = Calendar.getInstance().getTime();
        newDm.script = newText;
        newDm.usersPostId = myPerson.userID;
        newDm.postID = "@" + String.valueOf(myGroup.allTexts.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "**--**";
        myGroup.allTexts.add(newDm);

    }

    public static void editDmInGroup(Group myGroup, Post myDm, String newText) {
        int num, i, ff = 0;
        myDm.script = newText;
        myDm.edited = "edited";
        for (i = 0; i < myGroup.allTexts.size(); i++) {
            if (myGroup.allTexts.get(i).postID.equals(myDm.postID)) {
                myGroup.allTexts.get(i).script = newText;
                myGroup.allTexts.get(i).edited = "edited";
                break;
            }
        }
    }

    public static void likeDm(Group myGroup, Post myDm, Person myPerson) {
        int i;
        myDm.likedUsers.add(myPerson);
        for (i = 0; i < myGroup.allTexts.size(); i++) {
            if (myGroup.allTexts.get(i).postID.equals(myDm.postID)) {
                myGroup.allTexts.get(i).likedUsers.add(myPerson);
            }
        }
    }

    public static void deleteDmChat(Group myGroup, Post myDm) {
        int i;
        for (i = 0; i < myGroup.allTexts.size(); i++) {
            if (myGroup.allTexts.get(i).postID.equals(myDm.postID)) {
                myGroup.allTexts.remove(i);
            }
        }
    }

    public static void replyChat(Group myGroup, Post myPost, Person myPerson, String newText) {
        Comment newReply = new Comment();
        newReply.script = newText;
        newReply.postDate = Calendar.getInstance().getTime();
        newReply.postOfTheComment = myPost;
        newReply.postID = "@" + String.valueOf(myPost.postComments.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "***---***";
        newReply.usersPostId = myPerson.userID;
        myGroup.allTexts.add(newReply);
        myGroup.allReply.add(newReply);
        myPost.postComments.add(newReply);

    }

    public static void forwardDm(Person myPerson, Post myDm, Group myGroup) {
        Post newPost = new Post();
        newPost.forwarded = "forwarded";
        newPost.usersPostId = myPerson.userID;
        newPost.postDate = Calendar.getInstance().getTime();
        newPost.script = myDm.script;
        newPost.postID = "@" + String.valueOf(myGroup.allTexts.size()) + "*----*";
        myGroup.allTexts.add(newPost);


    }

    public static void addMemeber(Group myGroup, Person myPerson) {
        myGroup.groupUsers.add(myPerson);
        myPerson.allMyGroap.add(myGroup);
    }

    public static void changeGroupName(Group myGroup, String newName) {
        myGroup.groupName = newName;
    }

    public static void changeGroupId(Group myGroup, String newId) {
        myGroup.groupName = newId;
    }

    public static void removeUser(Group myGroup, Person myPerson) {
        int i, j, ff = 0;
        for (i = 0; i < myGroup.groupUsers.size(); i++) {
            if (myGroup.groupUsers.get(i).userID.equals(myPerson.userID)) {
                myGroup.groupUsers.remove(i);
                for (j = 0; j < myPerson.allMyGroap.size(); j++) {
                    if (myPerson.allMyGroap.get(j).groupId.equals(myGroup.groupId)) {
                        myPerson.allMyGroap.remove(j);
                        ff = 1;
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void bannUser(Group myGroup, Person myPerson) {
        int i, j, ff = 0;
        myGroup.bannedUsers.add(myPerson);
        for (i = 0; i < myGroup.groupUsers.size(); i++) {
            if (myGroup.groupUsers.get(i).userID.equals(myPerson.userID)) {
                myGroup.groupUsers.remove(i);
                for (j = 0; j < myPerson.allMyGroap.size(); j++) {
                    if (myPerson.allMyGroap.get(j).groupId.equals(myGroup.groupId)) {
                        myPerson.allMyGroap.remove(j);
                        ff = 1;
                        break;
                    }
                }
                break;
            }
        }
    }
}
