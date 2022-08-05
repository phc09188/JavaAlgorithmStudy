package Programmerslv2;

import java.util.*;

public class 오픈채팅방 {
    public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String userid = st.nextToken();
            String name = "";
            if(!command.equals("Leave")){
                name = st.nextToken();
            }

            switch(command){
                case "Enter":
                    hm.put(userid,name);
                    list.add(userid + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    hm.remove(userid);
                    list.add(userid+ "님이 들어왔습니다.");
                    break;
                case "Change":
                    hm.put(userid, name);
                    break;
            }
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String a : list){
            int endofidx = a.indexOf("님");
            String userId = a.substring(0, endofidx);
            answer[idx++] = a.replace(userId, hm.get(userId));
        }
        return answer;
    }
    public static void main(String[] args){
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
        
    }
}
