package main;

import com.google.common.collect.Lists;
import object.Avatar;
import tablero.CreateMap;
import tablero.Map;
import java.util.List;

public class Game {

    private GameConfiguration configuration;
    private List<Avatar> avatars;
    private Map map;

    public Game() {
        this.avatars = Lists.newArrayList();
        initMap();
    }

    private void initMap() {
        CreateMap create = new CreateMap(Constants.ROUTE_PROPERTIES_PATH);
        this.map = create.getMap();
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    public Map getMap() {
        return map;
    }

    public List<Avatar> getAvatars() {
        return this.avatars;
    }

    public void deleteAvatar(Avatar avatar) {
        this.avatars.remove(avatar);
    }

    public boolean isFinish() {
        return this.avatars.size()==1;
    }

}