package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj7662ver2 {
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t >0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String operations = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                switch (operations) {
                    case "I":
                        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (treeMap.isEmpty()) break;
                        if (num == -1) {
                            int minKey = treeMap.firstKey();
                            if (treeMap.get(minKey) == 1) {
                                treeMap.remove(minKey);
                            } else {
                                treeMap.put(minKey, treeMap.get(minKey) - 1);
                            }
                        } else {
                            int maxKey = treeMap.lastKey();
                            if (treeMap.get(maxKey) == 1) {
                                treeMap.remove(maxKey);
                            } else {
                                treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                            }
                        }
                        break;
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY \n");
            }else{
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey() +"\n");
            }
            t--;
        }
        System.out.println(sb);
    }
}
