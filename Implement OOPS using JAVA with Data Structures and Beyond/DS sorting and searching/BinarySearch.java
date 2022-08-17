import java.util.*;
public class BinarySearch {
    int binaryS(int arr[], int targetElement) {
        int leftEnd = 0, rightEnd = arr.length - 1, mid;

        while (leftEnd <= rightEnd) {
            mid = (leftEnd + rightEnd) / 2;

            if (arr[mid] == targetElement){
                return mid;
            }

            if (arr[mid] < targetElement) {
                leftEnd = mid + 1 ;
            }
            else {
                rightEnd = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        Scanner SC = new Scanner(System.in);
        BinarySearch BS = new BinarySearch();

        int arr[] = {1, 5, 2, 8, 10, 6, 11, 9, 0, 21, 7, 4, 13, 12};
        Arrays.sort(arr);       // sorting the array before going for binary search

        
        System.out.println();

        System.out.print("Target Element to be searched: ");
        int target = SC.nextInt();


        int index = BS.binaryS(arr, target);
        String result = index > 0 ? "Element is present in the array at position : " + (index+1) : "Element is not present in the the array.";

        System.out.println(result);


    }
}