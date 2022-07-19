package media;

import controller.Edit ;
import view.Input ;
import java.util.* ;

public class Person {

    public String userType = "public" ;
    public String userAccountType = new String("General_Account") ;
    public String name = new String() ;
    public String userID = new String() ;
    public String userPasswords = new String() ;
    public String securityQuestion = new String() ;
    public String bio = new String("") ;
    public ArrayList<Person> folowers = new ArrayList<>() ;
    public ArrayList<Person> folowings = new ArrayList<>() ;
    public ArrayList<Post> likedPhotoes = new ArrayList<>() ;
    public ArrayList<Post> posts = new ArrayList<>() ;
    public ArrayList<String> massageRequests = new ArrayList<>() ;

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
    public void addfollowing(String folowingID ){
        //adding folowingID to ArrayList<String> folowings ;
        //adding userID from folowingID's followers
    }
    public void unfollowing(String folowingID ){
        //remove folowingID to ArrayList<String> folowings ;
        //removing userID from folowingID's followers
    }

}

