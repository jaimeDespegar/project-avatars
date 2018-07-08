package listeners;

import classProperties.ElectionKeyAvatar;
import com.google.common.collect.Maps;
import object.KeyDto;
import java.util.Map;

public class FactoryListener {

    private static FactoryListener instance;
    private Map<KeyDto, Listener> listenersKeys;
    private Listener listenerSpecialCase;

    private FactoryListener() {
        this.listenersKeys = Maps.newHashMap();
        this.listenerSpecialCase = new NoneListenerSpecialCase();
        //this.loadListeners();
    }

    public void loadListeners(ElectionKeyAvatar keys) {
        this.listenersKeys.put(keys.getKeyUp(), new AvatarListenerUp());
        this.listenersKeys.put(keys.getKeyDown(), new AvatarListenerDown());
        this.listenersKeys.put(keys.getKeyLeft(), new AvatarListenerLeft());
        this.listenersKeys.put(keys.getKeyRight(), new AvatarListenerRight());
    }

    public Listener getListenerByKey(KeyDto key) {
        return this.listenersKeys.getOrDefault(key, this.listenerSpecialCase);
    }

    public static FactoryListener getInstancie() {
        if (instance==null)
            instance = new FactoryListener();
        return instance;
    }

}