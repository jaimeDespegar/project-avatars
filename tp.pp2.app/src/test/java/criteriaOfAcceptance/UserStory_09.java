package criteriaOfAcceptance;

/**
 * 
 * Se crea un mapa de tama�o 5x5,  se crea un rect�ngulo ((1,2), (2,2), acero), y dos avatares (Avatar y Enemy). 
   El primero est� en la posici�n (1,1), tiene un disparo de escopeta, y el segundo avatar en la posici�n (4,2), 
   tiene un disparo de bazooka.
   Despu�s de 8 turnos, en los cu�les los avatares no se movieron, a cada uno de ellos le aparece un poder aleatorio, 
   no necesariamente es el mismo.
	
  _Si el Avatar, tiene el poder de supervelocidad, lo usa y se mueve a la �derecha�, �abajo� y �abajo�, 
   quedando en la posici�n (2,2), teniendo en cuenta de que el avatar no puede ocupar un lugar ocupado o fuera del mapa.
  _Si el Avatar, tiene el poder de supervelocidad, lo usa y se mueve a la �derecha�, �arriba� y �izquierda�, 
   queda en la posici�n (1,1), teniendo en cuenta de que el avatar no puede ocupar un lugar ocupado o fuera del mapa.
  _Si el Avatar, tiene el poder de supervelocidad, lo usa y se mueve a la �derecha�, �abajo� y �abajo�, 
   quedando en la posici�n (2,2)  (teniendo en cuenta de que el avatar no puede ocupar un lugar ocupado o fuera del mapa).
  _Si el Enemy, tiene el poder de superfuerza, se mueve hacia �arriba�, 
   quedando en la posici�n (4,2) (teniendo en cuenta de que el avatar no puede ocupar un lugar ocupado o fuera del mapa).
  _Si el avatar se encuentra en la posici�n (4,4), usa el poder de invulnerabilidad no recibe da�os por 3 turnos, 
   por disparos recibidos del otro avatar (que haya disparado hacia la �izquierda� en la posici�n (7,4)).

 *
 */

public class UserStory_09 {

}
