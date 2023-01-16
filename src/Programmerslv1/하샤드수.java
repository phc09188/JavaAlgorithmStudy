package Programmerslv1;

public class 하샤드수 {
    public boolean solution(int x) {
        int cnt = 0;
        int answer = x;
        while (x > 0) {
            cnt += x % 10;
            x /= 10;
        }
        if (answer % cnt == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        하샤드수 a = new 하샤드수();
        System.out.println(a.solution(11));
    }
}
