package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class AddStructure {
	
	public static void addStructureByRectangle(Board board, Rectangle rectangle) {
		List<Point> positionsOfRectangle = new ArrayList<Point>();
		for(int x = rectangle.getPosition().x; x < rectangle.getPosition().x + rectangle.getSize().getX(); x ++) {
			for(int y = rectangle.getPosition().y; y < rectangle.getPosition().y + rectangle.getSize().getY(); y ++) {
				positionsOfRectangle.add(new Point(x,y));
			}
		}
		if(validatePositions(board, positionsOfRectangle)) {
			addStructures(board, positionsOfRectangle, rectangle.getStructure().getTypeOfStructure());
		}else {
			throw new IllegalArgumentException("uno o mas casilleros estan ocupados");
		}
	}


	public static void addStructureByLine(Board board, Line line) {
		List<Point> positionsOfLine = new ArrayList<Point>();
		
		
		if(validatePositions(board, positionsOfLine)) {
			addStructures(board, positionsOfLine, line.getStructure().getTypeOfStructure());
		}else {
			throw new IllegalArgumentException("uno o mas casilleros estan ocupados");
		}
	}
	
	private static boolean validatePositions(Board board, List<Point> positionsOfStructure) {
		for(Point pos : positionsOfStructure) {
			if(board.isOcupatePosition(pos)) {
				return false;
			}
		}
		return true;
	}

	private static void addStructures(Board board, List<Point> positionsOfRectangle, TypeOfStructure typeOfStructure) {
		// TODO Auto-generated method stub
		
	}
}

//creamos arrays de las posiciones en las cuales se quiere agregar la estructura (esto por rectangulo y otro por linea)
//contramos si las posiciones de las estructuras estan ocupadas o no (esto para ambos)
//agregamos las estructuras al tablero, si es que no estan ocupadas las posiciones (esto para ambos)