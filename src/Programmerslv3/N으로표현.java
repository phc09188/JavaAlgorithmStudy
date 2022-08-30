package Programmerslv3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {
    public static int solution(int N, int number) {
        if(number >32000){
            return -1;
        }
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = new HashSet<>();
            for (int j = 1; j < i; j++) {
                Set<Integer> pre = list.get(i-j);
                Set<Integer> post = list.get(j);
                for(int prenumber : pre){
                    for(int postnumber : post){
                        countSet.add(prenumber + postnumber);
                        countSet.add(prenumber - postnumber);
                        countSet.add(prenumber * postnumber);
                        if(prenumber/10 == N && postnumber/10 == N){
                            countSet.add(prenumber* 10 + postnumber);
                        }
                        if(prenumber != 0 && postnumber !=0){
                            countSet.add(prenumber / postnumber);
                        }
                    }
                }
            }
            list.add(countSet);
        }
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> cur = list.get(i);
            if(cur.contains(number)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(solution(5,12));
    }
}
