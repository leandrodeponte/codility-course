package service;

public class Slice {

    public int solution(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }
        int greaterAmount = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int amount = A[j] - A[i];
                if(greaterAmount < amount){
                    greaterAmount = amount;
                }
            }
        }
        return greaterAmount;
    }

    public int solution2(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }
        int greaterAmount = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : A) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > greaterAmount) {
                greaterAmount = price - minPrice;
            }
        }
        return greaterAmount;
    }

}
