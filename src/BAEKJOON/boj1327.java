package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1327 {
    static int N,K;
    static char[] arr, copy;
    static String arr_str, copy_str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        arr = br.readLine().replace(" ", "").toCharArray();
        copy = Arrays.copyOf(arr, N);
        Arrays.sort(arr);
        arr_str = new String(arr);
        copy_str = new String(copy);
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Strcnt> qu = new LinkedList<>();
        Set<String> set = new HashSet<>();
        qu.add(new Strcnt(copy_str, 0));
        while(!qu.isEmpty()){
            Strcnt a = qu.poll();
            String str = a.str;
            int cnt = a.cnt;
            if(arr_str.equals(str)) return cnt;
            if(!set.contains(str)){
                set.add(str);
                for (int i = 0; i <= N-K; i++) {
                    qu.offer(new Strcnt(reverseString(str, i, i+K), cnt+1));
                }
            }
        }
        return -1;
    }
    public static String reverseString(String str, int i, int j){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,i));
        String reverse = str.substring(i,j);
        for (int k = K-1; k >= 0; k--) {
            sb.append(reverse.charAt(k));
        }
        sb.append(str.substring(j,str.length()));
        return sb.toString();
    }
    public static class Strcnt{
        String str;
        int cnt;
        public Strcnt(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
}
