package object;

import java.awt.Point;

import org.junit.Test;

import classProperties.ElectionKeyAvatar;
import enums.Orientation;

public class ObjectTest {
	@Test
	public void avatarTest(){
		Avatar a = new Avatar(100, Orientation.RIGHT,1);
		ElectionKeyAvatar eka= new ElectionKeyAvatar(1,2,3,4,5,6,7);
		Avatar ak= new Avatar(100, Orientation.RIGHT, 1, eka);
		a.getReduceDamage();
		ak.getReduceDamage();
		a.setReduceDamage(1);
		ak.setReduceDamage(2);
		a.getId();
		ak.getId();
		a.turnToRight();
		ak.turnToRight();
		a.turnToLeft();
		ak.turnToReverse();
		ak.getKeys();
	}
	
	@Test
	public void avatarWithShieldTest(){
		AvatarWithShield aws= new AvatarWithShield(100, Orientation.RIGHT);
		aws.getReduceDamage();
		aws.setReduceDamage(1);
		aws.getPosition();
		aws.setPosition(aws.getPosition());
	}
	
	@Test
	public void avatarBuilderTest(){
		AvatarBuilder ab= new AvatarBuilder();
		AvatarBuilder.create();
		ab.build();
		ab.withShield();
		ab.withLife(100);
		ab.withOrienttion(Orientation.DOWN);
		ab.withOutShield();
	}
	
	@Test
	public void weaponTest(){
		Weapon w= new Weapon(50, 3, Orientation.RIGHT);
		w.getDamage();
		w.setDamage(w.getDamage());
		w.getShootingRange();
		w.setShootingRange(w.getShootingRange());
		w.isActive();
		w.setActive(true);
		w.getOrientation();
		w.setOrientation(Orientation.LEFT);
		w.colissionObject();
		w.setPosition(new Point(0,0));
		w.getPosition();
		w.colissionGameObject(w);
		w.colissionStructure(w);
		w.colissionWithObject(w);
	}
	
	@Test
	public void GameObjectTest(){
		GameObject go= new GameObject(100, Orientation.RIGHT);
		go.gameObjectMaxHealthy();
		go.getVida();
		go.setVida(50);
		go.getOrientation();
		go.setOrientation(go.getOrientation());
		go.getReduceDamage();
		go.setReduceDamage(go.getReduceDamage());
		go.setPosition(new Point(1,1));
		go.getPosition();
	}
	
	@Test
	public void KeyDTOTest(){
		KeyDto kd= new KeyDto("up", 1);
		kd.getKeyName();
		kd.setKeyName(kd.getKeyName());
		kd.getKeyValue();
		kd.equals(kd);
		kd.hashCode();
		kd.toString();
		
	}
	
}
