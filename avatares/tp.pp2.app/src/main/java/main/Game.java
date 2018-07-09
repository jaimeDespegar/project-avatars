package main;

import classProperties.ElectionKeyAvatar;
import classProperties.KeyAvatarProperties;
import com.google.common.collect.Lists;
import enums.Orientation;
import object.Avatar;
import tablero.CreateMap;
import tablero.Map;
import java.util.List;

public class Game {

    private GameConfiguration configuration;
    private List<Avatar> avatars;
    private Map map;

    public Game() {
        initMap();
        initAvatares();
    }

    private void initMap() {
        CreateMap create = new CreateMap(Constants.ROUTE_PROPERTIES);
        this.map = create.getMap();
    }

    public void initAvatares() {
        this.avatars = Lists.newArrayList();

        KeyAvatarProperties propertiesPlayer = new KeyAvatarProperties();
        propertiesPlayer.loadPropertiesByRoute(Constants.ROUTE_PROPERTIES_Avatar);
        ElectionKeyAvatar keysAvatarOne = propertiesPlayer.getElectionKeyAvatar();
        propertiesPlayer.loadPropertiesByRoute(Constants.ROUTE_PROPERTIES_AvatarWithShield);
        ElectionKeyAvatar keysAvatarTwo = propertiesPlayer.getElectionKeyAvatar();

        System.out.println("player 1 keys " + keysAvatarOne);
        System.out.println("player 2 keys " + keysAvatarTwo);

        this.avatars.add(new Avatar(100, Orientation.RIGHT,1, keysAvatarOne));
        this.avatars.add(new Avatar(100, Orientation.UP,2, keysAvatarTwo));
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