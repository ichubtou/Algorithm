import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
       String[][] mapsArr = new String[maps.length][maps[0].length()];
        List<Integer> answerList = new ArrayList<>();

        int sum = 0;

        //2차원 배열로 변환
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                mapsArr[i][j] = maps[i].substring(j, j + 1);
            }
        }

        //BFS 이므로 Queue 사용
        Queue<int[]> queue = new LinkedList<>();
        //주변에 있는 블록 찾기 동서남북
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //블럭을 하나씩 탐색
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                sum = 0;
                //해당 블럭이 X 가 아닐 경우 queue 에 넣고 주변 블록 탐색
                if(!mapsArr[i][j].equals("X")) {
                    queue.add(new int[]{i, j});
                    sum += Integer.parseInt(mapsArr[i][j]);
                    mapsArr[i][j] = "X";
                }

                //queue 에 요소가 없을때까지 반복
                while(!queue.isEmpty()) {
                    int[] current = queue.remove();
                    //현재 블록 위치
                    int cx = current[0];
                    int cy = current[1];

                    for(int k = 0; k < 4; k++) {
                        //다음 블록 위치
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];

                        //크기를 벗어나면 continue 처리
                        if(nx < 0 || nx > mapsArr.length - 1 || ny < 0 || ny > mapsArr[0].length - 1) {
                            continue;
                        }

                        //X 가 아니면 sum 에 더해주고 queue 에 넣어서 그 다음 블록 주변을 탐색 해당 블록은 X 처리
                        if(!mapsArr[nx][ny].equals("X")) {
                            sum += Integer.parseInt(mapsArr[nx][ny]);
                            queue.add(new int[]{nx, ny});
                            mapsArr[nx][ny] = "X";
                        }
                    }
                }
                //sum 가 0이 아닐 경우 add
                if(sum != 0) {
                    answerList.add(sum);
                }
            }
        }

        //지도의 요소가 모두 X 일 경우 -1 반환
        if(answerList.size() == 0) {
            return new int[]{-1};
        }

        Collections.sort(answerList);

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}