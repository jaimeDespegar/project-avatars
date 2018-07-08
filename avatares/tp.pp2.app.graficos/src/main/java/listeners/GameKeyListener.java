package listeners;

import object.KeyDto;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    private KeyDto keyPressed;

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.keyPressed = new KeyDto("", keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.keyPressed = null;
    }

    public KeyDto getKeyPressed() {
        return keyPressed;
    }
}
