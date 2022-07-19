package controller;
import view.* ;
import media.* ;

public class Communication {

    public static void followSb(RegisterMenu myRegester , Person myPerson ,String id){
        int i ;
        for (i=0 ; i<myRegester.allRegisters.size() ; i++){
            if(myRegester.allRegisters.get(i).userID.equals(id)){
                myRegester.allRegisters.get(i).folowers.add(myPerson) ;
                myPerson.folowings.add(myRegester.allRegisters.get(i)) ;
                System.out.println(id+" is now added to your followings");
                break;
            }
        }
        if(i==myRegester.allRegisters.size()-1){
            System.out.println("the userId is incorrect");
        }
    }

    public static void unfollowSb(RegisterMenu myRegester , Person myPerson ,String id){
        int i ,j ,h ;
        for (i=0 ; i<myRegester.allRegisters.size() ; i++){
            if(myRegester.allRegisters.get(i).userID.equals(id)){
                for (j=0 ; j<myRegester.allRegisters.get(i).folowers.size() ; j++){
                    if(myRegester.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)){
                        myRegester.allRegisters.get(i).folowers.remove(j) ;
                        for (h=0 ; h<myPerson.folowings.size() ; h++) {
                            if(myPerson.folowings.get(h).equals(myRegester.allRegisters.get(i).userID)){
                                myPerson.folowings.remove(h) ;
                                System.out.println("you no longer follow "+myRegester.allRegisters.get(i).userID);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        if(i==myRegester.allRegisters.size()-1){
            System.out.println("the userId is incorrect");
        }
    }

}
