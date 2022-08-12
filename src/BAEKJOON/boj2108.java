package BAEKJOON;

import java.io.*;
import java.util.*;

public class boj2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
            max = Math.max(max, input);
            min = Math.min(min, input);
            sum += input;
            if(mp.containsKey(input)){
                mp.put(input, mp.get(input) + 1);
            }else mp.put(input,1);
        }
        int maxValue = Collections.max(mp.values());
        List<Integer> list2  = new ArrayList<>();
        for (Map.Entry<Integer,Integer> i : mp.entrySet()){
            if(i.getValue() == maxValue){
                list2.add(i.getKey());
            }
        }
        Collections.sort(list2);
        if(list2.size()>1){
            maxValue = list2.get(1);
        }else  maxValue = list2.get(0);
        //산술평균 + 반올림
        if(sum <0){
            sum = 0-sum;
            System.out.println(0-(int)Math.round((double)sum/N));
        }else{
            System.out.println((int)Math.round((double)sum/N));
        }
        // 중앙값
        Collections.sort(list);
        System.out.println(list.get(N/2));
        //최빈값
        System.out.println(maxValue);
        //범위  최댓값 - 최소값
        System.out.println(max - min);
    }
}
