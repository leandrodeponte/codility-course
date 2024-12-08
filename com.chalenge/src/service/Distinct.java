package service;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

     public int solution(int[] A) {
         Set<Integer> set = new HashSet<>();
         for (int i = 0; i < A.length; i++) {
             set.add(A[i]);
         }
         return set.size();
     }

     public static void example(){
         Distinct d = new Distinct();
         int[] list = new int[]{23171, 21011, 21123,  21123,  21013,  21367};
         System.out.println(d.solution(list));
         list = new int[]{23171};
         System.out.println(d.solution(list));
         list = new int[]{23171, 2, 1};
         System.out.println(d.solution(list));
         list = new int[]{23171, 2, 1, 2};
         System.out.println(d.solution(list));
     }
}
