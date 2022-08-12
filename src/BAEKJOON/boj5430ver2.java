package BAEKJOON;
import java.io.*;
import java.util.*;
public class boj5430ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(T>0){
            String input1 = br.readLine();
            char[] order = input1.toCharArray();
            int N = Integer.parseInt(br.readLine());
            Deque<String> dq = new ArrayDeque<>();
            String input = br.readLine();
            input = input.substring(1, input.length()-1);
            if(N != 0){
                st = new StringTokenizer(input, ",");
            }
            else{
                if(input1.contains("D")){
                    sb.append("error\n");
                }else{
                    sb.append("[]\n");
                }
                continue;
            }
            for (int i = 0; i < N; i++) {
                dq.add(st.nextToken());
            }
            boolean r = true;
            boolean isTrue = false;
            for (int i = 0; i < order.length; i++) {
                if(order[i] == 'R'){
                    r = !r;
                }else {
                    if (!dq.isEmpty()) {
                        if (r) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    }else{
                        isTrue = true;
                        break;
                    }
                }
            }
            if(!isTrue){
                sb.append("[");
                if(r){
                    while(dq.size()>1){
                        sb.append(dq.pollFirst() +",");
                    }
                }else{
                    while(dq.size()>1){
                        sb.append(dq.pollLast() + ",");
                    }
                }
                if(dq.size() != 0){
                    sb.append(dq.pollLast() + "]\n");
                }
            }else{
                sb.append("error\n");
            }
            T--;
        }
        System.out.println(sb);
    }
}