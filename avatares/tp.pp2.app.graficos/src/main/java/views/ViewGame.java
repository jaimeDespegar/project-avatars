package views;

import javax.swing.*;
import java.awt.*;

public class ViewGame {		

	private static JFrame view;
	
	public ViewGame(){ // Draw draw
		//BufferedImage image = LoadImage.loadImageTranslated(Constants.ROUTE_ICON);
		//this.icon = new ImageIcon(image);
		configureView();
	}
	
	public void configureView(){
		view = new JFrame("Avatars");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//view.setIconImage(icon.getImage());
		view.setResizable(false);
		view.setLayout(new BorderLayout());
		//view.add(draw, BorderLayout.CENTER);
		view.setUndecorated(true);
		view.pack();
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}
}
