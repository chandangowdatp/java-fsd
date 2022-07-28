
import java.util.Arrays;
import java.util.Scanner;

public class ExponentialSearch {
    int exponentialS (int arr[], int targetElement) {
        int size = arr.length;

        if (arr[0] == targetElement) {
            return 0;
        }

        int index = 1;

        while (index < size && arr[index] <= targetElement) {
            index = index *2;
        }

        return Arrays.binarySearch(arr, index /2, Math.min(index, size), targetElement);
    }
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        ExponentialSearch ES = new ExponentialSearch();

        int arr[] = {1, 5, 2, 8, 10, 6, 11, 9, 0, 21, 7, 4, 13, 12};
        Arrays.sort(arr);       // sorting the array before going for binary search


        System.out.println();

        System.out.print("Target Element to be searched: ");
        int target = SC.nextInt();


        int index = ES.exponentialS(arr, target);
        String result = index > 0 ? "Element is present in the array at position : " + (index+1) : "Element is not present in the the array.";

        System.out.println(result);

    }
}
