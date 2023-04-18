class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {wallpaper.length, wallpaper[0].length(), 0, 0};

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                String a = wallpaper[i].substring(j, j + 1);
                if(wallpaper[i].substring(j, j + 1).equals("#")) {
                    if(i < answer[0]) {
                        answer[0] = i;
                    }
                    if(j < answer[1]) {
                        answer[1] = j;
                    }
                    if(i > answer[2]) {
                        answer[2] = i;
                    }
                    if(j > answer[3]) {
                        answer[3] = j;
                    }
                }
            }
        }
        
        answer[2]++;
        answer[3]++;

        return answer;
    }
}