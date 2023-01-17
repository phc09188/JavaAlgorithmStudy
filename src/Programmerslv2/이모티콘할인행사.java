package Programmerslv2;

public class 이모티콘할인행사 {
    public int[] solution(int[][] u, int[] e) {
        int[] result = new int[2];
        int[] cresult = new int[2];
        int[] p = new int[e.length];

        for(int start=40; start>=10; start-= 10){
            for(int i=0; i<e.length; i++){
                p[i] = start; //40 30 20 10
            }
            for(int en=0; en<e.length; en++){
                for(int f=start; f>=10; f-=10){
                    p[en] = f;
                    cresult = makeResult(u,e,p);
                    if(result[0]<cresult[0]){
                        result[0] = cresult[0];
                        result[1] = cresult[1];
                    }else if(result[0]==cresult[0] && result[1]<cresult[1]){
                        result[0] = cresult[0];
                        result[1] = cresult[1];
                    }
                }
                p[en] = start;
            }
        }
        return result;
    }
    public int[] makeResult(int[][] u, int[] e, int[] p){
        int[] result = new int[2];
        for(int i=0; i<u.length; i++){
            long emosum = 0;
            for(int x=0; x<e.length; x++)
                if(u[i][0]<=p[x])
                    emosum += e[x]*(100-p[x])/100;
            if(emosum>=u[i][1])
                result[0]++;
            else
                result[1] += emosum;
        }
        return result;
    }

    public static void main(String[] args) {
        이모티콘할인행사 a = new 이모티콘할인행사();
        int[][] users = {{40,10000},{25,10000}};
        int[] emotions = {7000,9000};
        System.out.println(a.solution(users,emotions));
    }
}
