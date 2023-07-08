class Solution {
    static int x = 0;
    static int y = 0;
    public int[] solution(String[] park, String[] routes) {
        int parkX = park[0].length();
        int parkY = park.length;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        for (String route : routes) {
            String[] s = route.split(" ");

            if (s[0].equals("E")) {
                int temp = x + Integer.parseInt(s[1]);
                if (!(temp > parkX - 1 || !check(park, Integer.parseInt(s[1]), 'x', 'p'))) {
                    x += Integer.parseInt(s[1]);
                }
            } else if (s[0].equals("W")) {
                int temp = x - Integer.parseInt(s[1]);
                if (!(temp < 0 || !check(park, Integer.parseInt(s[1]), 'x', 'm'))) {
                    x -= Integer.parseInt(s[1]);
                }
            } else if (s[0].equals("S")) {
                int temp = y + Integer.parseInt(s[1]);
                if (!(parkY - 1 < temp  || !check(park, Integer.parseInt(s[1]), 'y', 'm'))) {
                    y += Integer.parseInt(s[1]);
                }
            } else {
                int temp = y - Integer.parseInt(s[1]);
                if (!(0 > temp || !check(park, Integer.parseInt(s[1]), 'y', 'p'))) {
                    y -= Integer.parseInt(s[1]);
                }
            }
        }

        return new int[]{y, x};
    }
    
    public boolean check(String[] park, int n, char xy, char pm) {
        boolean check = true;
        if(xy == 'x' && pm == 'p') {
            for(int i = 1; i < n + 1; i++) {
                if(park[y].charAt(x + i) == 'X') {
                    check = false;
                }
            }
        } else if(xy == 'y' && pm == 'p'){
            for(int i = 1; i < n + 1; i++) {
                if(park[y - i].charAt(x) == 'X') {
                    check = false;
                }
            }
        } else if(xy == 'x' && pm == 'm') {
            for(int i = 1; i < n + 1; i++) {
                if(park[y].charAt(x - i) == 'X') {
                    check = false;
                }
            }
        } else if(xy == 'y' && pm == 'm'){
            for(int i = 1; i < n + 1; i++) {
                if(park[y + i].charAt(x) == 'X') {
                    check = false;
                }
            }
        }
        
        return check;
    }
}