public class typeCasting {

	public static void main(String[] args) {
		
		//Implicit
		System.out.print("Implicit Type Casting");
		char a='C';
		System.out.print("\nChar value of C:"+a);
		
	    int b=a;
	    System.out.print("\nint value of C:"+b);
	    
	    long c=b;
	    System.out.print("\nlong value of C:"+c);
	    
	    float d=c;
	    System.out.print("\nfloat value of C:"+d);
	    
	    double e=d;
	    System.out.print("\ndouble value of C:"+e);
	    e=e+0.75;
	    //Explicit Type Casting
	    System.out.print("\nExplicit Type Casting for:"+e);
	    short f=(short)e;
	    System.out.print("\nshort value:"+f);
	    
	    byte g=(byte)e;
	    System.out.print("\nbyte value:"+g);  
	    
	    int h=(int)e;
	    System.out.print("\nint value:"+h);
	}
}

