package media;

import controller.*;
import view.*;

import java.util.ArrayList;

public class Chat {
    public ArrayList<Post> allTexts = new ArrayList<>();
    public ArrayList<Comment> allReply = new ArrayList<>();
    public ArrayList<Post> person1Texts = new ArrayList<>();
    public ArrayList<Post> person2Texts = new ArrayList<>();
    public Person person1 = new Person();
    public Person person2 = new Person();
    public String blockState = new String("");


}
