package turn;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

public class FactoryPlayer {

	private static final Integer COUNTPLAYERS = 2;
	private Map<String, Player> players;
	
	
	public FactoryPlayer() {
		this.players = Maps.newHashMap();  
		this.buildPlayers();   
	}

	
	private void buildPlayers() {
		while(players.size() < COUNTPLAYERS) {
			String idGenereted = GeneratorIdPlayer.buildId();
			this.players.put(idGenereted, new Player(idGenereted));
		}
	}
	
	
	public Player getPLayerById(String idPlayer) {
		return Optional.ofNullable(this.players.get(idPlayer)).orElseThrow(InvalidIdPlayerException::new);
	}


	public List<String> getIds() {
		return players.keySet().parallelStream().collect(Collectors.toList());
	}
	
}