package codeTest;

import java.io.*;
import java.util.*;
public class boj10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0]!=o2[0] ? Integer.parseInt(o1[0])-Integer.parseInt(o2[0]) : Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] +" "+  arr[i][1]);
        }
        
    }
}
