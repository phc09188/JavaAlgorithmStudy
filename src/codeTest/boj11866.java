package codeTest;

import java.io.*;
import java.util.*;
public class boj11866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue qu = new LinkedList();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }
        sb.append("<");
        while(!qu.isEmpty()){
            if(qu.size() ==1){
                sb.append(qu.poll() + ">");
            }else{
                for (int i = 0; i < k-1; i++) {
                    qu.add(qu.remove());
                }
                sb.append(qu.poll() + ", ");
            }
        }
        System.out.println(sb);
    }
}
