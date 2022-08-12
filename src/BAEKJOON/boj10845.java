package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> qu = new LinkedList();
        int first =0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            String name = "";
            int num =-1;
            if(a.length == 1){
                name = a[0];
            }else if(a.length ==2){
                name = a[0];
                num = Integer.parseInt(a[1]);
            }
            if(name.equals("push")){
                qu.offer(num);
                first = num;
            }else if(name.equals("pop")){
                if(qu.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(qu.peek() + "\n");
                    qu.remove();
                }
            }else if(name.equals("size")){
                sb.append(qu.size() + "\n");
            }else if(name.equals("empty")){
                if(qu.isEmpty()){
                    sb.append(1+ "\n");
                }else{
                    sb.append(0+ "\n");
                }
            }else if(name.equals("front")){
                if(qu.isEmpty()){
                    sb.append(-1+ "\n");
                }else{
                    sb.append(qu.peek() + "\n");
                }
            }else if(name.equals("back")){
                if(qu.isEmpty()){
                    sb.append(-1 + "\n");
                }else {
                    sb.append(first + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
