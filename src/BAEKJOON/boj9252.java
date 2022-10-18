package BAEKJOON;

import java.util.*;
    import java.io.*;
    public class boj9252 {
        static int[][] dp = new int[10][10];
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String a = br.readLine(); String b = br.readLine();
            String answer = LCS(a,b);
            System.out.println(answer.length());
            System.out.println(answer);
        }
        public static String LCS(String a, String b){
            int n1 = a.length(); int n2 = b.length();
            String[] a1 = a.split("");
            String[] b1 = b.split("");
            for (int i = 0; i < a1.length; i++) {
                for (int j = 0; j < b1.length; j++) {
                    if(a1[i].equals(b1[j])){
                        dp[i+1][j+1] = dp[i][j] +1;
                    }else{
                        dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
            int x = a1.length;
            int y = b1.length;
            String k = "";
            while(x!=0 && y!=0) {
                if(a1[x-1].equals(b1[y-1])) {
                    k +=a1[x-1];
                }

                if(dp[x-1][y] == dp[x][y]) {
                    x-=1;
                } else if(dp[x][y-1] == dp[x][y]) {
                    y-=1;
                } else {
                    x-=1;
                    y-=1;
                }
            }

            String ans = "";
            for(int i=k.length()-1; i>=0; i--) {
                ans += k.charAt(i);
            }

            return ans;
        }
    }
