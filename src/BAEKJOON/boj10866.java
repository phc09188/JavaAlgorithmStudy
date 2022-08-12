package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque deque = new ArrayDeque();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(cnt <n){
            String[] input = br.readLine().split(" ");
            String name =input[0];
            int num = 0;
            if(input.length >1){
                num = Integer.parseInt(input[1]);
            }
            if(name.equals("push_front")){
                deque.addFirst(num);
            }else if(name.equals("push_back")){
                deque.addLast(num);
            }else if(name.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(deque.pollFirst() +"\n");
                }
            }else if(name.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(deque.pollLast() +"\n");
                }
            }else if(name.equals("size")){
                sb.append(deque.size() + "\n");
            }else if(name.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1 +"\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else if(name.equals("front")){
                if(deque.isEmpty()){
                    sb.append(-1 +"\n");
                }else{
                    sb.append(deque.peek() +"\n");
                }
            }else if(name.equals("back")){
                if(deque.isEmpty()){
                    sb.append(-1 +"\n");
                }else{
                    sb.append(deque.peekLast() + "\n");
                }
            }
            cnt++;
        }
        System.out.println(sb);
    }
}
