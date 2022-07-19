package codeTest;

import java.io.*;
import java.util.*;
public class boj2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue qu = new LinkedList();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }
        while(true){
            if(qu.size()!= 1){
                qu.remove();
            }
            if(qu.size() ==1){
                System.out.println(qu.peek());
                break;
            }else{
                qu.add(qu.remove());
            }
        }

    }
}
