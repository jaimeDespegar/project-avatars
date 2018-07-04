package listeners;

import com.google.common.collect.Maps;
import dto.KeyDto;
import java.util.Map;

public class FactoryListener {

    private Map<KeyDto, Listener> listenersKeys;
    private Listener listenerSpecialCase;

    public FactoryListener() {
        this.listenersKeys = Maps.newHashMap();
        this.listenerSpecialCase = new NoneListenerSpecialCase();
        this.loadListeners();
    }

    private void loadListeners() {
        this.listenersKeys.put(new KeyDto("UP", 56), new AvatarListenerUp());
        this.listenersKeys.put(new KeyDto("DOWN", 24), new AvatarListenerDown());
        this.listenersKeys.put(new KeyDto("LEFT", 65), new AvatarListenerLeft());
        this.listenersKeys.put(new KeyDto("RIGHT", 34), new AvatarListenerRight());
    }

    public Listener getListenerByKey(KeyDto key) {
        return this.listenersKeys.getOrDefault(key, this.listenerSpecialCase);
    }

}