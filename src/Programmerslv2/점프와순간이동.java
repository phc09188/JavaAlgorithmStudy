package Programmerslv2;

import java.io.*;
import java.util.*;
public class 점프와순간이동 {
    public static int solution(int n) {
        int ans = 0;
        while(n>0){
            if(n %2 == 0){
                n = n/2;
            }else{
                n = n-1;
                ans +=1;
            }
        }
        return ans;
    }
    public static void main(String[] args){

    }
}
