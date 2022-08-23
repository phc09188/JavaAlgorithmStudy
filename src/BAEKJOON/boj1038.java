package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1038 {
    static List<Long> list;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
            최대가 되는 감소하는 수 : 9876543210
            해당 수는 1022번째 값이다.
         */
        if(n >1022){
            System.out.println(-1);

        }else {
            list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                solution(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }
    public static void solution(long num, int len){
        if(len >10){
            return;
        }
        list.add(num);
        for (int i = 0; i < 10; ++i) {
            if(num%10 >i){
                solution((num*10)+i, len+1);
            }
        }
    }
}
