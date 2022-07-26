package codeTest;

import java.io.*;
import java.util.*;

public class boj1068 {
    static int N;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = -1;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(input == -1){
                start = i;
                continue;
            }
            list[input].add(i);
        }
        int remove = Integer.parseInt(br.readLine());
        remove(remove);
        if(remove == start){
            System.out.println(0);
        }else{
            Stack<Integer> stack = new Stack();
            stack.add(start);
            int cnt = 0;
            while(!stack.isEmpty()){
                int a = stack.pop();
                if(list[a].size() == 0){
                    cnt++;
                    continue;
                }
                for (int i = 0; i < list[a].size(); i++) {
                    stack.add(list[a].get(i));
                }
            }
            System.out.println(cnt);
        }
    }
    public static void remove(int remove){
        if(list[remove].size() >0){
            int size = list[remove].size();
            while(size>0){
                int child = list[remove].get(--size);
                remove(child);
            }
        }
        for (int i = 0; i < N; i++) {
            if(list[i].contains(remove)){
                for (int j = 0; j < list[i].size(); j++) {
                    if(list[i].get(j) == remove){
                        list[i].remove(j);
                    }
                }
            }
        }
    }
}
