import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        //스택 생성
        Stack<Character> stack = new Stack<>();

        //문자를 하나씩 나눠서 비교
        for(int i = 0; i < s.length(); i++) {
            //여는 괄호는 stack에 push
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            //닫는 괄호이고 스택에 비어있지 않는 경우 stack에서 pop
            } else if(s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            //닫는 괄호인데 스택이 비어 있으면 괄호가 올바르지 않음 false return
            } else {
                return false;
            }
        }
        //연산이 끝났는데 stack에 남아있으면 올바른 괄호가 아님
        if(!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}