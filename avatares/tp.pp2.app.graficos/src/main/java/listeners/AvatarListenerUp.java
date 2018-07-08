package listeners;

import object.Avatar;
import java.awt.*;

public class AvatarListenerUp implements Listener {

    @Override
    public Point actionMove(Avatar avatar, Point positionInMap) {
        return new Point(positionInMap.x, positionInMap.y + 1);
    }

}
