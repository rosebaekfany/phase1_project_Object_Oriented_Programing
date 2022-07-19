package view;

import controller.* ;
import media.*;
import java.util.*;
import controller.*;
import view.*;
import java.util.regex.Pattern;

public class Input {
    public Scanner sc = new Scanner(System.in) ;
    public RegisterMenu myRegister = new RegisterMenu() ;
    public String sample = new String() ;


    public int i,j ;
    public int registerMenu=0 ;
    public int registerflag=0 , loginflag=0 , successfulLog=0 , deleteAccountflag=0 , successfulDeleteAccount   ;

    public void backToDefault(){

    }
    public void register_menu(){
        System.out.println("Twitter");
        System.out.println("by yekta and rosa");
        registerMenu=1 ;

    }

    public void inputRegister() {

        sample = sc.nextLine();
        String[] split = new String[3];
        split = sample.split(" ");

        if (split[0].equals("register")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                registerflag = 1;
            }
            else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                registerflag = 1;
            }
            else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        System.out.println("a user exists with this username");
                        registerflag = 1;
                    }
                }
                if (registerflag == 0) {
                    Person newPerson = new Person() ;
                    newPerson.name = split[1];
                    newPerson.userPasswords = split[2];
                    newPerson.securityQuestion= split[3] ;
                    myRegister.allRegisters.add(newPerson);
                    System.out.println("register successful");
                }
            }

        }

        else if (split[0].equals("login")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                loginflag = 1;
            }
            else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                loginflag = 1;
            }
            else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        if (myRegister.allRegisters.get(i).userPasswords.equals(split[2])) {
                            System.out.println("login successful");
                            successfulLog = 1;
                            myRegister.logedInAccount=i ;
                            break;
                        }
                        else {
                            System.out.println("incorrect password");
                            loginflag = 1;
                            break;
                        }
                    }
                }
                if (successfulLog == 0 && loginflag == 0) {
                    System.out.println("no user exists with this username");
                    loginflag = 1;
                }
            }
        }

        else if (split[0].equals("deleteAccount")) {

            if (Pattern.compile("[^A-z0-9_ ]").matcher(split[1]).find()) {
                System.out.println("username format is invalid");
                deleteAccountflag = 1;
            }
            else if (Pattern.compile("[^A-z0-9_ ]").matcher(split[2]).find()) {
                System.out.println("password format is invalid");
                deleteAccountflag = 1;
            }
            else {
                for (i = 0; i < myRegister.allRegisters.size(); i++) {
                    if (myRegister.allRegisters.get(i).name.equals(split[1])) {
                        if (myRegister.allRegisters.get(i).userPasswords.equals(split[2])) {
                            System.out.println("removed " + split[1] + " successfully");
                            successfulDeleteAccount = 1;
                            myRegister.allRegisters.remove(i);
                            deleteAccountflag=0 ;
                            break;
                        } else {
                            System.out.println("incorrect password");
                            deleteAccountflag = 1;
                            break;
                        }
                    }
                }
                if (successfulDeleteAccount == 0 && deleteAccountflag == 0) {
                    System.out.println("no user exists with this username");
                    deleteAccountflag = 1;
                }
            }
        }

        else if (sample.equals("exitApp")){
            registerMenu=0 ;
            System.out.println("program ended");
        }

        else if (sample.equals("forget password")){
            System.out.println("[user name] [your favorite flower's name] [new password]");
            for(i=0 ; i<myRegister.allRegisters.size() ; i++){
                if(myRegister.allRegisters.get(i).name.equals(split[0])){
                    if(myRegister.allRegisters.get(i).securityQuestion.equals(split[1])){
                        System.out.println("password is changed");
                        myRegister.allRegisters.get(i).userPasswords=split[2] ;
                    }
                }
            }
        }

        else if(sample.equals("help") && registerMenu==1){
            System.out.println("register [user_name] [password] [your favorite flower's name] \n" +
                    "login [user_name] [password] \n" +
                    "deleteAccount [user_name] [password] \n" +
                    "exitApp \n" +
                    "forget password");
        }




    }






}
