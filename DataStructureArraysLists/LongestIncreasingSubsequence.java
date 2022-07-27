import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static ArrayList<Integer> lis(int[] Arr){
        ArrayList sub = new ArrayList();
        ArrayList longsub = new ArrayList();

        int tempMax;
        int maxCount = 0;

        for(int index1 = 0; index1 < Arr.length; index1++) {
            tempMax = Integer.MIN_VALUE;

            for(int index2 = index1; index2 < Arr.length; index2++) {
                if(Arr[index2] > tempMax) {
                    sub.add(Arr[index2]);
                    tempMax = Arr[index2];
                }
            }

            if(maxCount < sub.size()) {
                maxCount = sub.size();
                longsub = new ArrayList(sub);    
                }

            sub.clear();    
        }
        return longsub;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("list size: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements : ");
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> Longestsub= lis(arr);
        System.out.print("Longest sub of length:" + Longestsub.size());
        System.out.println("Longest sub:"+Longestsub);
    }
}