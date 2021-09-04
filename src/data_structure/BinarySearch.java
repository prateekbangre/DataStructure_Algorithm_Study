package data_structure;

/**
 * @author prateek.bangre on 28/06/21.
 * @Project Algorithm_Study
 */
public class BinarySearch {

    public static boolean isListEmpty(int[] myList) {
        int listSize = myList.length;
        return (listSize == 0);
    }

    public static boolean guessEqualsItem(int guess, int item) {
        return (guess == item);
    }

    public static boolean guessGreaterThanItem(int guess, int item) {
        return (guess > item);
    }

    public static boolean guessLessThanItem(int guess, int item) {
        return (guess < item);
    }

    public static int binarySearch(int[] list, int item) {
        if (isListEmpty(list)) {
            return -1;
        }

        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];

            if (guessEqualsItem(guess, item)) {
                return mid;
            } else if (guessGreaterThanItem(guess, item)) {
                high = mid - 1;
            } else if(guessLessThanItem(guess, item)) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myList = {87, 21, 45, 93};

        System.out.println(binarySearch(myList, 93));
        System.out.println(binarySearch(myList, 16));
    }
}
