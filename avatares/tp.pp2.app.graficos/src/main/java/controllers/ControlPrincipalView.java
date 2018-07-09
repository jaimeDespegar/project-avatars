package controllers;

import classProperties.KeyAvatarProperties;
import draftmans.GameTick;
import main.Constants;
import main.Game;
import object.Avatar;
import tablero.CreateMap;
import tablero.Map;
import views.PrincipalView;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		}
		
		else if (e.getSource() == this.principalView.getBtnPlay()) {
			this.principalView.getFrmPrincipalView().dispose();
			CreateMap createMap = new CreateMap(Constants.ROUTE_PROPERTIES);
			Map mapGame = createMap.getMap();
			KeyAvatarProperties keyss = new KeyAvatarProperties();
			mapGame.addBox(new Point(3,1), new Avatar(100,Orientation.RIGHT,1,keyss.getElectionKeyAvatar()));
			mapGame.addBox(new Point(2,4), new Avatar(100,Orientation.UP,2,null));
			GameTick game = new GameTick(createMap.getMap(), new Game());
			game.start();
		}
		
	}
	
}

