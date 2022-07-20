public class methodExecution {
    final static double pi=3.14;
	public double areaOfCircle(int a) {
		double z=pi*a*a;;
		return z;
	}

	public static void main(String[] args) {

		methodExecution b=new methodExecution();
		double ans= b.areaOfCircle(4);
		System.out.println("areaOfCircle is :"+ans);
		}


}