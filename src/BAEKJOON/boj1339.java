package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1339 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);
            arr[i] = sb.reverse().toString();
        }
        Arrays.sort(arr, (s1,s2) -> s2.length() - s1.length());
        Map<Character, Integer> alphabet = new HashMap<>();
        int high = arr[0].length()-1;
        for (int i = high; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if(i>= arr[j].length()){
                    break;
                }
                char a = arr[j].charAt(i);
                if(!alphabet.containsKey(a)){
                    alphabet.put(a, (int)Math.pow(10,i));
                }else{
                    alphabet.put(a, alphabet.get(a) + (int)Math.pow(10,i));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Character c : alphabet.keySet()){
            list.add(alphabet.get(c));
        }
        Collections.sort(list, (a,b) -> b-a);
        int num = 9; int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i)*num--;
        }
        System.out.println(ans);
    }
}
