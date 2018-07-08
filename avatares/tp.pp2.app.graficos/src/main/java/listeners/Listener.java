package listeners;

import object.Avatar;
import java.awt.*;

public interface Listener {

    Point actionMove(Avatar avatar, Point positionInMap);

}