package BAEKJOON;

import java.io.*;
public class boj17609 {
    public static int solution(String input){
        int left = 0; int right = input.length()-1; int cnt =0;
        while(left<= right){
            if(input.charAt(left)== input.charAt(right)){
                left++; right--;
            }else{
                cnt =1;
                int l = left +1; int r = right;
                while(l<=r){
                    if(input.charAt(l) == input.charAt(r)){
                        l++; r--;
                    }else{
                        cnt++;
                        break;
                    }
                }
                l = left; r = right-1;
                while(l<=r){
                    if(input.charAt(l) == input.charAt(r)){
                        l++; r--;
                    }else{
                        cnt++;
                        break;
                    }
                }
                if(cnt>=2) return cnt-1;
                else return cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(solution(br.readLine()) +"\n");
        }
        System.out.println(sb);
    }
}
