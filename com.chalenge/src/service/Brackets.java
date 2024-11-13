package service;

import java.util.List;
import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        List<Character> closers = List.of('}', ']', ')');
        List<Character> openers = List.of('{', '[', '(');
        Stack<Character> stack = new Stack<Character>();

        for(char c : S.toCharArray()) {
            boolean isCloser = closers.contains(c);
            boolean isOpener = openers.contains(c);
            if(!isCloser && !isOpener)  return 0;
            if(isCloser && stack.empty()) return 0;
            if(isOpener){
                stack.push(c);
            }
            if(isCloser){
                Character lastChar = stack.peek();
                if(matches(lastChar, c)){
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }
        if(stack.empty()) return 1;
        return 0;
    }

    private Boolean matches(Character opener, Character closer){
        switch (opener) {
            case '{': return closer == '}';
            case '[': return closer == ']';
            case '(': return closer == ')';
            default: return false;
        }

    }

}
