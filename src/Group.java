import java.util.ArrayList;

public class Group {
    String groupName ;
    ArrayList<User> groupUsers = new ArrayList<>() ;
    ArrayList<Post> posts = new ArrayList<>() ;
    String[] adminID = new String[50] ;
    Group(String groupName , String[] adminID){
        getAdminID();
        this.groupName = groupName ;
    }

    void getAdminID (){
        for (int i=0 ; i<50 ; i++){
            this.adminID[i] = adminID[i] ;
        }
    }

    void getPosts(){

    }

    void addMemeber(){

    }
}
