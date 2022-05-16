package media;

import java.util.*

public class BussinesUser extends person {
    userAccountType = "public" ;
    String userPhonenumber = new String() ;
    //Accounts that you advertise
    ArrayList<String> advertisingAccount = new ArrayList<>() ;
    //Accounts that advertise you
    ArrayList<String> advertisedAccount = new ArrayList<>() ;

    public BussinesUser(String userPhonenumber, ArrayList<String> advertisingAccount, ArrayList<String> advertisedAccount) {
        this.userPhonenumber = userPhonenumber;
        this.advertisingAccount = advertisingAccount;
        this.advertisedAccount = advertisedAccount;
    }

    public BussinesUser(String username, String userID, String bio, ArrayList<String> folowers, ArrayList<String> folowings, ArrayList<String> likedPhotoes, String userPhonenumber, ArrayList<String> advertisingAccount, ArrayList<String> advertisedAccount) {
        super(username, userID, bio, folowers, folowings, likedPhotoes);
        this.userPhonenumber = userPhonenumber;
        this.advertisingAccount = advertisingAccount;
        this.advertisedAccount = advertisedAccount;
    }

    public void addadvertisingAccount(String folowingID ){
        //adding folowingID to ArrayList<String> advertisingAccount
        //adding userID from folowingID's advertisedAccount
    }
    public void unadvertisingAccount(String folowingID ){
        //remove folowingID to ArrayList<String> advertisingAccount
        //removing userID from folowingID's advertisedAccount
    }
