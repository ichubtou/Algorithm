package programmers.Hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public static void main(String[] args) {
        int output1 = solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(output1);

        int output2 = solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println(output2);
    }

    public static int solution(String[][] clothes) {

        //의상의 종류마다의 갯수 파악
        //종류 각각의 경우의 수는 입지 않았을 경우 + 종류에 해당하는 개수이므로 종류마다의 경우의 수를 곱해주고 어느것도 입지 않았을 경우 -1 해주면 된다.

        int answer;
        int count = 1;
        //해시맵 선언
        Map<String, Integer> hashmap = new HashMap<>();
        //해시맵의 키에 종류, 값에 해당 종류의 갯수를 넣어준다
        for(int i = 0; i < clothes.length; i++) {
            if(hashmap.containsKey(clothes[i][1])) {
                hashmap.put(clothes[i][1] , hashmap.get(clothes[i][1]) + 1);
            } else {
                hashmap.put(clothes[i][1], 1);
            }
        }

        //각 종류의 갯수를 꺼내고 각각 곱해줌
        for(int value : hashmap.values()) {
            count *= (value + 1);
        }
        //어느것도 입지 않았을 경우 -1
        answer = --count;

        return answer;
    }
}
