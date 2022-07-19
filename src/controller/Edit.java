package controller;
import view.* ;
import media.* ;

import java.util.regex.Pattern;

public class Edit {

    public static void changeUsername(RegisterMenu myRegister,Person myPerson,String newString){
        int i , flag=0 ;
        if (Pattern.compile("[^A-z0-9_ ]").matcher(newString).find()) {
            System.out.println("username format is invalid");
            flag=1 ;
        }
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).name.equals(newString) ){
                if(flag==0) {
                    System.out.println("a user exists with this username");
                    flag=1 ;
                }
            }
        }
        if(flag==0){
            System.out.println("successfull change");
            myPerson.name=newString ;
        }

    }

    public static void changePassword(RegisterMenu myRegister,Person myPerson,String newString){
        int i , flag=0 ;
        if (Pattern.compile("[^A-z0-9_ ]").matcher(newString).find()) {
            System.out.println("password format is invalid");
            flag=1 ;
        }
        if(flag==0){
            System.out.println("successfull change");
            myPerson.userPasswords=newString ;
        }
    }

    public static void changeUserId(RegisterMenu myRegister,Person myPerson,String newString){
        int i , flag=0 ;
        if (newString.charAt(0)!='@') {
            System.out.println("@ should be at first");
            flag=1 ;
        }
        for (i = 0; i < myRegister.allRegisters.size(); i++) {
            if (myRegister.allRegisters.get(i).userID.equals(newString)) {
                if(flag==0) {
                    System.out.println("a user exists with this Id");
                    flag=1 ;
                }
            }
        }
        if(flag==0){
            System.out.println("successfull change");
            myPerson.userID=newString ;
        }
    }

    public static void changeBio(RegisterMenu myRegister,Person myPerson,String newString){
        int i ;

        System.out.println("successfull change");
        myPerson.bio=newString ;

    }

    public static void changeAccountType(RegisterMenu myRegister,Person myPerson,String newString){
        int i , flag=0 ;
        if (newString!="General_Account" && newString!="Business_Account") {
            System.out.println("choose between General_Account or Business_Account");
            flag=1 ;
        }

        if(flag==0){
            System.out.println("successfull change");
            myPerson.userAccountType=newString ;
        }
    }


    //and other functions for editing
}