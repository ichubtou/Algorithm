import java.util.*;

class Solution {
    static HashSet<Integer> numberSet = new HashSet<>();
    static boolean[] visited;
    static String[] arr;

    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.split("");
        visited = new boolean[numbers.length()];

        permutation(0, "");


        return numberSet.size();
    }

    public void permutation(int cnt, String str) {
        if(str.length() != 0 && isPrime(Integer.parseInt(str))) {
            numberSet.add(Integer.parseInt(str));
        }
        if(arr.length == cnt) {
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation(cnt + 1, str + arr[i]);
            visited[i] = false;
        }
    }

    public boolean isPrime(int num) {
        if(num == 1 || num == 0) {
            return false;
        }
        int limit = (int) Math.sqrt(num);
        for(int i=2; i<=limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}