public class callMethod {

int a=20;

int operation(int a) {
	a =a+a;
	return(a);
}

public static void main(String args[]) {
	callMethod d = new callMethod();
	System.out.println("Before operation value of data is "+d.a);
	d.operation(100);
	System.out.println("After operation value of data is "+d.a);
	}
}
