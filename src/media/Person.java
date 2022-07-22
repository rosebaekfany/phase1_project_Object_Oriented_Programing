package media;

import controller.Edit;
import view.Input;

import java.util.*;

public class Person {

    public String userType = "public";
    public String userAccountType = new String("General_Account");
    public String selectedPostId = new String() ;
    public String name = new String();
    public String userID = new String();
    public String userPasswords = new String();
    public String securityQuestion = new String();
    public String bio = new String("");
    public ArrayList<Person> folowers = new ArrayList<>();
    public ArrayList<Person> folowings = new ArrayList<>();
    public ArrayList<Post> likedPhotoes = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();
    public ArrayList<String> massageRequests = new ArrayList<>();
    public ArrayList<Post> draftPosts = new ArrayList<>();
    public ArrayList<Post> mainPagePost = new ArrayList<>() ;
    public ArrayList<Comment> allComment = new ArrayList<>() ;


    public void makeMainPage(){
        int i , j  , h , flag =0 ;
        for(i=0 ; i<folowings.size() ; i++ ){
            for(j=0 ; j<folowings.get(i).posts.size() ; i++){
                flag =0 ;
                for(h=0 ; h<mainPagePost.size() ; h++){
                    if(folowings.get(i).posts.get(j).postID.equals(mainPagePost.get(h).postID)){
                        flag=1 ;
                        break;
                    }
                }
                if (flag==0){
                    mainPagePost.add(folowings.get(i).posts.get(j)) ;
                }

            }
        }
        //sort
    }
    /*public void changeUsername{
        name= Edit.change() ;
    }
    public String commenting(){
        return Input.getComment() ;
    }
    public String liking(){
        //post goes to ArrayList likedPhotoes
        return Input.getLike() ;
    }*/


}

