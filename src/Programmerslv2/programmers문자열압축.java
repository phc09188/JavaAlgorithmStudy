package Programmerslv2;

import java.io.IOException;

public class programmers문자열압축 {
    public static int solution(String s){
        int answer = s.length();
        for (int i = 1; i <= s.length()/2; i++) {
            String zip = s.substring(0,i);
            int cnt = 1;
            String cur = "";
            StringBuilder sb = new StringBuilder();
            for (int start = i; start <= s.length(); start+=i) {
                if(start +i >= s.length()){
                    cur = s.substring(start, s.length());
                }else{
                    cur = s.substring(start, start+i);
                }
                if(cur.equals(zip)){
                    cnt++;
                }else if(cnt ==1){
                    sb.append(zip);
                    zip = cur;
                }else{
                    sb.append(cnt).append(zip);
                    zip = cur;
                    cnt =1;
                }
            }
            if(i!= zip.length()) sb.append(zip);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        String a = "ababcdcdababcdcd";
        System.out.println(solution(a));
    }
}

