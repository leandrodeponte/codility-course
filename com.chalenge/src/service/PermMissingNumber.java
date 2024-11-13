package service;

import java.util.Arrays;

public class PermMissingNumber {

    public int solution(int[] A) {
        Arrays.sort(A);
        var before = A[0];
        var count = 0;
        for(int i : A){
            if(count > 0){
                if(i != before + 1){
                  return  (before + 1);
                }
            }
            count++;
        }
        return 0;
    }

    public int solution2(int[] A) {

        Arrays.sort(A);
        int numberOfElements = A.length + 1;
        int sum = ((numberOfElements + 1) * numberOfElements / 2);
        int realSum = 0;

        for(int number : A){
            realSum += number;
        }

        return sum - realSum;

    }



}
