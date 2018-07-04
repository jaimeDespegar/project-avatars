package controllers;

import draftmans.Draftman;
import draftmans.GameDraftsman;
import dto.KeyDto;
import listeners.FactoryListener;
import listeners.GameKeyListener;
import listeners.Listener;
import main.Game;
import object.Avatar;

import java.util.List;

public class Controller {
	
	private Game game;
	private GameDraftsman gameDraftsman;
	private GameKeyListener keyListener;
	private FactoryListener factoryListener;

	public Controller(Game game, GameDraftsman draftman) {
		this.game = game;
		this.gameDraftsman = draftman;
        this.keyListener = new GameKeyListener();
        this.factoryListener = new FactoryListener();
	}

	
	public void init() 
	{
        showWindowGraphics();
		draftGame();
        initListeners();
    }

    private void initListeners() {
        KeyDto keyPressed = this.keyListener.getKeyPressed();
        Listener listener = this.factoryListener.getListenerByKey(keyPressed);
	    listener.doAction();
    }

    private void showWindowGraphics(){

    }

    private void draftGame() {
        gameDraftsman.draftMap();
        draftAvatars(game.getAvatars());
    }

    private void draftAvatars(List<Avatar> listAvatar) {
        listAvatar.forEach(a -> gameDraftsman.draftAvatar(a));
    }

}