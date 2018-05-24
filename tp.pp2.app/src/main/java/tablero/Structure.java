package tablero;

import enums.TypeOfStructure;

public class Structure extends ObjectGraphic{
	private TypeOfStructure typeOfStructure;
	
	public Structure(TypeOfStructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}

	public TypeOfStructure getTypeOfStructure() {
		return typeOfStructure;
	}

	public void setTypeOfStructure(TypeOfStructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}
}
