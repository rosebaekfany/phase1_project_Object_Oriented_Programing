package media;

import controller.Edit;
import temporary.CommercialGenres;
import view.Input;

import java.util.*;

public class Person {

    public String userType = "public";
    public String userAccountType = new String("General_Account");
    public String name = new String();
    public String userID = new String();
    public String userPasswords = new String();
    public String securityQuestion = new String();
    public String bio = new String("");
    public ArrayList<Person> folowers = new ArrayList<>();
    public ArrayList<Person> folowings = new ArrayList<>();
    public ArrayList<Post> likedPhotoes = new ArrayList<>();
    public ArrayList<Post> viewedPosts = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();
    public ArrayList<String> massageRequests = new ArrayList<>();
    public ArrayList<Post> draftPosts = new ArrayList<>();

    public CommercialGenres[] favoriteGenres = new CommercialGenres[6];

    public boolean equals(Person person){
        if (this.name.equals(person.name)){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Post> getUnLikedCommercialPosts(){
        ArrayList<Post> non_liked_post = new ArrayList<>();
        for (Post viewedPost : this.viewedPosts) {
            if (!likedPhotoes.contains(viewedPost)) {
               non_liked_post.add(viewedPost);
            }
        }
        return non_liked_post;
    }

    /*public void changeUsername{
        name= Edit.change() ;
    }
    public String commenting(){
        return Input.getComment() ;
    }
    public String liking(){
        //post goes to ArrayList likedPhotoes
        return Input.getLike() ;
    }*/


}

