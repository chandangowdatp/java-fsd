public class QuickSort {

    void quickS( int arr[] , int start , int end ){
        if( start < end ){
            int pivot = partition( arr , start , end );
            quickS(arr, start, (pivot-1)); 
            quickS(arr, (pivot + 1), end);           
        }
    }


    int partition( int arr [], int P , int Q ){
        int pivot = Q;
        int index1 = P-1;

        for (int index2 = P; index2 <= Q ; index2++) {
            if(arr[index2] <= arr[pivot]) {
                index1++;
                int temp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
            }
        }
        return index1;
    }


    public static void main(String[] args) {
        QuickSort QS = new QuickSort();
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

        QS.quickS(arr, 0, arr.length-1);

        System.out.print("Sorted array: ");
        for (int element:arr) {
            System.out.print(element + " ");
        }
    }
}