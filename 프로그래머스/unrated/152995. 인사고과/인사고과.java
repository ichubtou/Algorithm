import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] scores) {
       int aMax = 0;
        int bMax = 0;
        int bExMax = 0;
        boolean aChange = false;

        int whAScore = scores[0][0];
        int whBScore = scores[0][1];

        int whScore = whAScore + whBScore;
        int whRank = 1;

        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);

        aMax = scores[0][0];
        for (int[] score : scores) {
            if (aMax != score[0]) {
                bExMax = bMax;
                aChange = true;
            } else {
                aChange = false;
            }
            if (scores[0][0] == score[0] || bExMax <= score[1]) {
                
                if(aChange == true) {
                    aMax = score[0];
                }

                if (score[0] > whAScore && score[1] > whBScore) {
                    return -1;
                }

                if (bMax < score[1]) {
                    bMax = score[1];
                }

                if (score[0] + score[1] > whScore) {
                    whRank++;
                }
            }
        }

        return whRank;
    }
}