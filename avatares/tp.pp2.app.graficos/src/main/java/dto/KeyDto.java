package dto;

import java.util.Objects;

public class KeyDto {

	private String keyName;
	private Integer keyValue;
	
	
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
}
