package listeners;

import com.google.common.collect.Maps;
import enums.Orientation;
import object.Avatar;
import java.awt.*;
import java.util.Map;

public class AvatarListenerUp implements Listener, Moves {

    @Override
    public Point actionMove(Avatar avatar, Point positionInMap) {

        return createMoveByOrientataion(avatar.getOrientation(), positionInMap);

    }


    @Override
    public Point createMoveByOrientataion(Orientation o, Point p) {

        Map<Orientation, Point> map = Maps.newHashMap();

        map.put(Orientation.UP,    new Point(p.x,p.y-1));
        map.put(Orientation.DOWN,  new Point(p.x,p.y+1));
        map.put(Orientation.LEFT,  new Point(p.x-1, p.y));
        map.put(Orientation.RIGHT, new Point(p.x+1, p.y));

        return map.getOrDefault(o, p);
    }

}