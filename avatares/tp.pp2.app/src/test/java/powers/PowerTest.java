package powers;

import org.junit.Test;

public class PowerTest {
	@Test
	public void powerAtackTest(){
		PowerAtack pa= new PowerAtack(2);
		pa.getDangerAtack();
		pa.setDangerAtack(pa.getDangerAtack());
	}
	
	@Test
	public void powerBasicTest(){
		PowerBasic pb= new PowerBasic(3);
		PowerBasic pb2= new PowerBasic();
		pb.atack();
		pb2.atack();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void powerDecoratorTest(){
		PowerDecorator pd= new PowerDecorator();
		//pd.atack();
	}
	
	@Test
	public void PowerDecoratorDoubleImpactTest(){
//		Power p= (Power) new PowerAtack(2);
//		PowerDecoratorDoubleImpact pddi= new PowerDecoratorDoubleImpact(p);
//		pddi.atack();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void PowerDecoratorFireTest(){
		PowerDecoratorFire pdf= new PowerDecoratorFire();
	}
	 
	
}
