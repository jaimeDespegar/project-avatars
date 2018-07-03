package graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.util.List;

import tablero.Board;
import tablero.Box;

public class Drawer extends Canvas{
	private Board board;
	
	//primero dibujamos la pantalla principal, o creamos el tamaño de la imagen
	public Drawer(Board board) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(board.getBoxes().length*40, board.getBoxes()[0].length*40));//tamaño pantalla
		setFocusable(true);
		setVisible(true);
		requestFocus();
		this.board = board;
		drawAllMap(board);
	}

	/**Recibe un tablero, que contiene todas las casillas con los objetos graficos y los dibuja*/
	public void drawAllMap(Board board) {
		DrawAllMap.drawMap(board);
	}
	
	/**Recibe una lista de boxes o casilleros y los redibuja*/
	public void drawBoxes(List<Box> boxes) {
		for (Box box : boxes) {
			DrawBox.drawBox(box);
		}
	}
	
	/**Recibe una lista de secuencias, es decir se puede crear una lista de boxes, 
	 * como si fueran actualizaciones por segundo y las va dibujando*/
	public void drawShoot() {
		//DrawShoot();
	}
}
