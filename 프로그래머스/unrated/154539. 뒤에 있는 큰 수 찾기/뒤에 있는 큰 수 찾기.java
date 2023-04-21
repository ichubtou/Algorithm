import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[answer.length - 1]);
        answer[numbers.length - 1] = -1;

        for (int i = numbers.length - 2; i > -1; i--) {
            if (numbers[i] < stack.peek()) {
                answer[i] = stack.peek();
                stack.push(numbers[i]);
            } else {
                while (!stack.isEmpty()) {
                    if(stack.peek() > numbers[i]) {
                        answer[i] = stack.peek();
                        break;
                    }
                    stack.pop();
                }
                if(answer[i] == 0) {
                    answer[i] = -1;
                }
                stack.push(numbers[i]);
            }
        }

        return answer;
    }
}