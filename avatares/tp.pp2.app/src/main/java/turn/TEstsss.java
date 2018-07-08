package turn;

import java.util.concurrent.TimeUnit;

public class TEstsss {

	public static void main(String[] args) {
		
		//test para calcular el tiempo que tardo el turno
		long init = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long fin = System.currentTimeMillis();
		System.out.println("segundos : " + ((fin - init)/1000));

	}

}
