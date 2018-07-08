package turn;

@SuppressWarnings("serial")
public class InvalidIdPlayerException extends RuntimeException {

	private static String messageDefault = "El id no se encuentra referenciado a ningun Player";

	public InvalidIdPlayerException() {
		super(messageDefault);
	}

}