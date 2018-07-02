package turn;

import java.util.List;
import com.google.common.collect.Lists;

public class ControllerPlayerTurn {

	private static ControllerPlayerTurn instancie = null;
	private List<String> users;
	private Integer index = -1;
	
	private ControllerPlayerTurn(List<String> ids) {
		this.users = Lists.newLinkedList();
		this.users.addAll(ids);
	}
	
	
	public String next() {
		this.incrementIndex();
		return this.users.get(index);
	}
	
	
	private void incrementIndex() {
		index += 1;
		index = isStopSize() ? 0 : index;
	} 
	
	
	private boolean isStopSize() {
		return index==users.size();
	}
	
	
	public static ControllerPlayerTurn instancie(List<String> list) {
		if (instancie == null) {
			instancie = new ControllerPlayerTurn(list);
		}
		return instancie;
	}
}
