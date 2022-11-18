package Programmers_CodeTest;

import java.util.*;
public class nineteenthTest {
    //1.
    public boolean solution(String s, String t) {
        int idx = 0; int size = s.length();
        List<Integer> idxList = new ArrayList<>();
        if(s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(t.charAt(0) == s.charAt(i)){
                idxList.add(i);
            }
        }
        boolean isTrue = false;
        for (int i = 0; i < idxList.size(); i++) {
            int cnt = 0;
            idx = idxList.get(i);
            while (cnt < size) {
                if (s.charAt(idx) == t.charAt(cnt)) {
                    idx++;
                    cnt++;
                } else {
                    break;
                }
                if (idx == size) {
                    idx = 0;
                }
            }
            if(cnt == size){
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }
    //2
    public boolean solution(String param0) {
        if(param0.length()<5){
            return false;
        }
        char[] arr = param0.toCharArray();
        boolean big = false; boolean num = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>='A' && arr[i] <='Z'){
                big = true;
            }
            if(arr[i] >='0' && arr[i] <= '9'){
                num = true;
            }

            if(big && num){
                return true;
            }
        }
        return false;
    }
    //3
    public int solution(int[] param0) {
        int size = param0.length;
        int max = Arrays.stream(param0).max().getAsInt();
        return (max) - size;
    }
    //4
    public int solution4(int[] param0) {
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for (int i = 0; i < param0.length; i++) {
            if(param0[i] >0){
                plus.add(param0[i]);
            }else{
                minus.add(0 -param0[i]);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        for (int i = 0; i < plus.size(); i++) {
            if(minus.contains(plus.get(i))){
                return plus.get(i);
            }
        }
        return 0;
    }

    public int[] solution(String[] strings) {
        int[] answer = new int[4];
        for (int i = 0; i < strings.length; i++) {
            String[] a = strings[i].split(" ");
            int weight = Integer.parseInt(a[1].substring(0, a[1].length()-1));
            String type = a[0].substring(a[0].length()-3);
            if(type.equals("mp3") || type.equals("aac") || type.equals("lac")){
                answer[0] += weight;
            }else if(type.equals("jpg") || type.equals("bmp") || type.equals("gif")){
                answer[1] += weight;
            }else if(type.equals("mp4") || type.equals("avi") || type.equals("mkv")){
                answer[2] += weight;
            }else{
                answer[3] += weight;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        nineteenthTest a = new nineteenthTest();
        System.out.println(a.solution("abcade", "adeabc"));
        System.out.println(a.solution("zer0Bas3"));
        int[] nums = {5,1,6,4,10};
        System.out.println(a.solution(nums));
        nums = new int[]{3, 2, -2, 5, -3};
        System.out.println(a.solution4(nums));
        String[] strings = {"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"};
        System.out.println(Arrays.toString(a.solution(strings)));
    }
}
