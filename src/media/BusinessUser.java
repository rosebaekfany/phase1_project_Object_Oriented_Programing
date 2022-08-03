package media;

import temporary.CommercialGenres;

import java.util.* ;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static temporary.CommercialGenres.*;
import static temporary.CommercialGenres.STOCK_MARKET;

public class BusinessUser extends Person {
    public String userPhoneNumber;
    //Accounts that you advertise
    public ArrayList<String> advertisingAccount = new ArrayList<>();
    //Accounts that advertise you
    public ArrayList<String> advertisedAccount = new ArrayList<>();

    public CommercialGenres postGenre;



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

    public BusinessUser(Person person , String userPhoneNumber , String commercialGenre){
        this(person);
        this.userPhoneNumber = userPhoneNumber;

        if(commercialGenre.equals("ARTS")){
            postGenre = ARTS;
        }
        else if(commercialGenre.equals("FASHION")){
            postGenre = FASHION;
        }
        else if(commercialGenre.equals("HEALTH_AND_CARE")){
            postGenre = HEALTH_AND_CARE;
        }
        else if(commercialGenre.equals("SCIENCE_AND_TECHNOLOGY")){
            postGenre = SCIENCE_AND_TECHNOLOGY;
        }
        else if(commercialGenre.equals("GAMING")){
            postGenre = GAMING;
        }
        else if(commercialGenre.equals("STOCK_MARKET")){
            postGenre = STOCK_MARKET;
        }
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
