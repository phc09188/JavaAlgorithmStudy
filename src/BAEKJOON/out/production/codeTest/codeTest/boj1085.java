package BAEKJOON.out.production.codeTest.codeTest;


import java.io.*;
import java.util.*;
public class boj1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList arr = new ArrayList();
        StringTokenizer st = new StringTokenizer(input);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr.add(x); arr.add(y); arr.add(w-x); arr.add(h-y);
        arr.sort(Comparator.naturalOrder());
        if(x>=1&&y>=1&&x<=w-1 && y<=h-1 ){
            System.out.println(arr.get(0));
        }

    }
}
