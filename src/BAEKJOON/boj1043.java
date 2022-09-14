package BAEKJOON;

import java.io.*;
import java.sql.Array;
import java.util.*;
public class boj1043 {
    static int[] parents;
    static HashSet<Integer> know;
    public static void main(String[] args )throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] =i;
        }
        st = new StringTokenizer(br.readLine());
        int know_num = Integer.parseInt(st.nextToken());
        know = new HashSet<>();
        if(know_num ==0){
            System.out.println(m);
            return;
        }
        for (int i = 0; i < know_num; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer>[] partyList = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            for (int j = 1; j < partyNum; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
                partyList[i].add(y);
            }
        }
        int counter = 0;
        for (int i = 0; i < m; i++) {
            boolean isTrue = true;
            for(int num : partyList[i]){
                if(know.contains(find(parents[num]))){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) counter++;
        }
        System.out.println(counter);
    }
    static int find(int x) {
        if(parents[x] ==x ) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(know.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry =tmp;
        }

        parents[ry] = rx;
    }
}
