import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
         int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : score) {
            pq.add(i);
        }

        while(!pq.isEmpty()) {
            PriorityQueue<Integer> temp = new PriorityQueue<>();

            if (pq.size() >= m) {
                for (int j = 0; j < m; j++) {
                    temp.add(pq.poll());
                }
                answer += temp.poll() * m;
            } else {
                pq = new PriorityQueue<>();
            }
        }

        return answer;
    }
}