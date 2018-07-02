package turn;

public class GeneratorIdPlayer {

	private static Integer countPlayer=0;
	
	public static String buildId() 
	{ 
		incrementCount();
		return countPlayer.toString();
	}

	private static void incrementCount() {
		countPlayer = countPlayer + 1;
	}
	
}
