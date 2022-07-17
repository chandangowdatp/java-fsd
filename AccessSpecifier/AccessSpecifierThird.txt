package Secondpackage;

import Firstpackage.AccessSpecifier;

public class AccessSpecifierThird extends AccessSpecifier {

	public static void main(String[] args) {
		AccessSpecifierThird acc3=new AccessSpecifierThird();
		System.out.println("The list of methods we can able call in child class in different package");
		//acc3.dispDefault(011); Can't accessible
		//acc3.dispPrivate("chandan"); Can't accessible
		acc3.dispProtected(78.44);
		acc3.dispPublic(true);

	}
}
