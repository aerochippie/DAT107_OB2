package uke_7_opp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class quickSortTestSameNumbers {

    @Test
    void likeelementerQuickSort() {
        int i = 100000;
        Integer[] array = new Integer[i];
        Arrays.fill(array, 5);
        long start = System.nanoTime();
        AlgoritmerSorterin.quickSort(array, 0, array.length - 1);
        long end = System.nanoTime();

        double tid = (end - start) / 1_000_000.0;


        System.out.println("tid: " + tid + " ms");
    }
}
