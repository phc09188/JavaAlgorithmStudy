package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1759 {
    static Set<String> set;
    static boolean[] visited;
    String[] al = {"a","i","o","e","u"};
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        visited = new boolean[arr.length];
        Arrays.sort(arr);
        dfs(arr, 0,0, L);
        String[] list = set.toArray(new String[0]);
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

    }
    public static void dfs(String[] arr, int startidx,int cursize, int maxsize){
        if(cursize == maxsize){
            String result = "";
            int cnt  =0;
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]){
                    if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")){
                        cnt++;
                    }
                    result += arr[i];
                }
            }
            if(!set.contains(result) && cnt >=1){
                set.add(result);
            }
        }
        for (int i = startidx; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, i, cursize+1, maxsize);
                visited[i] = false;
            }
        }
    }
}
