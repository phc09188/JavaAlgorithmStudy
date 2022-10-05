package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1091 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];
        int[] cards = new int[N];
        int[] copy = cards.clone();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            cards[i] = i%3;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[Integer.parseInt(st.nextToken())] = i;
        }
        int cnt =0;
        int[] next = cards.clone();
        while(!Arrays.equals(cards,P) && !(cnt!=0 && Arrays.equals(cards,copy))){
            for (int i = 0; i < N; i++) {
                next[S[i]] = cards[i];
            }
            cards = next.clone();
            cnt++;
        }
        if(cnt!=0 && Arrays.equals(cards, copy)) System.out.println(-1);
        else System.out.println(cnt);

    }
}
