package codeTest;

import java.io.*;
import java.util.*;
public class boj18115 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num = n;
        int idx1 = 0; int idx2 =1; int idx3 = n-1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1){
                result[idx1] = num;
                if(result[idx1+1] == 0) idx1 +=1;
                else idx1 = idx2+1;
            }else if(arr[i] == 2){
                if(result[idx1+1] == 0) idx2 = idx1+1;
                else idx2 +=1;
                result[idx2] = num;
            }else if(arr[i] == 3){
                result[idx3] = num;
                idx3 -= 1;
            }
            num--;
        }
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}
//import java.io.*;
//        import java.util.*;
//public class boj18115 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Stack<Integer> stack = new Stack();
//        int[] x = new int[n];
//        for (int i = 1; i <= n; i++) {
//            x[i-1] = Integer.parseInt(st.nextToken());
//            stack.add(i);
//        }
//        int cnt = 0;
//        boolean[] a = new boolean[n];
//        int[] result = new int[n];
//        while(cnt<n){
//            switch(x[cnt]){
//                case 1:
//                    int temp = stack.pop();
//                    for (int i = 0; i < n; i++) {
//                        if(!a[i]){
//                            result[i] = temp;
//                            a[i] = true;
//                            break;
//                        }
//                    }
//                    cnt++;
//                    break;
//                case 2:
//                    if(stack.size() >=2) {
//                        int temp2 = stack.pop();
//                        int c = 0;
//                        for (int i = 0; i < a.length; i++) {
//                            if(!a[i]){
//                                if(c ==1){
//                                    result[i] = temp2;
//                                    a[i] = true;
//                                    break;
//                                }else{
//                                    c++;
//                                }
//                            }
//                        }
//                    }
//                    cnt++;
//                    break;
//                case 3:
//                    if(stack.size() >=2){
//                        int temp3 = stack.pop();
//                        for (int i = a.length-1; i >= 0; i--) {
//                            if(!a[i]){
//                                result[i] = temp3;
//                                a[i] = true;
//                                break;
//                            }
//                        }
//                    }
//                    cnt++;
//                    break;
//            }
//        }
//        for(int i : result){
//            sb.append(i + " ");
//        }
//        System.out.println(sb);
//    }
//}