import service.FishVeracious;

public class Main {
    public static void main(String[] args) {
        FishVeracious problem = new FishVeracious();
        int[] A = new int[]{4, 3, 2, 1, 5};
        int[] B = new int[]{0, 1, 0, 0, 0};
        System.out.println(problem.solution2( A, B));
    }
}