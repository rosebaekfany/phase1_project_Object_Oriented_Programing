package controller;
import media.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Commercial {

    private <T> double similarityPercentage(ArrayList<T> things1, ArrayList<T> things2) {
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

    // ToDo : An equal methode for person

    public HashMap<Person , Integer> recommendPerson(Person myPerson){
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


    public void commercialPosts(){




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
