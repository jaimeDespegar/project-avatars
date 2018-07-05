package dto;

import enums.Orientation;

public class KeyOrientationAvatar {
	private Integer key1Id;
	private Orientation key2Orientation;

	public KeyOrientationAvatar(Integer key1Id, Orientation key2Orientation) {
		this.key1Id = key1Id;
		this.key2Orientation = key2Orientation;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof KeyOrientationAvatar)) return false;
	        KeyOrientationAvatar key = (KeyOrientationAvatar) o;
	        return key1Id.equals(key.key1Id) && key2Orientation.equals(key.key2Orientation);
	    }

	    @Override
	    public int hashCode() {
	        return key1Id.hashCode()+key2Orientation.hashCode();
	    }
}
