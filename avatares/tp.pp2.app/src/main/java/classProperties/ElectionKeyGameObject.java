package classProperties;

import object.KeyDto;

public class ElectionKeyGameObject {
	private KeyDto keyUp;
	private KeyDto keyDown;
	private KeyDto keyLeft;
	private KeyDto keyRight;
	private KeyDto keyShoot;
	private KeyDto keyPower1;
	private KeyDto keyPower2;
	
	public ElectionKeyGameObject(Integer keyUp, Integer keyDown, Integer keyLeft, Integer keyRight, Integer keyShoot, Integer keyPower1, Integer keyPower2) {
		this.keyUp = new KeyDto(KeyDto.UP, keyUp);
		this.keyDown = new KeyDto(KeyDto.DOWN, keyDown);
		this.keyLeft = new KeyDto(KeyDto.LEFT, keyLeft);
		this.keyRight = new KeyDto(KeyDto.RIGHT, keyRight);
		this.keyShoot = new KeyDto(KeyDto.SHOOT, keyShoot);
		this.keyPower1 = new KeyDto(KeyDto.POWER, keyPower1);
		this.keyPower2 = new KeyDto(KeyDto.POWER, keyPower2);
	}


	public KeyDto getKeyUp() {
		return keyUp;
	}
	public KeyDto getKeyDown() {
		return keyDown;
	}
	public KeyDto getKeyLeft() {
		return keyLeft;
	}
	public KeyDto getKeyRight() {
		return keyRight;
	}
	public KeyDto getKeyShoot() {
		return keyShoot;
	}
	public KeyDto getKeyPower1() {
		return keyPower1;
	}
	public KeyDto getKeyPower2() {
		return keyPower2;
	}


	@Override
	public String toString() {
		return "ElectionKeyGameObject [keyUp=" + keyUp + ", keyDown=" + keyDown + ", keyLeft=" + keyLeft + ", keyRight="
				+ keyRight + ", keyShoot=" + keyShoot + ", keyPower1=" + keyPower1 + ", keyPower2=" + keyPower2 + "]";
	}
	
	
}
