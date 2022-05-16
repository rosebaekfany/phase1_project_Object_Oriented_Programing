package media;

import controller.Edit;
import view.Input;
import java.util.*

public abstract class person {
    Input Input = new Input() ;
    Edit Edit = new Edit() ;
    String userType = new String() ;
    String userAccountType = new String() ;
    String username = new String() ;
    String userID = new String() ;
    String bio = new String() ;
    ArrayList<String> folowers = new ArrayList<>() ;
    ArrayList<String> folowings = new ArrayList<>() ;
    ArrayList<String> likedPhotoes = new ArrayList<>() ;
    public person(String username, String userID, String bio, ArrayList<String> folowers, ArrayList<String> folowings, ArrayList<String> likedPhotoes) {
        this.username = username;
        this.userID = userID;
        this.bio = bio;
        this.folowers = folowers;
        this.folowings = folowings;
        this.likedPhotoes = likedPhotoes;
        this.userType = userType;
        this.userAccountType = userAccountType ;
        this.Input =

    }
    public void changeUsername{
        username= Edit.change() ;
    }
    public String commenting(){
        return Input.getComment() ;
    }
    public String liking(){
        //post goes to ArrayList likedPhotoes
        return Input.getLike() ;
    }
    public void addfollowing(String folowingID ){
        //adding folowingID to ArrayList<String> folowings ;
        //adding userID from folowingID's followers
    }
    public void unfollowing(String folowingID ){
        //remove folowingID to ArrayList<String> folowings ;
        //removing userID from folowingID's followers
    }

}
