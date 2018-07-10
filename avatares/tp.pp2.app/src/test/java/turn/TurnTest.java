package turn;

//import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import main.Game;

import org.junit.Test;

public class TurnTest {
	@Test
	public void avatarDisparaHachaTest(){
		Turn t= new Turn("Player1");
		t.isFinish();
		t.play();
	}
	
	@Test
	public void controlPlayerTurnTest(){
		List<String> users= new ArrayList<String>();
		users.add("UNO");
		users.add("DOS");
		ControllerPlayerTurn c= new ControllerPlayerTurn(users);
		c.next();
		ControllerPlayerTurn.instancie(users);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void GameKeyListenerTest(){
		GameKeyListener g= new GameKeyListener();
		//g.keyTyped(KeyEvent.VK_W);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void InvalidIdPlayerExceptionTest(){
		InvalidIdPlayerException i= new InvalidIdPlayerException();
	}
	
	@Test
	public void ManagerMoveTest(){
		Game game= new Game();
		ManagerMove m= new ManagerMove(game);
		m.isFinishGame();
		//m.isMyTurn("1");
		m.manageMoves();	
	}
	
	@Test
	public void PlayerTest(){
		Player p= new Player("1");
		p.getId();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void TimerTest(){
		Timer t= new Timer();
		Timer t2= new Timer(10);
		t.isFinish();
		t.initTime();
		t.run();
	}
	
	@Test
	public void T_Test(){
		Turn t= new Turn("player1");
		t.isFinish();
		t.play();
		
	}
	
}
