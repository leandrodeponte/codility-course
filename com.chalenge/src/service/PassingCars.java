package service;

public class PassingCars {

     public int solution(int[] A) {
         int multiplier = 0;
         int colisions = 0;

         if(A.length <= 1){
             return 0;
         }

         for (int car : A) {
             if (isGoingRight(car)) {
                 multiplier++;
             }
             if (isGoingLeft(car)) {
                 colisions += multiplier;
             }
         }

         return colisions;
     }

    public int solution2(int[] A) {

        int[] suffixSum = new int[A.length + 1];
        if(A.length <= 1) {
            return 0;
        }
        for(int i=A.length-1; i >= 0; i--){
            suffixSum[i] += A[i] + suffixSum[i + 1];
        }

        int colisions = 0;
        for(int i=0; i < A.length; i++){
            if(isGoingRight(A[i])){
                colisions+=suffixSum[i];
            }
            if(colisions > 1000000000){
                return -1;
            }

        }

        return colisions;
    }

     public boolean isGoingRight(int car){
         return car == 0;
     }

    public boolean isGoingLeft(int car){
        return car == 1;
    }

     public static void example(){
         PassingCars d = new PassingCars();
         int[] list = new int[]{0,1,0,1,1};
         int[] list2 = new int[]{0,1,1};
         int[] list3 = new int[]{1,0};
         System.out.println(d.solution2(list));
         System.out.println(d.solution2(list2));
         System.out.println(d.solution2(list3));
     }
}
