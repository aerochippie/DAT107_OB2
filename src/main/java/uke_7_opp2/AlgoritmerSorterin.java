package uke_7_opp2;

public class AlgoritmerSorterin {

    public static void innsetningSorterting(Integer[] arr){
        int x = arr.length;
        for(int i=1;i<x;i++){
            int j = i;
            while(j > 0 && arr[j-1].compareTo(arr[j])>0){
                Integer temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void utvalgsSortering(Integer[] arr){
        int x = arr.length;
        for (int i = 0; i < x - 1; i++) {
            int minste = i;
            for (int j = i + 1; j < x; j++) {
                if (arr[j] < arr[minste]) {
                    minste = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minste];
            arr[minste] = temp;
        }
    }

    public static void quickSort(Integer[] array, int venstre, int hoyre) {
        if (venstre < hoyre) {
            int pivotIndex = partition(array, venstre, hoyre);
            quickSort(array, venstre, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, hoyre);
        }
    }

    private static int partition(Integer[] array, int venstre, int hoyre) {
        int pivot = array[hoyre];
        int i = venstre - 1;

        for (int j = venstre; j < hoyre; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[hoyre];
        array[hoyre] = temp;

        return i + 1;
    }



}
