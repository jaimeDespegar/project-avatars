package object;

import java.util.Objects;

public class KeyDto {

	private String keyName;
	private Integer keyValue;
	public static final String UP = "UP";
	public static final String DOWN = "DOWN";
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	public static final String POWER = "POWER";
	public static final String SHOOT = "SHOOT";


	public KeyDto(String keyName, Integer keyValue) {
		super();
		this.keyName = keyName;
		this.keyValue = keyValue;
	}

	public String getKeyName() {
		return keyName;
	}
	
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public Integer getKeyValue() {
		return keyValue;
	}
	
	public void setKeyValue(Integer keyValue) {
		this.keyValue = keyValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KeyDto keyDto = (KeyDto) o;
		return Objects.equals(keyValue, keyDto.keyValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(keyValue);
	}

	@Override
	public String toString() {
		return "KeyDto{" +
				"keyName='" + keyName + '\'' +
				", keyValue=" + keyValue +
				'}';
	}
}
