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
import object.Structure;
import tablero.Box;
import tablero.Map;

public class MapDraftman extends Canvas implements Draftman  { 
	private Map map;
	
	public MapDraftman(Map map) 
	{
		this.map = map;
	}
	
	@Override
	public void createWindow() {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(this.map.getBoard().getBoxes().length*40, this.map.getBoard().getBoxes()[0].length*40));//tamaño pantalla
		setFocusable(true);
		setVisible(true);
		requestFocus();
	}
	
	public void drafWindow() {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		DrawCommand.drawRectangleFill(g, 0, 0, this.map.getBoard().getBoxes().length*40, this.map.getBoard().getBoxes()[0].length*40, Color.black);
		g.dispose();
		buffer.show();
	}
	
	@Override
	public void draftMap() 
	{
		// hacer todo para dibujar el mapa ! 
		for (int x = 0; x < this.map.getBoard().getBoxes().length; x++) {
			for (int y = 0; y < this.map.getBoard().getBoxes()[0].length; y++) {
				drawBox(this.map.getBoard().getBoxes()[x][y], new Point (x,y));
			}
		}
	}

	private void drawBox(Box box, Point p) {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		
		
		HashMap<TypeOfStructure,String> listStructures = new HashMap<TypeOfStructure,String>();
		listStructures.put(TypeOfStructure.ACERO, Configuration.ROUTE_IMAGE_ACERO);
		listStructures.put(TypeOfStructure.AGUA, Configuration.ROUTE_IMAGE_AGUA);
		listStructures.put(TypeOfStructure.BOSQUE, Configuration.ROUTE_IMAGE_BOSQUE);
		listStructures.put(TypeOfStructure.LADRILLO, Configuration.ROUTE_IMAGE_LADRILLO);
		DrawCommand.drawImage(g, ChargerResource.loadImageTranslated(listStructures.get((TypeOfStructure)((Structure)box.getObjectGraphic()).getTypeOfStructure())), p);

		HashMap<Integer,String> listTanks = new HashMap<Integer,String>();
		listTanks.put(1, Configuration.ROUTE_IMAGE_TANK1);
		listTanks.put(2, Configuration.ROUTE_IMAGE_TANK2);
		DrawCommand.drawImage(g, ChargerResource.loadImageTranslated(listStructures.get((((Avatar) box.getObjectGraphic()).getId()))), p);

		
		g.dispose();
		buffer.show();
	}

	@Override
	public void updateMap() {
		// TODO Auto-generated method stub
		
	}


}
