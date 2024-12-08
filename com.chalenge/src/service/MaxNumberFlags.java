package service;

import java.util.Arrays;

public class MaxNumberFlags {

    public int solution(int[] A) {

        int numberOfFlags = 0;

        if(A.length < 1 ){
            return 0;
        }
        int usedFlags = 0;
        int nextGap = 0;
        do {
            usedFlags = 0;
            nextGap = 0;
            for(int i = 0; i < A.length; i++){
                if(isPeak(i, A) && i > nextGap){
                    usedFlags++;
                    nextGap = i + numberOfFlags;
                }
            }
            if(usedFlags <= numberOfFlags){
                return numberOfFlags;
            }
            numberOfFlags++;
        } while(numberOfFlags <= usedFlags);

        return 0;
    }

    public int solution2(int[] A) {

        int currentPeak = A.length;
        int[] nextPeakArray = new int[A.length];
        int numberOfFlags = 0;
        long usedFlags = 0;
        do {
            usedFlags = 0;
            for(int i = A.length - 1; i >= 0; i--){
                if(isPeak(i, A) && (currentPeak - i > numberOfFlags)){
                    currentPeak = i;
                }
                nextPeakArray[i] = currentPeak;
            }
            usedFlags = Arrays.stream(nextPeakArray).distinct().count();
            if(usedFlags < numberOfFlags){
                return numberOfFlags;
            }
            numberOfFlags ++;
        } while(numberOfFlags > usedFlags);

        return 0;
    }


    private boolean isPeak(int index, int[] A){

        boolean isLeftMinor = false;
        boolean isRightMinor = false;

        if(index > 0 && A[index -1] < A[index]) {
            isLeftMinor = true;
        }

        if(index < A.length-1 && A[index + 1] < A[index]){
            isRightMinor = true;
        }

        return isRightMinor && isLeftMinor;
    }


    public static void example(){
        MaxNumberFlags d = new MaxNumberFlags();
        int[] list = new int[]{1,5,3,4,3,4,1,2,3,4,6,2};
        int[] list2 = new int[]{1,1,1};
        int[] list3 = new int[]{1,0};
        System.out.println(d.solution2(list));
//        System.out.println(d.solution(list2));
//        System.out.println(d.solution2(list3));

    }
}
