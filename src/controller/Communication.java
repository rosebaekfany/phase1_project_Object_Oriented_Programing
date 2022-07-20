package controller;

import view.*;
import media.*;

public class Communication {

    public static void followSb(RegisterMenu myRegester, Person myPerson, String id) {
        int i, flag = 0;
        for (i = 0; i < myRegester.allRegisters.size(); i++) {
            if (myRegester.allRegisters.get(i).userID.equals(id)) {
                if (myRegester.allRegisters.get(i).userType.equals("private")) {
                    myRegester.allRegisters.get(i).massageRequests.add(myPerson.userID + " wants to follow you!");
                    System.out.println("you have requested " + id + " to follow you");
                } else {
                    myRegester.allRegisters.get(i).folowers.add(myPerson);
                    myPerson.folowings.add(myRegester.allRegisters.get(i));
                    System.out.println(id + " is now added to your followings");
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void unfollowSb(RegisterMenu myRegester, Person myPerson, String id) {
        int i, j, h, flag = 0;
        for (i = 0; i < myRegester.allRegisters.size(); i++) {
            if (myRegester.allRegisters.get(i).userID.equals(id)) {
                for (j = 0; j < myRegester.allRegisters.get(i).folowers.size(); j++) {
                    if (myRegester.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)) {
                        myRegester.allRegisters.get(i).folowers.remove(j);
                        for (h = 0; h < myPerson.folowings.size(); h++) {
                            if (myPerson.folowings.get(h).equals(myRegester.allRegisters.get(i).userID)) {
                                myPerson.folowings.remove(h);
                                System.out.println("you no longer follow " + myRegester.allRegisters.get(i).userID);
                                break;
                            }
                        }
                        break;
                    }
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void removeFollower(RegisterMenu myRegester, Person myPerson, String id) {
        int i, flag = 0;
        for (i = 0; i < myPerson.folowers.size(); i++) {
            if (myPerson.folowers.get(i).userID.equals(id)) {
                System.out.println(id + " is removed from your folowers");
                myPerson.folowers.remove(i);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("the userId is incorrect");
        }
    }

    public static void blockSb(RegisterMenu myRegister, Person myPerson, String id) {
        ;
    }


}
