package data_structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author prateek.bangre on 02/07/21.
 * @Project Algorithm_Study
 */
public class QuickSort {
/*
    //QuickSort normal java code
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int start, int end){
        int i = start + 1;
        int piv = arr[start] ;            //make the first element as pivot element.
        for(int j=start+1; j<=end ; j++)  {  //rearrange the array by putting elements which are less than pivot
                                             //on one side and which are greater that on other.
            if ( arr[ j ] < piv) {
                swap(arr, i, j);
                i += 1;
            }
        }
        swap( arr, start, i-1) ;  //put the pivot element in its proper place.
        return i-1;
    }

    private static void quick_sort(int[] arr, int start, int end){
        if( start < end ) {
            //stores the position of pivot element
            int piv_pos = partition(arr, start, end );
            quick_sort (arr, start , piv_pos -1);    //sorts the left side of pivot.
            quick_sort ( arr,piv_pos+1 , end) ; //sorts the right side of pivot.
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quick_sort(arr, 0, n - 1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
    */

    //QuickSort using stream
    private static List<Integer> quick_sort(List<Integer> arr){

        HashSet<Integer> set = new HashSet<>();
        int value = set.stream().findFirst().get();

        if (arr.size() < 2){
            // base case, arrays with 0 or 1 element are already "sorted"
            return arr;
        }else{
            // recursive case
            Integer pivot = arr.get(0);

            // sub-array of all the elements less than the pivot
            List<Integer> less = arr.stream().skip(1).filter( temp -> temp <= pivot).collect(Collectors.toList());

            // sub-array of all the elements greater than the pivot
            List<Integer> greater = arr.stream().skip(1).filter(temp -> temp > pivot).collect(Collectors.toList());

            return Stream.of(
                    quick_sort(less).stream(),
                    Stream.of(pivot),
                    quick_sort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        System.out.println(quick_sort(Arrays.asList(10, 7, 8, 9, 1, 5)));
    }

}
