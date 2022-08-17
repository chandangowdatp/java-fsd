import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        optionsSelection(expenses);

    }
    
    private static void optionsSelection(ArrayList<Integer> expenses) {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }

        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        for(int j=1;j<=slen;j++){
            if(options==j){
                switch (options){
                    case 1:
                        if(expenses.size()==0){
                        System.out.println("Your are not saved any expenses\n"); 
                        optionsSelection(expenses);
                        break;
                        }
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection(expenses);
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        System.out.println(expenses+"\n");
                        optionsSelection(expenses);

                        break;
                    case 3:
                        if(expenses.size()==0){
                        System.out.println("Your expenses list is already empty\n"); 
                        optionsSelection(expenses);
                        break;
                        }
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection(expenses);
                        break;
                    case 4:
                        sortExpenses(expenses);
                        System.out.println("The sorted list is\n");
                        System.out.println(expenses+"\n");
                        optionsSelection(expenses);
                        break;
                    case 5:
                        System.out.println("Enter the expense you need to search:\t");
                        int targetElement = sc.nextInt();
                        sortExpenses(expenses);
                        int index=searchExpenses(expenses,targetElement);
                        String res=index > -1 ? "Expense is present in the sorted list at position : " + (index+1) : "Expense is not present in the the list.";
                        System.out.println(res);
                        optionsSelection(expenses);
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
            
    private static int searchExpenses(ArrayList<Integer> expenses,int targetElement) {
        int len =  expenses.size();
        int leftEnd = 0, rightEnd = len - 1, mid;

        while (leftEnd <= rightEnd) {
            mid = (leftEnd + rightEnd) / 2;

            if (expenses.get(mid) == targetElement){
                return mid;
            }

            if (expenses.get(mid) < targetElement) {
                leftEnd = mid + 1 ;
            }
            else {
                rightEnd = mid - 1;
            }
        }

        return -1;
    }
    
    private static void sortExpenses(ArrayList<Integer> expenses) {
        int len =  expenses.size();
       //Complete the method. The expenses should be sorted in ascending order.
          for (int i = 0; i < len; i++) {

          for (int j = len - 1; j > i; j--) {
              if (expenses.get(i) > expenses.get(j)) {

                  int tmp = expenses.get(i);
                  expenses.set(i,expenses.get(j)) ;
                  expenses.set(j,tmp);

              }

          }

      }
    }
}
