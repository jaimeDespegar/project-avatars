package object;

import enums.TypeOfStructure;

public class Structure extends ObjectGraphic{
	private TypeOfStructure typeOfStructure;
	
	public Structure(TypeOfStructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}

	public TypeOfStructure getTypeOfStructure() {
		return typeOfStructure;
	}
}
