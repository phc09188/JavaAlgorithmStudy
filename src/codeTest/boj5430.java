package codeTest;

import java.io.*;
import java.util.*;
public class boj5430 {
    static Deque<Integer> dq;
    public static Deque<Integer> reverse(){
        Deque<Integer> result = new ArrayDeque<>();
        int N = dq.size();
        for (int i = 0; i < N; i++) {
            result.addLast(dq.pollLast());
        }
        return result;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T >0){
            boolean isTrue = true;
            char[] order = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            dq = new ArrayDeque<>();
            char[] num = br.readLine().toCharArray();
            int ten = 0;
            boolean a = true;
            if(N == 0){
                isTrue = false;
            }else {
                for (int i = 0; i < num.length; i++) {
                    if (num[i] >= 48 && num[i] <= 57) {
                        if (i != num.length - 1 && num[i + 1] >= 48 && num[i + 1] <= 57) {
                            ten += num[i] - 48;
                            ten *= 10;
                            a = false;
                        } else if (!a) {
                            ten += num[i] - 48;
                            dq.addLast(ten);
                            ten = 0;
                            a = true;
                        } else {
                            dq.addLast(num[i] - 48);
                            ten = 0;
                        }
                    }
                }
                for (int i = 0; i < order.length; i++) {
                    if (order[i] == 'R' && order[i + 1] == 'R' && i != order.length - 1) {
                        i +=1;
                    } else if (order[i] == 'R' && order[i + 1] != 'R' && i != order.length - 1) {
                        dq = reverse();
                    }
                    if (order[i] == 'D') {
                        if (dq.isEmpty()) {
                            isTrue = false;
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }
            if(isTrue && !dq.isEmpty()){
                sb.append("[");
                int cnt = dq.size();
                for (int i = 0; i < cnt-1; i++) {
                    sb.append(dq.pollFirst() + ",");
                }
                sb.append(dq.pollFirst() + "]\n");
            }else{
                sb.append("error" +"\n");
            }
            T--;
        }
        System.out.println(sb);
    }
}
