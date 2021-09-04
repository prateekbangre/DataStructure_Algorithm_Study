package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author prateek.bangre on 01/07/21.
 * @Project Algorithm_Study
 */
public class SelectionSort {

    // using arraylist
/*
    private static int findSmallNo(List<Integer> arr){
        int small = arr.get(0);
        int smallIndex = 0;
        for (int i=0; i<arr.size(); ++i){
            if (small > arr.get(i)){
                small = arr.get(i);
                smallIndex = i;
            }
        }
        return smallIndex;
    }
    private static List<Integer> selectionSort(List<Integer> arr){
        List<Integer> newArr = new ArrayList<>();
        int size = arr.size();
        for (int i=0; i<size; ++i){
            int smallIndex = findSmallNo(arr);
            newArr.add(arr.get(smallIndex));
            arr.remove(smallIndex);
        }
        return newArr;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(arr)); //[2, 3, 5, 6, 10]
    }
 */

    private static int[] selectionSort(int[] arr){
        int size = arr.length;

        for (int i=0; i<size; ++i){
            int smallIndex = i;
            for (int j=i+1; j<size; ++j){
                if (arr[smallIndex] > arr[j]){
                    smallIndex = j;
                }
            }

            //swap the element
            int temp = arr[smallIndex];
            arr[smallIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort(arr))); // [2, 3, 5, 6, 10]
    }
}
