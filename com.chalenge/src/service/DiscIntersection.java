package service;

import domain.Range;
import java.util.*;

public class DiscIntersection {

     public int solution(int[] A) {
        List<Range> ranges = new ArrayList<>();

        if(A.length <= 1){
            return -1;
        }

        for(int i = 0; i < A.length; i++ ){
            ranges.add(new Range(i-A[i], i+A[i]));
        }

        var sortedRange = ranges
                .stream()
                .sorted(Comparator.comparing(range -> range.start))
                .toList();

        var intersections = 0;

         for(int i = 0; i < A.length; i++ ){
             var pivot = sortedRange.get(i);
             for(int j = i + 1; i < A.length; i++ ){
                 var validating = sortedRange.get(j);
                 if(isIntersection(pivot, validating)){
                     intersections++;
                 }
                 if(intersections > 10000000){
                    return -1;
                 }
             }
         }

         return intersections;
     }


     private static Boolean isIntersection(Range range1, Range range2){
        if((range1.start <= range2.start) && (range1.finish >= range2.start)) {
            return true;
        }
        if((range1.start <= range2.finish) && (range1.finish >= range2.finish)) {
            return true;
        }
        return false;
     }

//    public int solution2(int[] A) {
//        List<Range> ranges = new ArrayList<>();
//
//        if(A.length <= 1){
//            return -1;
//        }
//
//        for(int i = 0; i < A.length; i++ ){
//            ranges.add(new Range(i-A[i], i+A[i]));
//        }
//
//        var sortedRange = ranges
//                .stream()
//                .sorted(Comparator.comparing(range -> range.start))
//                .toList();
//
//        var intersections = 0;
//        var currPos = 0;
//
//
//        while(currPos < A.length){
//            var pivot = sortedRange.get(currPos);
//
//        }
//
//
//
//        return intersections;
//    }


     public static void example(){
         DiscIntersection d = new DiscIntersection();
         int[] list = new int[]{1, 5, 2, 1, 4, 0};
         System.out.println(d.solution(list));

     }
}
