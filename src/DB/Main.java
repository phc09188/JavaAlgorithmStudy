package DB;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        MemberService test = new MemberService();
        //test.DBInsert();
        //test.DBUpdate();
        //test.DBDelete();

        test.register();
    }
}