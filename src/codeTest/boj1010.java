package codeTest;

import java.io.*;
import java.util.StringTokenizer;

public class boj1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=  new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long result = 1;
            for (int j = 0; j < n; j++) {
                result *= (m-j);
                result /= (j+1);
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
