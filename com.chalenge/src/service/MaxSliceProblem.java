package service;

import java.util.Arrays;

public class MaxSliceProblem {

    public int solution(int[] A) {

        if(A.length < 1){
            return 0;
        }

        int globalSum = 0;
        for(int i = 0; i < A.length; i++){
            int sum = A[i];
            int localSum = A[i];

            for(int j = i + 1; j < A.length; j++){
                localSum = localSum + A[j];
                if(localSum > sum){
                    sum = localSum;
                }
            }
            if(sum > globalSum){
                globalSum = sum;
            }
        }

        return globalSum;
    }


    public int solution2(int[] A) {
        long sum = Integer.MIN_VALUE;
        long maxSum = Integer.MIN_VALUE;
        for(int value : A){
            sum = Math.max(sum + value, value);
            maxSum = Math.max(sum, maxSum);
            System.out.println(" Evaluating " + value + " = " + sum);
        }
        return (int) maxSum;
    }

    public static void example(){
        MaxSliceProblem d = new MaxSliceProblem();
        int[] list = new int[]{ 7, -8, 4,  -1,  6, -2, 3, -6, 5 };
        System.out.println(d.solution(list));
        System.out.println(d.solution2(list));

    }

}
