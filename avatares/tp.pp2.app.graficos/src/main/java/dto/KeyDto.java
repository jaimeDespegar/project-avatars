package dto;

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
	
}
