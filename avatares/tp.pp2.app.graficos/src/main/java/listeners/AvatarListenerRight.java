package listeners;

import java.awt.*;

public class AvatarListenerRight implements Listener {


    @Override
    public void doAction() {

    }

    public Point doActionN(Point p) {
        return new Point(p.x + 1 , p.y);
    }

}
