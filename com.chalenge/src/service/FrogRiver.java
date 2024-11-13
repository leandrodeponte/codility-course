package service;

import java.util.ArrayList;

public class FrogRiver {

    public int solution(int X, int[] A) {
        int numOfSpaces = X;
        int sum = 0;
        ArrayList<Integer> filledSlots = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            if(!filledSlots.contains(A[i])){
                filledSlots.add(A[i]);
                sum += 1;
            }
            if(sum == numOfSpaces){
                return i;
            }
        }
        return 0;
    }

    public int solution2(int X, int[] A) {
        int numOfSpaces = X;
        int sum = 0;
        boolean[] filledSlots = new boolean[X+1];
        for(int time = 0; time < A.length; time++){
            int pos = A[time];
            if(!filledSlots[pos]){
                filledSlots[pos] = true;
                sum += 1;
            }
            if(sum == numOfSpaces){
                return time;
            }
        }
        return 0;
    }

}
