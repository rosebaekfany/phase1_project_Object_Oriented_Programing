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

    public static void show_userProfile(RegisterMenu myRegister , Person myPerson , String id){
        int i ,j , flag=0 , ff=0;
        for(i=0 ; i<myRegister.allRegisters.size() ; i++){
            if(myRegister.allRegisters.get(i).userID.equals(id)){
                if(myRegister.allRegisters.get(i).userType.equals("private")){
                    for(j=0 ; j<myRegister.allRegisters.get(i).folowers.size() ; j++){
                        if(myRegister.allRegisters.get(i).folowers.get(j).userID.equals(myPerson.userID)){
                            flag=1 ;
                            break;
                        }
                    }
                }
                else{
                    flag=1 ;
                }
                ff=1 ;
                break ;
            }
        }
        if(flag==1){
            System.out.println("user name: "+myRegister.allRegisters.get(i).name);
            System.out.println("userId: "+myRegister.allRegisters.get(i).userID);
            System.out.println("***");
            System.out.println(myRegister.allRegisters.get(i).bio);
            System.out.println("posts "+myRegister.allRegisters.get(i).posts.size()+" followers "+myRegister.allRegisters.get(i).folowers.size()+" followings "+myRegister.allRegisters.get(i).folowings.size());

        }
        else if(ff==0){
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userFollowerList(RegisterMenu myRegister , String id){
        int i , j , ff=0;
        for(i=0 ; i<myRegister.allRegisters.size() ; i++){
            if(myRegister.allRegisters.get(i).userID.equals(id)){
                for(j=0 ; j<myRegister.allRegisters.get(i).folowers.size() ; j++){
                    System.out.println(myRegister.allRegisters.get(i).folowers.get(j).name+"   userId: "+myRegister.allRegisters.get(i).folowers.get(j).userID+"   user Type: "+myRegister.allRegisters.get(i).folowers.get(j).userAccountType);
                }
                ff=1 ;
                break;
            }
        }
        if(ff==0){
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userFollowingList(RegisterMenu myRegister , String id){
        int i , j , ff=0 ;
        for(i=0 ; i<myRegister.allRegisters.size() ; i++){
            if(myRegister.allRegisters.get(i).userID.equals(id)){
                for(j=0 ; j<myRegister.allRegisters.get(i).folowings.size() ; j++){
                    System.out.println(myRegister.allRegisters.get(i).folowings.get(j).name+"   userId: "+myRegister.allRegisters.get(i).folowings.get(j).userID+"   user Type: "+myRegister.allRegisters.get(i).folowings.get(j).userAccountType);
                }
                ff=1 ;
                break;
            }
        }
        if(ff==0){
            System.out.println("the userId is incorrect");
        }
    }

    public static void show_userRequsts(Person myPerson){
        int i ;
        for(i=myPerson.massageRequests.size()-1 ; i>=0 ; i--){
            System.out.println(myPerson.massageRequests.get(i));
        }
    }
}
