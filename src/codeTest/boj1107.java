package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isBroken = new boolean[10];
        if(m != 0){
            st=  new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            isBroken[a] = true;
        }
        if(n==100){
            System.out.println(0);
            return;
        }
        int ans = Math.abs(n-100);
        for (int i = 1; i <= 1000000; i++) {
            String str = String.valueOf(i);
            boolean isPossible = true;

            for (int j = 0; j < str.length(); j++) {
                int bt = str.charAt(j) -'0';
                if(isBroken[bt]){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                int cnt = str.length() + Math.abs(i-n);
                ans = Math.min(ans,cnt);
            }
        }
        System.out.println(ans);
    }
}
