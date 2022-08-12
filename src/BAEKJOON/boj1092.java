package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1092 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> crain = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crain.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crain, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if(crain.get(0)< box.get(0)){ System.out.println(-1);}
        else {
            int sec = 0;
            while (!box.isEmpty()) {
                int idx = 0;
                for (int i = 0; i < crain.size(); i++) {
                    if(idx == box.size()) break;
                    else if(crain.get(i) >= box.get(idx)){ box.remove(idx);}
                    else {idx++; i--;}
                }
                sec++;
            }
            System.out.println(sec);
        }
    }
}
