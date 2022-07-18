import java.util.Scanner;

class Operations{

    final static int add(int a,int b) {
    	return a+b;
    }
    final static int sub(int a,int b) {
    	return a-b;
    }
    final static int mul(int a,int b) {
    	return a*b;
    }
    final static double div(int a,int b) {
    	return (double)a/(double)b;
    }
}
class Calculator extends Operations{
	String w;
	Calculator(String w){
		this.w=w;
		System.out.println("...."+w+".....");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator obj=new Calculator("Calculator");
		final int n=1;
		while(n==1){
		System.out.println("Choose the operation:");
		System.out.println("1.Addition");
		System.out.println("2.Subtration");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		System.out.println("5.Exit");
		int s=sc.nextInt();
		if(s==5) {
			break;
		}
		System.out.print("Enter two numbers:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		if(s==1) {
			System.out.println("Addition Result:"+obj.add(a, b));
		}
		else if(s==2) {
			System.out.println("Subtration Result:"+obj.sub(a, b));
		}
		else if(s==3) {
			System.out.println("Multiplication Result:"+obj.mul(a, b));
		}
		else if(s==4) {
			System.out.println("Division Result:"+obj.div(a, b));
		}
		else {
			System.out.println("Enter valid input(1-5)");
		}
		}
	}

}
