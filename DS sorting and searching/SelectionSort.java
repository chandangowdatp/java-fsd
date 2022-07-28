import java.util.Scanner;
public class SelectionSort {
    void selectionS (int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++){
                if (arr[index2] > arr[index1]) {
                    // swapping
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort SS = new SelectionSort();
        Scanner SC = new Scanner(System.in);

        System.out.print("Size of the array: ");
        int n = SC.nextInt();

        if(n <= 0 ) {
            boolean flag = true;
            while(flag) {
                System.out.println("\nInvalid Input !!!");
                System.out.print("Size of the array should be greater than 0: ");
                size = SC.nextInt();

                if(size > 0) {
                    flag = false;
                }
            }
        }

        int [] arr = new int[n];

        System.out.println();
        System.out.print("Enter the elements of the array in the space seperated format is: ");
        for (int i = 0; i < n; i++) {
            arr[i] = SC.nextInt();
        }

        System.out.println();

        SS.selectionS(arr);
        for (int ele:arr) {
            System.out.print(ele + " ");
        }
    }
}
