package Secondpackage;
import Firstpackage.AccessSpecifier;
public class AccessSpecifierFourth {
	public static void main(String[] args) {
		AccessSpecifier acc4=new AccessSpecifier();
		System.out.println("The list of methods we can able call in different class different package");
		//acc4.dispDefault(011); Can't accessible
		//acc4.dispPrivate("chandan"); Can't accessible
		//acc4.dispProtected(78.44); Can't accessible
		acc4.dispPublic(true);

	}
}
