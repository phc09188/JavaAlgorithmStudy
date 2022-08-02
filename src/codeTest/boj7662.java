package codeTest;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t >0){
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pqDown = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            PriorityQueue<Integer> pqUP = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int i = 0; i < k; i++) {
                String[] operations = br.readLine().split(" ");
                int num = Integer.parseInt(operations[1]);
                switch(operations[0]){
                    case "I":
                        pqUP.offer(num);
                        pqDown.offer(num);
                        break;
                    case "D":
                        if(!pqUP.isEmpty()){
                            if(num == -1){
                                int del = pqUP.poll();
                                pqDown.remove(del);
                            }else{
                                int del = pqDown.poll();
                                pqUP.remove(del);
                            }
                        }
                        break;
                }
            }
            if(pqUP.isEmpty()){
                sb.append("EMPTY\n");
            }else{
                sb.append(pqDown.peek() + " " + pqUP.peek() +"\n");
            }
            t--;
        }
        System.out.println(sb);
    }
}
