package Programmerslv1;

import java.util.*;
public class 신고결과받기 {
    static List< HashSet<Integer> > setList = new ArrayList<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Integer> idMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) idMap.put( id_list[i], i );

        setList.clear();
        for(int i=0; i<id_list.length; i++) setList.add(new HashSet<Integer>());

        StringTokenizer st;
        String userId, reportedId;
        for(String str : report){
            st = new StringTokenizer(str);
            userId = st.nextToken();
            reportedId = st.nextToken();

            setList.get( idMap.get(reportedId) ).add( idMap.get(userId) );
        }

        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++){

            if( setList.get(i).size() >= k ){
                for( int reportMan : setList.get(i) ) answer[reportMan]++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(solution(id_list,report,2)));
    }
}
