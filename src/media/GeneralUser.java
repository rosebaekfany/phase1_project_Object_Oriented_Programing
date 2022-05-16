package media;

import java.util.ArrayList;

public class GeneralUser extends person {
    public GeneralUser(String username, String userID, String bio, ArrayList<String> folowers, ArrayList<String> folowings, ArrayList<String> likedPhotoes) {
        super(username, userID, bio, folowers, folowings, likedPhotoes);
    }
    userAccountType = Input.getAccountType() ;

}