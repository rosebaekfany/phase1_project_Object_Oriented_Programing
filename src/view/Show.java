package view;

import media.Person;
import media.RegisterMenu;

public class Show {
    public static void show_account (Person myPerson){
        int i ;
        System.out.println("user name: "+myPerson.name);
        System.out.println("userId: "+myPerson.userID);
        System.out.println("***");
        System.out.println(myPerson.bio);
        System.out.println("posts "+myPerson.posts.size()+" followers "+myPerson.folowers.size()+" followings "+myPerson.folowings.size());

    }

    public static void show_allProfiles(RegisterMenu myRegester){
        int i ;
        for(i=0 ; i<myRegester.allRegisters.size() ; i++){
            System.out.println(myRegester.allRegisters.get(i).name+"   userId: "+myRegester.allRegisters.get(i).userID+"   user Type: "+myRegester.allRegisters.get(i).userAccountType);
        }
    }

    public static void show_userProfile(RegisterMenu myRegister , String id){
        int i ;
        for(i=0 ; i<myRegister.allRegisters.size() ; i++){
            if(myRegister.allRegisters.get(i).userID.equals(id)){
                System.out.println("user name: "+myRegister.allRegisters.get(i).name);
                System.out.println("userId: "+myRegister.allRegisters.get(i).userID);
                System.out.println("***");
                System.out.println(myRegister.allRegisters.get(i).bio);
                System.out.println("posts "+myRegister.allRegisters.get(i).posts.size()+" followers "+myRegister.allRegisters.get(i).folowers.size()+" followings "+myRegister.allRegisters.get(i).folowings.size());
                break ;
            }
        }
        if(i==myRegister.allRegisters.size()-1){
            System.out.println("the userId is incorrect");
        }
    }
}
