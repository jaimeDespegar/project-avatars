package controllers;

import main.Constants;
import object.Avatar;
import tablero.CreateMap;
import views.PrincipalView;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import draftmans.GameTick;
import enums.Orientation;

public class ControlPrincipalView implements ActionListener{
	
	private PrincipalView principalView;
	
	public ControlPrincipalView() {
		principalView = new PrincipalView();
		this.principalView.getBtnPlay().addActionListener(this);
		this.principalView.getBtnConfiguration().addActionListener(this);
		this.principalView.getBtnAccept().addActionListener(this);
	}
	
	public void iniciar() {
		this.principalView.getFrmPrincipalView().setVisible(true);
		this.principalView.getPrincipalMain().setVisible(true);
		this.principalView.getRdbtnTank().setSelected(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.principalView.getBtnConfiguration()) {
			this.principalView.getConfigurationPanel().setVisible(true);
		}
		
		else if (e.getSource() == this.principalView.getBtnAccept()) {

			this.principalView.getConfigurationPanel().setVisible(false);
/*
			String up = this.principalView.getTextFieldUp().getText();
			String down = this.principalView.getTextFieldDown().getText();
			String left = this.principalView.getTextFieldLeft().getText();
			String right = this.principalView.getTextFieldRight().getText();
			//String shoot = this.principalView.getTextShoot().getText(); // AGREGAR TECLA DE DISPARO
			// guardar informacion de la configuracion

			EleccionMenu eleccion = new EleccionMenu(up, down, left, right, "shoot", 300, 300, 40, 40, "image");
			Principal principal = new Principal();
			principal.modificarArchivo(eleccion);
			*/
		}
		
		else if (e.getSource() == this.principalView.getBtnPlay()) {
			this.principalView.getFrmPrincipalView().dispose();
			CreateMap createMap = new CreateMap(Constants.ROUTE_PROPERTIES);
			createMap.createMap();
			createMap.getMap().addBox(new Point(3,1), new Avatar(100,Orientation.RIGHT,1));
			createMap.getMap().addBox(new Point(2,4), new Avatar(100,Orientation.UP,2));
			GameTick game = new GameTick(createMap.getMap().getBoard());
			game.start();

		}
		
	}
	
}

