package codeTest;

import java.io.*;
import java.util.*;
public class boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> arr1 = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            arr1.add(br.readLine());
        }
        ArrayList<String> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if(arr1.contains(input)){
                arr2.add(input);
            }
        }
        Collections.sort(arr2);
        System.out.println(arr2.size());
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }
    }
}
