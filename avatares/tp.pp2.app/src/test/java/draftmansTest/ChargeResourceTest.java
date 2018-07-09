package draftmansTest;

import org.junit.Test;

import draftmans.ChargerResource;
import draftmans.Configuration;

public class ChargeResourceTest {
	
	@Test
	public void loadImageTest(){
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_ACERO);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_AGUA);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_BOSQUE);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_LADRILLO);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_FONDO);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK1);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK2);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK1UP);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK1RIGHT);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK1LEFT);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK1DOWN);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK2UP);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK2RIGHT);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK2LEFT);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_TANK2DOWN);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_AX);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_BAZOOKA);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_BULLETDOUBLEDAMAGE);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_SHOTGUN);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_FIRE);
		ChargerResource.loadImageTranslated(Configuration.ROUTE_IMAGE_WEAPON_EXPLOSION);
		//ChargerResource.loadImageTranslated(Configuration.ROUTE_MAP_PROPS);
	}
}
