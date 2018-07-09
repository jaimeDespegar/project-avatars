package turn;

import object.KeyDto;
import java.awt.event.*;

public class GameKeyListener implements KeyListener {

    private KeyDto keyPressed;

    public GameKeyListener()
    {
        super();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Presiono la tecla con key " + e.getKeyCode());
        keyPressed = new KeyDto("PRESSED", e.getKeyCode());
    }


    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Se solto la tecla con key : " + e.getKeyCode());
    }


    public KeyDto getKeyPressed() {
        return keyPressed;
    }

}