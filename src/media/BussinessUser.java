package media;

import java.util.* ;
import controller.* ;
import view.* ;

public class BussinessUser extends Person {
    public String userAccountType = "public";
    public String userPhonenumber = new String();
    //Accounts that you advertise
    public ArrayList<String> advertisingAccount = new ArrayList<>();
    //Accounts that advertise you
    public ArrayList<String> advertisedAccount = new ArrayList<>();


    public void addadvertisingAccount(String folowingID) {
        //adding folowingID to ArrayList<String> advertisingAccount
        //adding userID from folowingID's advertisedAccount
    }

    public void unadvertisingAccount(String folowingID) {
        //remove folowingID to ArrayList<String> advertisingAccount
        //removing userID from folowingID's advertisedAccount
    }
}
