package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1253 {
    static List<Integer> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while(true){
                if(left == i) left++;
                else if(right ==i ) right--;
                if(left>=right) break;
                if(list.get(left) + list.get(right) > list.get(i)) right--;
                else if(list.get(left) + list.get(right)<list.get(i)) left++;
                else{
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
