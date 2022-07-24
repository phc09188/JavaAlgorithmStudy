package codeTest;

import java.io.*;
import java.util.*;
public class boj1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int maxsize = 1;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        for (int i = 0; i < arr.length-1; i++) {
            if(!arr[i].equals(arr[i+1])) {
                sb.append(arr[i]+"\n");
            }
        }
        sb.append(arr[arr.length-1]);
        System.out.println(sb);
    }
}
