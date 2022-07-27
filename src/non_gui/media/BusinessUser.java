package non_gui.media;

import java.util.* ;

public class BusinessUser extends Person {
    public String userPhoneNumber;
    //Accounts that you advertise
    public ArrayList<String> advertisingAccount = new ArrayList<>();
    //Accounts that advertise you
    public ArrayList<String> advertisedAccount = new ArrayList<>();

    public BusinessUser(Person person){
        this.userID = person.userID;
        this.userPasswords = person.userPasswords;
        this.bio = person.bio;
        this.name = person.name;
        this.securityQuestion = person.securityQuestion;
        this.folowers = person.folowers;
        this.folowings = person.folowings;
        this.userType = "public";
        this.likedPhotoes = person.likedPhotoes;
        this.massageRequests = person.massageRequests;
        this.posts = person.posts;
    }

    public BusinessUser(Person person , String userPhoneNumber){
        this(person);
        this.userPhoneNumber = userPhoneNumber;
    }
    public void addAdvertisingAccount(String followingID) {
        //adding folowingID to ArrayList<String> advertisingAccount
        //adding userID from folowingID's advertisedAccount
    }

    public void unAdvertisingAccount(String followingID) {
        //remove folowingID to ArrayList<String> advertisingAccount
        //removing userID from folowingID's advertisedAccount
    }
}
