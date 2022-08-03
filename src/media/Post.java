package media;

import java.util.*;

import temporary.*;


public class Post {
    public String script = new String();

    public boolean commercialPost = false;
    public Emoji emoji = new Emoji();
    public Media media = new Media();
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

    public static void writePost(RegisterMenu myRegister, String text) {
        Post newPost = new Post();
        newPost.script = text;
        Date postDate = new Date();
        newPost.postDate = Calendar.getInstance().getTime();
        newPost.postID = "@" + String.valueOf(myRegister.allRegisters.get(myRegister.logedInAccount).posts.size()) + String.valueOf(Calendar.getInstance().getTime().getTime()) + "*****";
        newPost.usersPostId = myRegister.allRegisters.get(myRegister.logedInAccount).userID;
        myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.add(newPost);
    }

    public static void post(RegisterMenu myRegister) {
        int i ;
        myRegister.allRegisters.get(myRegister.logedInAccount).posts.add(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1));
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