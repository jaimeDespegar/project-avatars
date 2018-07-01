package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import graphics.DrawCommand;
import main.Constants;
import tablero.Box;

public class Draw extends Canvas{
	private static final long serialVersionUID = 2L;//-6227038142688953660
	private ArrayList<Box> data;

	public Draw(ArrayList<Box> data) {
		setIgnoreRepaint(true);
		//setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));//tamaño pantalla
		setFocusable(true);
		requestFocus();
		this.data = data;
	}
	
	public void DrawImages() {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
	//	DrawCommand.drawRectangleFill(g, 0, 0, Constants.WIDTH, Constants.HEIGHT, Color.black);
	
		//esto dibujaba los objetos graficos
	//	for(Box obj : data) {
	//		DrawCommand.drawImage(g, obj.getImage(), obj.getCoordinate());
	//	}
		
		g.dispose();
		buffer.show();
	}
}
