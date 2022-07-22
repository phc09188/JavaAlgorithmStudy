package codeTest;

import java.io.*;
import java.util.*;
public class boj1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] isTrue = new boolean[m+1];
        for (int i = 2; i <= m; i++) {
            if(isTrue[i]) continue;
            if(i>=n) sb.append(i + "\n");
            for (int j = i+i; j <= m; j +=i) {
                isTrue[j] = true;
            }
        }
        System.out.println(sb);
    }
}

//import java.io.*;
//        import java.util.*;
//public class boj1929 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        boolean[] isTrue = new boolean[m+1];
//        for (int i = n; i < m; i++) {
//            if(i<2){
//                return;
//            }
//            isTrue[0] = isTrue[1] = true;
//            for (int j = 2; j <= Math.sqrt(m); j++) {
//                if(isTrue[j] == true){
//                    continue;
//                }
//                for (int k = j*j; k < isTrue.length; k = k +j) {
//                    isTrue[k] = true;
//                }
//            }
//        }
//        for (int i = n; i < isTrue.length; i++) {
//            if(isTrue[i] == false){
//                System.out.println(i);
//            }
//        }
//    }
//}