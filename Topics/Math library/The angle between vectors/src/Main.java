import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt(); // Number of random numbers
        int K = scanner.nextInt(); // Upper limit of random numbers

        */

        int A = 7;
        int B = 9;
        int N = 4;
        int K = 100;
        int minInMaxValue = 0;
        int minInMaxKey = 0;
        Map<Integer, Integer> maxSeries = new HashMap<>();

        for (int i = A; i <= B; i++) {
            Random random = new Random(i);
            int maximumInSeries = 0;
            for (int j = 0; j < N; j++) {
                int randomGen = random.nextInt(K);
                maximumInSeries = Math.max(randomGen, maximumInSeries);
            }
            maxSeries.put(i, maximumInSeries);
        }

        minInMaxValue = Collections.min(maxSeries.values());
        for (Map.Entry<Integer, Integer> entry : maxSeries.entrySet()) {
            if (Objects.equals(minInMaxValue, entry.getValue())) {
                minInMaxKey = entry.getKey();
                break;
            }
        }
        System.out.println(minInMaxKey);
        System.out.println(minInMaxValue);
    }
}