package criteriaOfAcceptance;

/**
 * 
 * Crear un mapa vacío con un tamaño de 6x6.
 
  _Si creo una línea horizontal (5,5) al (5,7), se va de rango, no es válido.
  _Si creo una línea horizontal (4,4) al (5,4), está dentro del rango, es válido.
  _Si creo una línea vertical (5,5) al (7,5), se va de rango, no es válido.
  _Si creo una línea vertical (5,4) al (5,5), está dentro del rango, es válido.
  _Si creo una línea diagonal (4,4) al (6,6), se va de rango, no es válido.
  _Si creo una línea diagonal (4,4) al (5,5), está dentro del rango, es válido.

 * Se ingresan las posiciones {(4,5),(1,2)} , {(1,3),(1,5)} y {(3,1), (4,1)}, por lo tanto, la línea va del punto (4,5), 
 hasta el (1,2), después del (1,3) al (1,5), luego del (3,1) al (4,1) como todas están libres, se agregan todas las estructuras. 
 
  _Se ingresan las posiciones {(2,5),(5,5)}, por lo tanto, la línea va del punto (2,5), hasta el (5,5), como la posición (4,5)
   está ocupada, no se agrega ninguna estructura de la línea ingresada. 
  _Si se ingresan los puntos {(1,1), (3,2)}, no se puede debido a que no forman una línea recta ( horizontal, vertical o diagonal).
  _Si se ingresan los puntos {(4,4), (2,4)}, no se puede ya que los casilleros que están dentro del recorrido se encuentra el (3,4)
   que está ocupado.
  _Si se ingresan 2 puntos a los cuales no se pueda trazar una línea horizontal, vertical o diagonal. Entonces, no se podrá dibujar
   una línea de objetos de estructuras. Ejemplo: {(4,2}, (2,1)}. 
 *
 */
public class UserStory_04 {
	
}
