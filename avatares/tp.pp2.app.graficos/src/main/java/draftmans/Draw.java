package draftmans;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.HashMap;

import dto.Configuration;
import enums.TypeOfStructure;
import object.Avatar;
import object.GameObject;
import object.Structure;
import tablero.Board;
import tablero.Box;

public class Draw  extends Canvas {
	private static final long serialVersionUID = 2L;//-6227038142688953660
	private Board board;

	public Draw(Board board) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(board.getBoxes().length*40, board.getBoxes()[0].length*40));
		setFocusable(true);
		requestFocus();
		this.board = board;
	}
	
	public void DrawImages() {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		DrawCommand.drawRectangleFill(g, 0, 0, board.getBoxes().length*40, board.getBoxes()[0].length*40, Color.black);
		
		for (int x = 0; x < this.board.getBoxes().length; x++) {
			for (int y = 0; y < this.board.getBoxes()[0].length; y++) {
				drawBox(g, this.board.getBoxes()[x][y], new Point (x*40,y*40));
			}
		}
		
		g.dispose();
		buffer.show();
	}
	private void drawBox(Graphics2D g, Box box, Point p) {
		HashMap<TypeOfStructure,String> listStructures = new HashMap<TypeOfStructure,String>();
		listStructures.put(TypeOfStructure.ACERO, Configuration.ROUTE_IMAGE_ACERO);
		listStructures.put(TypeOfStructure.AGUA, Configuration.ROUTE_IMAGE_AGUA);
		listStructures.put(TypeOfStructure.BOSQUE, Configuration.ROUTE_IMAGE_BOSQUE);
		listStructures.put(TypeOfStructure.LADRILLO, Configuration.ROUTE_IMAGE_LADRILLO);
		HashMap<Integer,String> listTanks = new HashMap<Integer,String>();
		listTanks.put(1, Configuration.ROUTE_IMAGE_TANK1);
		listTanks.put(2, Configuration.ROUTE_IMAGE_TANK2);
		System.out.println("si");
		if(box!=null) {
			if(listStructures.get((TypeOfStructure)((Structure)box.getObjectGraphic()).getTypeOfStructure())!=null){
				DrawCommand.drawImage(g, ChargerResource.loadImageTranslated(listStructures.get((TypeOfStructure)((Structure)box.getObjectGraphic()).getTypeOfStructure())), p);
			}
			else if((((Avatar)((GameObject) box.getObjectGraphic())).getId())!=null) {
				DrawCommand.drawImage(g, ChargerResource.loadImageTranslated(listTanks.get((((Avatar)((GameObject) box.getObjectGraphic())).getId()))), p);
			}
		}
	}
}
