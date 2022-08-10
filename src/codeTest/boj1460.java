package codeTest;

//          ** 메모리초과 **
import java.io.*;
import java.util.*;
public class boj1460 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        if(M ==1){
            String[] input = br.readLine().split(" ");
            int a= Integer.parseInt(input[2]);
            ans = a*a;
            System.out.println(ans);
        }else {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int F = Integer.parseInt(st.nextToken());
                for (int j = x; j < x + L; j++) {
                    for (int k = y; k < y + L; k++) {
                        arr[j][k] = F;
                    }
                }
            }
            int cnt = N;
            int max = 0;
            while(cnt >0){
                for (int i = 0; i <= N-cnt; i++) {
                    for (int j = 0; j <= N-cnt; j++) {
                        boolean isbreak = false;
                        Set<Integer> set = new HashSet<>();
                        int counter = 0;
                        for (int k = i; k < i+cnt; k++) {
                            for (int l = j; l < j+cnt; l++) {
                                if(arr[k][l] ==0){
                                    isbreak = true;
                                    break;
                                }
                                if(!set.contains(arr[k][l]) && arr[k][l] !=0){
                                    counter++;
                                    set.add(arr[k][l]);
                                }
                            }
                            if(isbreak) break;
                        }
                        if(set.size() <=2){
                            max = Math.max(max, cnt);
                        }
                    }
                }
                cnt--;
            }
            System.out.println(max*max);
        }
    }
}
