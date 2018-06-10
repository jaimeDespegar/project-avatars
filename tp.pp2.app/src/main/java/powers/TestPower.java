package powers;

public class TestPower {

	
	public static void main(String[] args) {

		Power basic = new PowerBasic();
		PowerDecoratorFire fire = new PowerDecoratorFire();  
		Power doubleFire = new PowerDecoratorDoubleImpact(fire);
		
		System.out.println("Este es el resultado " + doubleFire.atack().getDangerAtack());
	}

}
