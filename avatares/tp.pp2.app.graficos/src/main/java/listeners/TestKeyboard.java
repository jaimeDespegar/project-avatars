package listeners;

import main.Game;
import object.KeyDto;
import turn.ManagerMove;

public class TestKeyboard {

    public static void main(String[] args) {

        GameKeyListener game = new GameKeyListener();
        KeyDto key = game.getKeyPressed();
        boolean sigue = true;
        //Hay poner los datos del juego en la clase Game
        ManagerMove m = new ManagerMove(new Game());
        m.manageMoves();

        System.out.println("se presiono la tecla escape " + key);

    }

}
