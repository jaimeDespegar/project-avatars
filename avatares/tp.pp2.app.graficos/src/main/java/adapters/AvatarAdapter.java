package adapters;

import java.util.Arrays;
import java.util.List;
import classProperties.ElectionKeyAvatar;
import dto.AvatarDTO;
import dto.KeyDto;
import object.Avatar;

public class AvatarAdapter {

	
	public AvatarDTO buildAvatar(Avatar avatar, ElectionKeyAvatar election) {
		List<KeyDto> listKeys = buildKeysDTO(election);
		return new AvatarDTO(listKeys);
	}

	
	private List<KeyDto> buildKeysDTO(ElectionKeyAvatar election) {
		KeyDto up = new KeyDto("keyUp", election.getKeyUp());
		KeyDto down = new KeyDto("keyDown", election.getKeyDown());
		KeyDto left = new KeyDto("keyLeft", election.getKeyLeft());
		KeyDto right = new KeyDto("keyRight", election.getKeyRight());
		return Arrays.asList(up, down, left, right);
	}
	
}