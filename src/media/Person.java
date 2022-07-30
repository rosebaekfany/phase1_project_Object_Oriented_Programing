package media;

import controller.Commercial;
import controller.Edit;
import temporary.CommercialGenres;
import view.Input;

import java.util.*;

public class Person {

    public String userType = "public";
    public String userAccountType = new String("General_Account");
    public String selectedPostId = new String();
    public String name = new String();
    public String userID = new String();
    public String userPasswords = new String();
    public String securityQuestion = new String();
    public String bio = new String("");
    public ArrayList<Person> folowers = new ArrayList<>();
    public ArrayList<Person> folowings = new ArrayList<>();
    public ArrayList<Post> likedPhotoes = new ArrayList<>();
    public ArrayList<Post> viewedPosts = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();
    public ArrayList<String> massageRequests = new ArrayList<>();
    public ArrayList<Post> draftPosts = new ArrayList<>();
    public ArrayList<Post> mainPagePost = new ArrayList<>();
    public ArrayList<Post> mainPagePostFinal = new ArrayList<>();
    public ArrayList<Comment> allComment = new ArrayList<>();
    public ArrayList<Chat> allPersonalChats = new ArrayList<>();
    public ArrayList<Group> allMyGroap = new ArrayList<>();
    public CommercialGenres[] favoriteGenres = new CommercialGenres[6];
    public CommercialGenres commercialGenre;

    public boolean equals(Person person) {
        if (this.name.equals(person.name)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Post> getUnLikedCommercialPosts() {
        ArrayList<Post> non_liked_post = new ArrayList<>();
        for (Post viewedPost : this.viewedPosts) {
            if (!likedPhotoes.contains(viewedPost)) {
                non_liked_post.add(viewedPost);
            }
        }
        return non_liked_post;
    }


    public void makeMainPage(ArrayList<BusinessUser> business ) {

        int i, j, h, flag = 0;
        for (i = 0; i < folowings.size(); i++) {
            for (j = 0; j < folowings.get(i).posts.size(); i++) {
                flag = 0;
                for (h = 0; h < mainPagePost.size(); h++) {
                    if (folowings.get(i).posts.get(j).postID.equals(mainPagePost.get(h).postID)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    mainPagePost.add(folowings.get(i).posts.get(j));
                }

            }
        }
        //sort

        Collections.sort(mainPagePost, new sortItems());


        ArrayList<Post> sortedCommercial = new ArrayList<>();
        HashMap<Post , Integer> recommendedPosts = Commercial.recommendedPosts(this , business);
        Map.Entry<Post , Integer> maxPostEntry = null;
        for (int k = 0; k < recommendedPosts.size(); k++) {
            for (Map.Entry<Post, Integer> postIntegerEntry : recommendedPosts.entrySet()) {
                int maxValue = hashMapMax(recommendedPosts);
                if (postIntegerEntry.getValue() == maxValue){
                    //maxPostEntry = postIntegerEntry;
                    sortedCommercial.add(postIntegerEntry.getKey());
                    recommendedPosts.remove(maxPostEntry.getKey());
                    break;
                }
            }
        } // ToDo : check when it removes a value it does not break the loop


        int userPostIndex = 0;
        int commercialIndex = 0;
        while(userPostIndex < mainPagePost.size() || commercialIndex < sortedCommercial.size()){
            for (int k = 0; k < 3; k++) {
                mainPagePostFinal.add(mainPagePost.get(userPostIndex));
                userPostIndex++;
            }
            mainPagePostFinal.add(sortedCommercial.get(commercialIndex));
            commercialIndex++;
        }


    }

    public static <T> int  hashMapMax (HashMap<T , Integer> map){
        int max = 0;
        for (Integer value : map.values()) {
            if (value >= max){
                max = value;
            }
        }
        return max;
    }


}

class sortItems implements Comparator<Post> {
    // @Override

    // Method of this class
    // To compare datetime objects
    public int compare(Post a, Post b) {

        // Returning the value after comparing the objects
        // this will sort the data in Descending order

        return b.postDate.compareTo(a.postDate);
    }
}

