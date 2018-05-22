package tablero;

public class Map {
	private Board board;
	
	public Map(Builder builder) {
		board = builder.getBoard();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void printMap() {
		this.board.printBoard();
	}
	
	/*public void printMapWhithNameObject(){ //Quiero Imprimir el tablero con el nobre de cada Objeto ó si es null el casillero
		this.board.printBoardObjectName();
	}*/
}
