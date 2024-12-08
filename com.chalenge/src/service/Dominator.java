package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Dominator {

    public int solution(int[] A) {
        Map<Integer, Integer> values = new HashMap<>();
        int mostOcurred = 0;
        int position = -1;

        if(A.length == 1){
            return 0;
        }

        for(int i = 0; i < A.length - 1; i++) {
            if (values.containsKey(A[i])) {
                values.put(A[i], values.get(A[i]) + 1);
            } else {
                values.put(A[i], 1);
            }
            if(mostOcurred < values.get(A[i])){
                mostOcurred = values.get(A[i]);
                position = i;
            }
        }

        if(mostOcurred >= A.length / 2){
            return position;
        }

        return -1;
    }

    public int solution2(int[] A) {
        Stack<Integer> stack = new Stack<>();

        for(int elem : A){
            if (stack.isEmpty()) {
                stack.push(elem);
            } else {
                int topElem = stack.peek();
                if (topElem != elem) {
                    stack.pop();
                } else {
                    stack.push(elem);
                }
            }
        }

        if(stack.isEmpty()){
            return -1;
        }
        int elem = stack.peek();
        return Arrays.stream(A)
                .filter(num -> num == elem)
                .findAny().orElse(-1);
    }

    public static void example(){
        Dominator d = new Dominator();
        int[] list = new int[]{ 2, 4, 3,  3,  3,  2, 3 };
        System.out.println(d.solution(list));
        System.out.println(d.solution2(list));

    }

}
