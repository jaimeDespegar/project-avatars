package listeners;

import object.Avatar;
import java.awt.*;

public class AvatarListenerDown implements Listener {

    @Override
    public Point actionMove(Avatar avatar, Point positionInMap) {
        avatar.turnToReverse();
        return positionInMap;
    }

}
