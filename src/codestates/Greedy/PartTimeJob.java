package codestates.Greedy;

public class PartTimeJob {
    public static void main(String[] args) {
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = partTimeJob(4972);
        System.out.println(output2); // --> 18
    }

    public static int partTimeJob(int k) {
        // TODO:
        //동전 갯수 세는 count 선언
        int count = 0;
        //동전 배열을 선언
        int coin[] = {1, 5, 10, 50, 100, 500};
        //동전 인덱스 선언
        int coinIdx = coin.length - 1;
        //나머지가 0이 될때까지 반복
        while(k != 0) {
            //가장 큰 인덱스의 동전배열로 나눴을때 구한 몫은 count 에 + 나머지는 그 아랫단위의 동전으로 똑같이 반복
            count += k / coin[coinIdx];
            k %= coin[coinIdx];
            //코인 인덱스 하나씩 줄여줌
            coinIdx--;
        }
        return count;
    }
}
