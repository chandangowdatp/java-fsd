public class MergeSort {

    void merge(int arr[], int leftEnd, int mid, int rightEnd) {
        int size1 = mid - leftEnd + 1;
        int size2 = rightEnd - mid;

        int LeftArray[] = new int[size1];
        int RightArray[] = new int[size2];

        for (int index = 0; index < size1; ++index) {
            LeftArray[index] = arr[leftEnd + index];
        }
        for (int index = 0; index < size2; ++index) {
            RightArray[index] = arr[mid + 1 + index];
        }

        int index1 = 0, index2 = 0;
        int index3 = leftEnd;

        while (index1 < size1 && index2 < size2) {
            if (LeftArray[index1] <= RightArray[index2]) {
                arr[index3] = LeftArray[index1];
                index1++;
            }
            else {
                arr[index3] = RightArray[index2];
                index2++;
            }
            index3++;
        }

        while (index1 < size1) {
            arr[index3] = LeftArray[index1];
            index1++;
            index3++;
        }
        while (index2 < size2) {
            arr[index3] = RightArray[index2];
            index2++;
            index3++;
        }
    }

    void mergeS(int arr[], int leftEnd, int rightEnd) {
        if (leftEnd < rightEnd) {
            int mid =leftEnd+ (rightEnd-leftEnd)/2;
            mergeS(arr, leftEnd, mid);
            mergeS(arr, mid + 1, rightEnd);
            merge(arr, leftEnd, mid, rightEnd);
        }
    }

    public static void main(String[] args) {
        MergeSort MS = new MergeSort();
        Scanner SC = new Scanner(System.in);

        System.out.print("Size of the array: ");
        int size = SC.nextInt();

        if(size <= 0 ) {
            boolean flag = true;
            while(flag) {
                System.out.println("\nInvalid Input ");
                System.out.print("Size of the array must be greater than zero: ");
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

        MS.mergeS(arr, 0, arr.length-1);

        for (int element:arr) {
            System.out.print(element + " ");
        }
    }
}
