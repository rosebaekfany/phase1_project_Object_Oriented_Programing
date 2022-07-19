package view;

import media.Person;

public class Show {
    public static void show_account (Person myPerson){
        int i ;
        System.out.println("user name: "+myPerson.name);
        System.out.println("userId: "+myPerson.userID);
        System.out.println("***");
        System.out.println(myPerson.bio);
        System.out.println("posts "+myPerson.posts.size()+" followers "+myPerson.folowers.size()+" followings "+myPerson.folowings.size());

    }
}
