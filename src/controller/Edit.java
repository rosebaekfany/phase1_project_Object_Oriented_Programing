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

    public static void changePassword(Person myPerson,String newString){
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

    public static void changeBio(Person myPerson,String newString){
        int i ;

        System.out.println("successfull change");
        myPerson.bio=newString ;

    }

    public static void changeAccountType(Person myPerson,String newString){
        int i , flag=0 ;
        if (newString.equals("General_Account")) {
            ;
        }
        else if(newString.equals("Business_Account")){
            ;
        }
        else {
            System.out.println("choose between General_Account or Business_Account");
            flag=1 ;
        }

        if(flag==0){
            System.out.println("successfull change");
            myPerson.userAccountType=newString ;
        }
    }

    public static void changeUserType(Person myPerson,String newString){
        int i , flag=0 ;
        if (newString.equals("public")) {
            ;
        }
        else if(newString.equals("private")){
            ;
        }
        else {
            System.out.println("choose between public or private");
            flag=1 ;
        }

        if(flag==0){
            System.out.println("successfull change");
            myPerson.userType=newString ;
        }
    }

    public static void confirmFollow(RegisterMenu myRegister,Person myPerson,String newString){
        int index , i , ff=0 ;
        index=myPerson.massageRequests.size()-Integer.parseInt(newString) ;
        String[] split ;
        split = myPerson.massageRequests.get(index).split(" ");
        for (i=0 ; i<myRegister.allRegisters.size() ; i++) {
            if (myRegister.allRegisters.get(i).userID.equals(split[0])) {
                myPerson.folowers.add(myRegister.allRegisters.get(i)) ;
                myRegister.allRegisters.get(i).folowings.add(myPerson) ;
                System.out.println("you accepted "+split[0]+"'s request");
                myRegister.allRegisters.get(i).massageRequests.add(myPerson.userID+" accepted your follow request") ;
                ff=1  ;
                break;
            }
        }
        if(ff==0){
            System.out.println("the request is incorrect");
        }


    }



    //and other functions for editing
}