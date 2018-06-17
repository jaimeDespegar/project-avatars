package tablero;

import object.ObjectGraphic;

public class Box {
	private ObjectGraphic objectGraphic;
	
	public Box (ObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}

	public ObjectGraphic getObjectGraphic() {
		return objectGraphic;
	}

	public void setObjectGraphic(ObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}	
}
