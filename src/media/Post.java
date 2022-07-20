package media;

import java.util.*;

import temporary.*;


public class Post {
    public String script = new String();
    public Emoji emoji = new Emoji();
    public Media media = new Media();
    public String postID = new String();
    public String usersPostId = new String() ;
    public ArrayList<Person> likedUsers = new ArrayList<>();
    public ArrayList<Comment> postComments = new ArrayList<>();
    public Date postDate = new Date();
    public String edited = new String("") ;

    void putMedia() {

    }

    public static void writePost(RegisterMenu myRegister, String text) {
        Post newPost = new Post();
        newPost.script = text;
        Date postDate = new Date();
        newPost.postDate = Calendar.getInstance().getTime();
        newPost.postID = "@" + String.valueOf(myRegister.allRegisters.get(myRegister.logedInAccount).posts.size()) + "***";
        newPost.usersPostId=myRegister.allRegisters.get(myRegister.logedInAccount).userID ;
        myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.add(newPost);
    }

    public static void post(RegisterMenu myRegister) {
        myRegister.allRegisters.get(myRegister.logedInAccount).posts.add(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.get(myRegister.allRegisters.get(myRegister.logedInAccount).draftPosts.size() - 1));
    }

    public static void editPost(Post myPost , String myString ) {
        myPost.script=myString ;
    }
}