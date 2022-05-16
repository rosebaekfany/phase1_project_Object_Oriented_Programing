package view;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in) ;
    public String getAccountType(){
        return scanner.next() ;
    }
    public String getComment(){
        return scanner.next() ;
    }
    public String getLike(){
        return scanner.next() ;
    }


}
