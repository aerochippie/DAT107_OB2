package uke_7_opp2;

import java.util.Random;

import static uke_7_opp2.AlgoritmerSorterin.*;

public class Main {
    public static void main(String[] args){

        int[] n = {32000, 64000, 128000};
        String[] sorteringer={"Innsetnings","Utvalgssortering","QuickSort"};
        System.out.printf("%-20s %-20s %-10s %-10s%n","Soretringstype","N","tid(ms)","c*f(n)");



        for (String type : sorteringer) {
            double c=1;

            for (int i : n) {
                Integer[] arrayRandom = generateRandomArray(i);
                long start = System.nanoTime();

                switch (type) {
                    case "Innsetnings":
                        innsetningSorterting(arrayRandom);
                        break;
                    case "Utvalgssortering":
                        utvalgsSortering(arrayRandom);
                        break;
                    case "QuickSort":
                        quickSort(arrayRandom, 0, arrayRandom.length - 1);
                        break;

                }

                long end = System.nanoTime();
                double tidMs = (end - start) / 1_000_000.0;


                if (i == 32000) {
                    c = tidMs / beregnN(type, i);
                }

                double teoretisktid = c * beregnN(type, i);
                System.out.printf("%-20s %-20d %-20.2f %-20.2f%n", type, i, tidMs, teoretisktid);
            }
            System.out.println();
    }

}
    private static Integer[] generateRandomArray(int size) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000000);
        }
        return array;
    }
    private static double beregnN(String type, int n) {
        return switch (type) {
            case "Innsetnings", "Utvalgssortering" -> Math.pow(n, 2);
            case "QuickSort" -> n * Math.log(n) / Math.log(2);
            default -> 1;
        };
    }
}
