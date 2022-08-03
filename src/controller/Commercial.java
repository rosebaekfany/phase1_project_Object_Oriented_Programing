package controller;

import media.BusinessPost;
import media.BusinessUser;
import media.Person;
import media.Post;
import temporary.CommercialGenres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commercial {

    private static <T> double similarityPercentage(ArrayList<T> things1, ArrayList<T> things2) {
        double similarityPercentage = 0;
        int similarThings = 0;
        for (T t1 : things1) {
            for (T t2 : things2) {
                if (t1.equals(t2)) {
                    similarThings++;
                }
            }
        }
        similarityPercentage = (double)similarThings / (double) things1.size();
        return similarityPercentage;
    }

    public static HashMap<Person , Integer> recommendPerson(Person myPerson){
        //make followings of myPerson's followings list
        ArrayList<Person> followingsOfFollowings = new ArrayList<>();
        for (Person folowing : myPerson.folowings) {
            followingsOfFollowings.addAll(folowing.folowings);
        }
        //determine how important is each friend
        HashMap<Person , Integer> similarFriends = new HashMap<>();
        Person p;
        for (int i = 0; i < followingsOfFollowings.size(); i++) {
            p = followingsOfFollowings.get(i);
            for (int j = 0; j < i; j++) {
                if (p.equals(followingsOfFollowings.get(j))){
                    int recentValue = similarFriends.get(p);
                    recentValue++;
                    similarFriends.replace(p,recentValue);
                } else {
                    similarFriends.put(p , 0);
                }
            }
        }
        return similarFriends;
    }



    public static ArrayList<Person> sortSuggestedPerson(Person myPerson){
        HashMap<Person , Integer> suggestMap = recommendPerson(myPerson);
        ArrayList<Person> sortedPeople = new ArrayList<>();

        for (int k = 0; k < suggestMap.size(); k++) {
            for (Map.Entry<Person, Integer> postIntegerEntry : suggestMap.entrySet()) {
                int maxValue = Person.hashMapMax(suggestMap);
                if (postIntegerEntry.getValue() == maxValue){
                    //maxPostEntry = postIntegerEntry;
                    sortedPeople.add(postIntegerEntry.getKey());
                    suggestMap.remove(postIntegerEntry.getKey());
                    break;
                }
            }
        } // ToDo : check when it removes a value it does not break the loop

        return sortedPeople;
    }



    public static HashMap<Post, Integer> recommendedPosts(Person myPerson, ArrayList<BusinessUser> businesses) {

        HashMap<Post, Integer> recommendation = new HashMap<>();

        // setting non-viewed posts in the recommendation-map
        for (BusinessUser business : businesses) {
            for (Post post : business.posts) {
                for (Post viewedPost : myPerson.viewedPosts) {
                    if (viewedPost.postID.equals(post.postID)) {
                        break;
                    } else {
                        recommendation.put(post, 0);
                    }
                }
            }
        }

        // setting non-liked posts
        ArrayList<Post> non_liked_post = myPerson.getUnLikedCommercialPosts();

        // setting recommendation-map based on liked-people
        for (Post likedPhotoe : myPerson.likedPhotoes) {
            for (Person likedUser : likedPhotoe.likedUsers) {
                for (Post photoe : likedUser.likedPhotoes) {
                    if (recommendation.containsKey(photoe)) {
                        try {
                            int rate = recommendation.get(photoe);
                            rate++;
                            recommendation.replace(photoe, rate);
                        } catch (Exception e) {
                            break;
                        }
                    }
                }
            }
        }

        // setting recommendation-map based on unliked-people
        for (Post myPerson_non_liked_post : non_liked_post) {
            for (Person unlikedUser : myPerson_non_liked_post.getUnlikedUsers()) {
                for (Post unLikedCommercialPost : unlikedUser.getUnLikedCommercialPosts()) {
                    try {
                        int rate = recommendation.get(unLikedCommercialPost);
                        rate++;
                        recommendation.replace(unLikedCommercialPost, rate);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        }

        // setting recommendation-map based on favorite categories
        for (Post post : recommendation.keySet()) {
            int coef = 1;
            CommercialGenres postGenre1 = findUser(post.usersPostId, businesses).postGenre;
            for (int i = 0; i < 6; i++) {
                if (postGenre1.equals(myPerson.favoriteGenres[i])) {
                    coef = 6 - i;
                    break;
                }
            }
            int preRate = recommendation.get(post);
            int rate = coef*preRate;
            recommendation.replace(post , rate);
        }

        return recommendation;
    }


    public static BusinessUser findUser(String id , ArrayList<BusinessUser> users){
        for (BusinessUser user : users) {
            if (user.userID.equals(id)){
                return user;
            }
        }
        return null;
    }

    /*public List<Person> recommendPerson(Person myPerson , Person otherPerson){
        List<Person> recommendedPerson = new ArrayList<>();
        for (Person folowing : myPerson.folowings) {
            recommendedPerson.addAll(similarFollowings(folowing , otherPerson));
        }
        for (int i = 0; i < recommendedPerson.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (recommendedPerson.get(i).equals(recommendedPerson.get(j))){
                    recommendedPerson.remove(i);
                    i--;
                    break;
                }
            }
        }
        return recommendedPerson;
    }

    private List<Person> similarFollowings(Person friendPerson , Person otherPerson){
        List<Person> similarFollowings = new ArrayList<>();
        for (Person folowing : friendPerson.folowings) {
            for (Person person : otherPerson.folowings) {
                if (person.equals(folowing)){
                    similarFollowings.add(person);
                    break;
                }
            }
        }
        return similarFollowings;
    }*/



}
