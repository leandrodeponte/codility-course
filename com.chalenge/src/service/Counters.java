package service;

import java.util.Arrays;

public class Counters {

    public int[] solution(int N, int[] A) {

        int[] counters = new int[N];
        int maxCounter = 0;

        System.out.println("Counters: " + N);
        System.out.println("Operations: " + Arrays.toString(A));
        System.out.println("Initial: " + Arrays.toString(counters));


        for(int i = 0; i < A.length; i++) {
            int operation = A[i];
            if(operation > N){
                for(int c = 0; c < N; c++){
                    counters[c] = maxCounter;
                }
            } else {
                counters[operation - 1] += 1;
                if(counters[operation - 1] > maxCounter) {
                    maxCounter = counters[operation - 1];
                }
            }
        }

        System.out.println("Final: " + Arrays.toString(counters));

        return counters;

    }


    public int[] solution2(int N, int[] A) {

        int[] counters = new int[N];
        int valueToSum = 0;
        int maxCounter = 0;

        System.out.println("Counters: " + N);
        System.out.println("Operations: " + Arrays.toString(A));
        System.out.println("Initial: " + Arrays.toString(counters));


        for(int i = 0; i < A.length; i++) {
            int operation = A[i];
            if(operation > N){
                valueToSum += maxCounter;
            } else {
                counters[operation - 1] += 1;
                if(counters[operation - 1] > maxCounter) {
                    maxCounter = counters[operation - 1];
                }
            }
        }

        for(int c = 0; c < counters.length; c++){
            counters[c] += valueToSum;
        }

        return counters;

    }

}
