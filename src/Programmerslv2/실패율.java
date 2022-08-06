package Programmerslv2;

import java.util.*;
class Node{
    int i;
    float per;
    Node(int i, float per){
        this.i = i;
        this.per = per;
    }
}
public class 실패율 {
    public static int[] solution(int N, int[] stages) {
        int person = stages.length;
        int[] max = new int[501];
        int maxnum = 0;
        Queue<Node> qu = new LinkedList<>();
        for (int i = 0; i < stages.length; i++) {
            max[stages[i]] +=1;
            maxnum = Math.max(maxnum, stages[i]);
        }
        float[] num = new float[maxnum+1];
        float min = Integer.MIN_VALUE;
        for (int i = 1; i <= maxnum; i++) {
            qu.add(new Node(i,(float) max[i] / person));
            min = Math.min(min,(float) max[i] / person);
            person = person - max[i];
        }
        int cnt =0;
        int[] answer = new int[maxnum];
        while(!qu.isEmpty()){
            if(qu.peek().per <= min){
                Node a = qu.poll();
                answer[cnt] = a.i-1;
            }else{
                qu.add(qu.poll());
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(5,stages)));
    }
}
