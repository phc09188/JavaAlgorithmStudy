package Programmerslv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기 {
    public static Map<Integer,Integer> myTopping = new HashMap<>();
    public static Set<Integer> brothersTopping = new HashSet<>();
    public static int solution(int[] toppings) {
        putToppingCnt(toppings);
        return toppingEqualCnt(toppings);
    }

    private static int toppingEqualCnt(int[] toppings) {
        int equalCnt = 0;
        for(int topping : toppings){
            moveTopping(topping);
            if(myTopping.size() < brothersTopping.size()){
                break;
            }
            if(myTopping.size() == brothersTopping.size()){
                equalCnt++;
            }
        }
        return equalCnt;
    }

    private static void moveTopping(int topping) {
        brothersTopping.add(topping);
        int toppingCnt = myTopping.get(topping);
        if(toppingCnt == 1){
            myTopping.remove(topping);
            return;
        }
        myTopping.put(topping, toppingCnt -1);
    }

    private static void putToppingCnt(int[] toppings) {
        for(int topping : toppings){
            int cnt = myTopping.getOrDefault(topping,0);
            myTopping.put(topping,cnt +1);
        }
    }
    


    public static void main(String[] args) {
        int[] topping = {1,2,1,3,1,4,1,2};
        System.out.println(solution(topping));
    }
}
