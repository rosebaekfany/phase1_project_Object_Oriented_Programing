package com.yrtwitter.project_phase2.media;

import com.yrtwitter.project_phase2.gui.*;
import com.yrtwitter.project_phase2.media.*;
import com.yrtwitter.project_phase2.temporary.*;
import com.yrtwitter.project_phase2.view.*;
import com.yrtwitter.project_phase2.controller.*;

import java.util.ArrayList;

public class Chat {
    public ArrayList<Post> allTexts = new ArrayList<>();
    public ArrayList<Comment> allReply = new ArrayList<>();
    public ArrayList<Post> person1Texts = new ArrayList<>();
    public ArrayList<Post> person2Texts = new ArrayList<>();
    public Person person1 = new Person();
    public Person person2 = new Person();
    public String chatId = new String() ;
    public String blockState = new String("");


}
