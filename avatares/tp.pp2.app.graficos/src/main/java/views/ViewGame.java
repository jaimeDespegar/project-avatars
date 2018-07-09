package views;

import javax.swing.*;

import draftmans.Draw;

import java.awt.*;
import java.awt.event.KeyListener;

public class ViewGame {		

	private static JFrame view;
	
	public ViewGame(Draw draw, KeyListener listener){
		configureView(draw,listener);
	}
	
	public void configureView(Draw draw, KeyListener listener){
		view = new JFrame("Avatars");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//view.setIconImage(icon.getImage());
		view.setResizable(false);
		view.setLayout(new BorderLayout());
		view.add(draw, BorderLayout.CENTER);
		view.setUndecorated(true);
		view.pack();
		view.setLocationRelativeTo(null);
		view.setVisible(true);

		view.setFocusable(true);
		view.addKeyListener(listener);
	}
}
