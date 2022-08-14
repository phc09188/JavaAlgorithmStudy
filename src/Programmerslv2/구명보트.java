package Programmerslv2;

import java.util.*;
public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int a = 0; int b = people.length-1; int cnt =0;
        Arrays.sort(people);
        while(a<b){
            if(people[b] + people[a] <= limit){
                a++; cnt++;
            }
            b--;
        }
        return people.length-cnt;
    }
    public static void main(String[] args){
        int[] people1 = {70,50,80,50};
        int[] people2 = {70,80,50};
        System.out.println(solution(people1,100));
        System.out.println(solution(people2, 100));
    }
}
