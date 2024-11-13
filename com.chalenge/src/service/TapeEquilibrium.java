package service;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int rightSum = 0;
        int leftSum = A[0];
        int position = 1;

        for(int number : A){
            rightSum += number;
        }

        rightSum -= leftSum;
        int smallestDiff = Math.abs(leftSum - rightSum);

        for(int i=1; i < A.length-1; i++){
            rightSum -= A[i];
            leftSum += A[i];
            int diff = Math.abs(leftSum - rightSum);
            if(diff < smallestDiff){
                smallestDiff = diff;
                position = i;
            }

        }
        return smallestDiff;
    }

}
