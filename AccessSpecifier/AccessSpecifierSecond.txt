package Firstpackage;

public class AccessSpecifierSecond {
	public static void main(String args[]){
		AccessSpecifier acc2=new AccessSpecifier();
		System.out.println("The list of methods we can able call in other class within same package");
		acc2.dispDefault(011);
		//acc.dispPrivate("chandan"); Can't accessible
		acc2.dispProtected(78.44);
		acc2.dispPublic(true);
	}
}
