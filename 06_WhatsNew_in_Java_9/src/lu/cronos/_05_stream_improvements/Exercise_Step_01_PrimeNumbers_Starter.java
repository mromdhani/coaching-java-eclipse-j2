package lu.cronos._05_stream_improvements;

import java.util.ArrayList;
import java.util.List;

public class Exercise_Step_01_PrimeNumbers_Starter {

    public static void main(String[] args) {

        List<Integer> collect = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (isPrime(i)) {
                collect.add(i);
            }
        }

        for (Integer prime : collect) {
            System.out.format("%s\t", prime);
        }

        System.out.println("\nTotal: " + collect.size());

    }

    private static boolean isPrime(int number) {

        if (number <= 1) return false;    //  1 is not prime and also not composite

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}