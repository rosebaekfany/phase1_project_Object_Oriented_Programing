package media;

import java.util.*;
import controller.*;
import temporary.* ;
import view.* ;

public class Group {
    public String groupName = new String() ;
    public Person admin = new Person() ;
    public ArrayList<Person> groupUsers = new ArrayList<>() ;
    public ArrayList<Person> bannedUsers = new ArrayList<>() ;
    public ArrayList<Post> allTexts = new ArrayList<>() ;
    //String[] adminID = new String[50] ;
    public String groupId = new String() ;

    public static void creatGroup(Person myPerson , String groupName){
        Group newGroup = new Group() ;
        newGroup.groupName=groupName;
        newGroup.groupId="@"+String.valueOf(myPerson.allMyGroap.size())+"**__**" ;
        newGroup.groupUsers.add(myPerson) ;
        newGroup.admin=myPerson ;
        myPerson.allMyGroap.add(newGroup) ;
    }

    public static void getPosts(){

    }

    public static void addMemeber(){

    }
}
