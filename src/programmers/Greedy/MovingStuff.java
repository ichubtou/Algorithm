package programmers.Greedy;

import java.util.Arrays;

public class MovingStuff {
    public static void main(String[] args) {
        int output1 = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output1); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4
    }

    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
        //배열 오름차순 정렬
        Arrays.sort(stuff);
        //stuff 배열에서 양끝 인덱스 선언
        int count = 0;
        int leftIdx = 0;
        int rightIdx = stuff.length - 1;
        //stuff 배열의 오른쪽 인덱스가 왼쪽 인덱스보다 클때까지
        while(leftIdx <= rightIdx) {
            //stuff 배열에서 제일 왼쪽과 오른쪽에서 하나씩 선택 해서 더함
            //만약 더한 값이 limit 보다 작으면 인덱스를 각각 +1, -1 처리 더한 값이 limit 보다 크면 오른쪽 인덱스를 -1
            if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
                leftIdx++;
            }
            rightIdx--;
            //계산이 끝나면 count++
            count++;
        }
        return count;
    }
}
