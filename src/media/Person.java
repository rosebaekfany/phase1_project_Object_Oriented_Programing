package media;

import controller.Edit ;
import view.Input ;
import java.util.* ;

public class Person {

    public String userType = new String() ;
    public String userAccountType = new String() ;
    public String name = new String() ;
    public String userID = new String() ;
    public String userPasswords = new String() ;
    public String securityQuestion = new String() ;
    public String bio = new String() ;
    public ArrayList<String> folowers = new ArrayList<>() ;
    public ArrayList<String> folowings = new ArrayList<>() ;
    public ArrayList<String> likedPhotoes = new ArrayList<>() ;

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

