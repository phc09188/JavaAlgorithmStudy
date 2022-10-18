package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1744 {
    static List<Integer> plus;
    static List<Integer> minus;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input >0) plus.add(input);
            else minus.add(input);
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);
        int sum = 0;
        int i =0;
        while(i< plus.size()){
            if(i+1 < plus.size() && plus.get(i) != 1 && plus.get(i+1) != 1){
                sum += plus.get(i++) * plus.get(i++);
            }else{
                sum += plus.get(i++);
            }
        }
        i = 0;
        while(i<minus.size()){
            if(i+1 < minus.size() && minus.get(i) !=1 && minus.get(i) !=1){
                sum += minus.get(i++) * minus.get(i++);
            }else{
                sum += minus.get(i++);
            }
        }
        System.out.println(sum);
    }
}
