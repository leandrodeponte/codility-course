package service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class FishVeracious {

    public int solution(int[] A, int[] B) {
        LinkedList<Integer> fish = new LinkedList<>();
        Arrays.stream(B).forEach(fish::add);
        int index = 0;
        int survivors = B.length;

        for(Integer fishValue : A) {
            Integer currentFish = fish.pop();
            if(fish.isEmpty()){
                return survivors;
            }
            int currentFishWeight = A[index];
            Integer nextFish = fish.peek();
            int nextFishWeight = A[index + 1];
            if(isRight(currentFish) && isLeft(nextFish) ){
                if(currentFishWeight > nextFishWeight){
                    fish.pop();
                    fish.addFirst(currentFish);
                }
                survivors--;
            }
            index++;
        }
        return survivors;
    }

    public int solution2(int[] A, int[] B) {

        Stack<Integer> survivorFish = new Stack<Integer>();

        int index = 0;
        int survivors = B.length;
        int lastFishWeight = 0;

        for(Integer fishValue : B) {
            int currentFishWeight = A[index];
            if(isLeft(fishValue)){
                survivorFish.push(fishValue);
            }
            if(isRight(fishValue)) {

                if(currentFishWeight > lastFishWeight) {
                    survivorFish.pop();
                    survivorFish.push(fishValue);
                }
            }
            lastFishWeight = currentFishWeight;
            index++;
        }
        return survivors;
    }

    private Boolean isLeft(Integer fish){
        return fish == 0;
    }
    private Boolean isRight(Integer fish){
        return fish == 1;
    }

}
