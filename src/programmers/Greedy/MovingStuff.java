package programmers.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MovingStuff {
    public static void main(String[] args) {
        int output1 = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output1); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4
    }

    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
        int count = 0;
        int box = 0;
        int boxCount = 0;
        List<Integer> list = Arrays.stream(stuff).boxed().collect(Collectors.toList());
        Collections.sort(list);

        while(list.size() != 0) {
            for(int i = list.size() - 1; i > -1; i--) {
                if(i == 0) {
                    list.remove(0);
                    boxCount = 1;
                    count++;
                    break;
                }
                box += list.get(0);
                box += list.get(i);
                boxCount++;
                if (box <= limit && boxCount <= 2) {
                    list.remove(0);
                    list.remove(i - 1);
                    boxCount = 1;
                    count++;
                    box = 0;
                    break;
                }
                else if(box > limit && boxCount <=2) {
                    boxCount = 1;
                    box = 0;
                }
            }
        }
        return count;
    }
}
