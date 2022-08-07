package Programmers_CodeTest;

import java.util.*;
public class 순위검색 {
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int cnt = 0;
            String[] a = query[i].split(" and ");
            for (int j = 0; j < info.length; j++) {
                String[] b = info[j].split(" ");
                int count = 0;
                for (int k = 0; k < b.length; k++) {
                    if(k<3) {
                        if (b[k].equals(a[k])) count++;
                    }
                    else if(k==3 || k==4){
                        if(a[k].contains(b[k])) count++;
                    }
                    if(count == 5)
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args ){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }
}
