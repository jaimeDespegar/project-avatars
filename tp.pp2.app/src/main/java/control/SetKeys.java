package control;

public class SetKeys {
	private Integer keyUp;
	private Integer keyDown;
	private Integer keyLeft;
	private Integer keyRight;
	private Integer keyShoot;
	private Integer keyPower1;
	private Integer keyPower2;
	
	public SetKeys(Integer keyUp, Integer keyDown, Integer keyLeft, Integer keyRight, Integer keyShoot, Integer keyPower1, Integer keyPower2) {
		super();
		this.keyUp = keyUp;
		this.keyDown = keyDown;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
		this.keyShoot = keyShoot;
		this.keyPower1= keyPower1;
		this.keyPower2= keyPower2;
	}


	public Integer getKeyUp() {
		return keyUp;
	}
	public Integer getKeyDown() {
		return keyDown;
	}
	public Integer getKeyLeft() {
		return keyLeft;
	}
	public Integer getKeyRight() {
		return keyRight;
	}
	public Integer getKeyShoot() {
		return keyShoot;
	}
	public Integer getKeyPower1() {
		return keyPower1;
	}
	public Integer getKeyPower2() {
		return keyPower2;
	}
	
}
