package BAEKJOON;


import java.io.*;
import java.util.*;
public class boj2479 {
    static int n,k;
    static int start,end;
    static String[] codes;
    static class ham{
        String input;
        String result;

        public ham(String input, String result) {
            this.input = input;
            this.result = result;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        codes = new String[n+1];
        for (int i = 1; i <= n; i++) {
            codes[i] = br.readLine();
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());
        Queue<ham> qu = new LinkedList<>();
        qu.add(new ham(codes[start], start+""));
        while(!qu.isEmpty()){
            ham cur = qu.poll();
            String input = cur.input;
            if(cur.input.equals(codes[end])){
                sb.append(cur.result);
                break;
            }
            for (int i = 1; i <= n; i++) {
                if(!codes[i].equals(input)&& hamingDist(input, codes[i]) && !cur.result.contains(i+"")){
                    qu.add(new ham(codes[i], cur.result+" " + i));
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean hamingDist(String a, String b){
        int cnt =0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}
