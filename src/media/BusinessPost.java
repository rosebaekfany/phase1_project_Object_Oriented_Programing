package media;

import temporary.CommercialGenres;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import static temporary.CommercialGenres.*;

public class BusinessPost extends Post {

    public HashMap<Person, LocalDate> viewed = new HashMap<>();
    public HashMap<Person, LocalDate> liked = new HashMap<>();


    //public CommercialGenres postGenre;

    public BusinessPost() {
        commercialPost = true;

    }

    public ArrayList<Integer> eachDayView() {
        ArrayList<Integer> views = new ArrayList<>();

        int nowYear = LocalDate.now().getYear();
        int nowDay = LocalDate.now().getDayOfYear();
        LocalDate postLocalDate = postDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int postYear = postLocalDate.getYear();
        int postDay = postLocalDate.getDayOfYear();
        int daysPassed = (nowYear - postYear) * 365 + (nowDay - postDay);
        for (int i = 0; i < daysPassed; i++) {
            views.add(0);
        }

        for (LocalDate value : viewed.values()) {
            int passedDaysFromView = (nowYear - value.getYear()) *365 + (nowDay - value.getDayOfYear());
            int viewNum = views.get(passedDaysFromView);
            viewNum++;
            views.set(passedDaysFromView , viewNum);
        }

        return views;
    }


    public ArrayList<Integer> eachDayLike() {
        ArrayList<Integer> likes = new ArrayList<>();

        int nowYear = LocalDate.now().getYear();
        int nowDay = LocalDate.now().getDayOfYear();
        LocalDate postLocalDate = postDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int postYear = postLocalDate.getYear();
        int postDay = postLocalDate.getDayOfYear();
        int daysPassed = (nowYear - postYear) * 365 + (nowDay - postDay);
        for (int i = 0; i < daysPassed; i++) {
            likes.add(0);
        }

        for (LocalDate value : liked.values()) {
            int passedDaysFromView = (nowYear - value.getYear()) *365 + (nowDay - value.getDayOfYear());
            int likeNum = likes.get(passedDaysFromView);
            likeNum++;
            likes.set(passedDaysFromView , likeNum);
        }

        return likes;
    }

}
