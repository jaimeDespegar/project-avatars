package criteriaOfAcceptance;

/**
 * 
 * Crear un mapa vac�o con un tama�o de 6x6.
 
  _Si creo una l�nea horizontal (5,5) al (5,7), se va de rango, no es v�lido.
  _Si creo una l�nea horizontal (4,4) al (5,4), est� dentro del rango, es v�lido.
  _Si creo una l�nea vertical (5,5) al (7,5), se va de rango, no es v�lido.
  _Si creo una l�nea vertical (5,4) al (5,5), est� dentro del rango, es v�lido.
  _Si creo una l�nea diagonal (4,4) al (6,6), se va de rango, no es v�lido.
  _Si creo una l�nea diagonal (4,4) al (5,5), est� dentro del rango, es v�lido.

 * Se ingresan las posiciones {(4,5),(1,2)} , {(1,3),(1,5)} y {(3,1), (4,1)}, por lo tanto, la l�nea va del punto (4,5), 
 hasta el (1,2), despu�s del (1,3) al (1,5), luego del (3,1) al (4,1) como todas est�n libres, se agregan todas las estructuras. 
 
  _Se ingresan las posiciones {(2,5),(5,5)}, por lo tanto, la l�nea va del punto (2,5), hasta el (5,5), como la posici�n (4,5)
   est� ocupada, no se agrega ninguna estructura de la l�nea ingresada. 
  _Si se ingresan los puntos {(1,1), (3,2)}, no se puede debido a que no forman una l�nea recta ( horizontal, vertical o diagonal).
  _Si se ingresan los puntos {(4,4), (2,4)}, no se puede ya que los casilleros que est�n dentro del recorrido se encuentra el (3,4)
   que est� ocupado.
  _Si se ingresan 2 puntos a los cuales no se pueda trazar una l�nea horizontal, vertical o diagonal. Entonces, no se podr� dibujar
   una l�nea de objetos de estructuras. Ejemplo: {(4,2}, (2,1)}. 
 *
 */
public class UserStory_04 {
	
}
