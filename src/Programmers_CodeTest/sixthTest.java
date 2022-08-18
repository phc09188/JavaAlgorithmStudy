package Programmers_CodeTest;

import java.util.*;
public class sixthTest {
    public static int[] solution1(int[] values) {
        int p1 = 0; int p2 = 0; int cur = 0; int max = -1;
        int[] answer = new int[2];
        while(p2<=values.length-1){
            if(p2 < values.length-2&&values[p2+1]> values[p2]) {
                p2++;
            }else if(p2< values.length-2&&values[p2+1]<values[p2]){
                if(p2-p1 >max) {
                    answer[0] = p1;
                    answer[1] = p2;
                    max = p2-p1;
                }
                p2+=1;
                p1 = p2;
            }else{
                p2++;
            }
        }
        return answer;
    }
    public static int solution2ver2(int[] amount, int[] value, int[] stomach){
        if(amount.length ==0) return 0;
        if(amount.length ==1){
            int a = Math.min(amount[0], stomach[0]);
            return value[0] * a;
        }
        int tempValue, tempValue2,target;
        int sum = 0;
        for (int i = 0; i < stomach.length; i++) {
            sum+= stomach[i];
        }
        for (int i = 1; i < value.length; i++) {

            tempValue = value[i];
            tempValue2 = amount[i];
            target = i - 1;
            while (target >= 0 && value[target] > tempValue) {
                value[target + 1] = value[target];
                amount[target+1] = amount[target];
                target--;
            }
            value[target + 1] = tempValue;
            amount[target+1] = tempValue2;
        }
        int answer = 0;
        for (int i = value.length-1; i >= 0; i--) {
            if(i ==value.length-1){
                int n = value.length;
                int k = (amount[i]/n) *n;
                answer += value[i] * k;
                sum -=k; amount[i] =0;
            }else if(amount[i] ==0){
                break;
            }else if(sum>0){
                while(amount[i] >0&& sum>0){
                    answer += value[i];
                    amount[i] --;
                    sum--;
                }
            }else{
                break;
            }
        }
        return answer;
    }

    public static int solution2(int[] amount, int[] value, int[] stomach) {
        int answer = 0; int n = stomach.length; int a = 0; int maxidx = 0;
        for (int i = 0; i < stomach.length; i++) {
            a += stomach[i];
            if(value[maxidx] < value[i]){
                maxidx = i;
            }
        }
        int k = (amount[maxidx]/n) *n;
        answer += value[maxidx] * k;
        a -= k;
        value[maxidx] =0;
        amount[maxidx] = 0;
        while(a >0){
            maxidx = 0;
            for (int i = 0; i < value.length; i++) {
                if(value[maxidx]< value[i]){
                    maxidx = i;
                }
            }
            while(amount[maxidx]>0&& a>0){
                answer += value[maxidx];
                amount[maxidx]--;
                a--;
            }
            value[maxidx] =0;
        }
        return answer;
    }
    public static int solution3(String[] ingredients, String[] items) {
        Set<String> allkinds = new HashSet<>();
        for (int i = 0; i < ingredients.length; i++) {
            allkinds.add(ingredients[i]);
        }
        if(allkinds.size() ==1) return 1;

        int start = 0; int last = 0; int dis = Integer.MAX_VALUE;
        Map<String, Integer> term = new HashMap<>();
        int size = ingredients.length;
        while(start <= last){
            if(term.size() == size){
                if(allkinds.contains(items[start]) && last - start <dis){
                    dis = last -start;
                }
                if(!allkinds.contains(items[start])){
                    start++;
                }else{
                    int v = term.get(items[start]);
                    if(v ==1){
                        term.remove(items[start]);
                    }else{
                        term.put(items[start], v-1);
                    }
                    start++;
                }
            }else{
                if(last > items.length-1){
                    break;
                }
                if(allkinds.contains(items[last])) {
                    if (term.containsKey(items[last])) {
                        int v = term.get(items[last]);
                        term.put(items[last], v + 1);
                    } else {
                        term.put(items[last], 1);
                    }
                }
                last++;
            }
        }
        return dis;
    }
    public static int solution3ver2(String[] ingredients, String[] items){
        Set<String> allkinds = new HashSet<>();
        for (int i = 0; i < ingredients.length; i++) {
            allkinds.add(ingredients[i]);
        }
        Map<String, Integer> map = new HashMap<>();
        int len = items.length;
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < items.length; i++) {
            q.add(items[i]);
            if(allkinds.contains(items[i])){
                map.put(items[i], map.getOrDefault(items[i], 0) +1);

                while(true){
                    String item = q.peek();
                    if(!allkinds.contains(item)){
                        q.poll();
                    }else break;
                }
            }
            if(map.size() == allkinds.size()){
                if(len> q.size()){
                    len = q.size();
                }
            }
        }
        return len;
    }
    public static int[] solution4(int[] arr, int k) {
        if(arr.length == k){
            int[] a = new int[1];
            a[0] = findmax(arr);
            return a;
        }
        int[] answer = new int[arr.length-k+1];
        for (int i = 0; i < arr.length; i++) {
            if(i+k-1 < arr.length){
                int[] a = new int[k];
                int cnt =0;
                for (int j = i; j <= i+k-1; j++) {
                    a[cnt++] = arr[j];
                }
                answer[i] = findmax(a);
            }
        }

        return answer;
    }
    public static int findmax(int[] arr){
        int maxnum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxnum){
                maxnum = arr[i];
            }
        }
        return maxnum;
    }
    public static int[] solution5(int[] scores) {
        int n = scores.length;
        int[] answer = new int[n];
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        p1[0] = 1; p2[n-1] =1;
        for (int i = 1; i < n; i++) {
            if(scores[i-1] >=scores[i])p1[i] = 1;
            else p1[i] = p1[i-1] +1;
        }
        for (int i = n-2; i >= 0; i--) {
            if(scores[i+1]>=     scores[i]) p2[i]=1;
            else p2[i] = p2[i+1] +1;
        }
        for (int i = 0; i < n; i++) {
            answer[i] = Math.max(p1[i], p2[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        int[] values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156};
        int[] amount = {7,10,4,5}; int[] value = {5,4,3,1}; int[] stomach ={4,6,2,8,5};
        String[] ingredients = {"생닭", "인삼", "소주", "대추"}; String[] items = {"물", "인삼","산삼","말삼","여자","인삼","남자","커피","소주", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"};
        int[] arr = {75, 25, 70, 46, 60, 7, 85, 65, 28, 78, 29, 37};
        int[] score = {1,3,5,4,5,5,5,1};
        System.out.println(Arrays.toString(solution1(values)));
        System.out.println(solution2ver2(amount, value, stomach));
//        System.out.println(solution3(ingredients, items));
//        System.out.println(Arrays.toString(solution4(arr,5)));
//        System.out.println(Arrays.toString(solution5(score)));
    }
}
