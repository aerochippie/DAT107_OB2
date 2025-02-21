package uke_7_opp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SorteringTest {

    @Test
    public void testInsetning() {
        Integer[] array = {5, 23, 8, 11, 12};
        AlgoritmerSorterin.innsetningSorterting(array);
        assertArrayEquals(new Integer[]{5, 8, 11, 12, 23}, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = {9, 24, 126, 2, 37};
        AlgoritmerSorterin.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new Integer[]{2, 9, 24, 37, 126}, array);
    }
}