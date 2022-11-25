package Programmers_CodeTest;


import java.util.*;

public class twentiethTest {
    public boolean solution(String s, String t) {
        String[] input = s.split(" ");
        String[] output = t.split(" ");
        if (input.length != output.length) {
            return false;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() != output[i].length()) {
                return false;
            }
            if (input[i].length() > 3) {
                if (input[i].charAt(0) != output[i].charAt(0) || input[i].charAt(input[i].length() - 1) != output[i].charAt(input[i].length() - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(int[][] x, int[][] y) {
        int len = 0;
        int answer = 0;
        if (x.length > y.length) {
            len = x.length;
        } else {
            len = y.length;
        }
        int max = Math.max(y[y.length - 1][0], x[x.length - 1][0]);
        int[] nx = new int[max + 1];
        int[] ny = new int[max + 1];
        for (int i = 0; i < len; i++) {
            if (i < x.length) {
                nx[x[i][0]] = x[i][1];
            }
            if (i < y.length) {
                ny[y[i][0]] = y[i][1];
            }
        }
        for (int i = 0; i < max + 1; i++) {
            answer += nx[i] * ny[i];
        }
        return answer;
    }

    public int solution(int[][] activity) {
        int max = 0;
        for (int i = 0; i < activity.length; i++) {
            max = Math.max(activity[i][1], max);
        }
        int[] arr = new int[max + 1];
        int answer = 0;
        for (int i = 0; i < activity.length; i++) {
            for (int j = activity[i][0]; j < activity[i][1]; j++) {
                arr[j] += 1;
                answer = Math.max(arr[j], answer);
            }

        }
        return answer;
    }

    public int solution(String s, String t, String[][] similarWords) {
        int answer = 0;
        String[] a = s.split(" ");
        String[] b = t.split(" ");
        Map<String, String> map = new TreeMap<>();
        for (int i = 0; i < similarWords.length; i++) {
            if (map.containsKey(similarWords[i][0]) || map.containsValue(similarWords[i][0])) {

            }
        }
        return 0;
    }

    /**
     * 4번 못 품
     **/
    public String[] solution(int n) {
        return null;
    }

    public static void main(String[] args) {
        twentiethTest a = new twentiethTest();
        System.out.println(a.solution("캠브릿지 대학의 연구결과", "캠릿브지 대학의 연결구과"));
        int[][] x = {{0, 1}, {3, 3}, {5, 2}, {6, 4}};
        int[][] y = {{2, 5}, {5, 4}, {6, 2}};
        System.out.println(a.solution(x, y));
        int[][] actives = {{0, 5}, {2, 6}, {3, 5}, {7, 10}, {5, 9}, {13, 15}};
        System.out.println(a.solution(actives));
        String[][] similarWords = {{"zerobase", "courses"}, {"is", "am"}, {"are", "am"}, {"awesome", "fine"}, {"fine", "great"}};
        System.out.println(a.solution("zerobase is awesome", "courses are great", similarWords));
    }
}
