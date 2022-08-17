package Firstpackage;

public class AccessSpecifier {
	//Default AccessSpecifier
	void dispDefault(int id) {
		System.out.println("(default) id:"+id);	
	}
	//private AccessSpecifier
	private void dispPrivate(String name) {
		System.out.println("(private) id:"+name);	
	}
	
	//protected AccessSpecifier
	protected void dispProtected(double marks) {
		System.out.println("(protected) marks:"+marks);	
	}
	
	//public AccessSpecifier
	public void dispPublic(boolean res) {
		System.out.println("(public) pass:"+res);	
	}
	

	public static void main(String[] args) {
		AccessSpecifier acc=new AccessSpecifier();
		System.out.println("The list of methods we can able call within the same class");
		acc.dispDefault(011);
		acc.dispPrivate("chandan");
		acc.dispProtected(78.44);
		acc.dispPublic(true);
       
	}

}
