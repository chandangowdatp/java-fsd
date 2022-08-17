import java.util.Scanner;
public class BubbleSort {
    static void bubbleSort(int arr[]) {
        for (int index1 = 0; index1 < arr.length-1; index1++){
            for (int index2 = 0; index2 < arr.length- index1 - 1; index2++){
                if(arr[index2] > arr[index2 + 1]){
                    // swapping
                    arr[index2] = arr[index2] + arr[index2 + 1];
                    arr[index2 + 1] = arr[index2] - arr[index2 + 1];
                    arr[index2] = arr[index2] - arr[index2 + 1];
                }


            }
        }
    }

    public static void main(String[] args) {
        BubbleSort BS = new BubbleSort();
        Scanner SC = new Scanner(System.in);

        System.out.print("Size of the array: ");
        int size = SC.nextInt();

        if(size <= 0 ) {
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

        int [] arr = new int[size];

        System.out.println();
        System.out.print("Enter the elements of the array in the space seperated format : ");
        for (int index = 0; index < size; index++) {
            arr[index] = SC.nextInt();
        }

        System.out.println();

        BS.bubbleSort(arr);


        System.out.print("Sorted array is: ");
        for (int element:arr) {
            System.out.print(element + " ");
        }
    }
}
