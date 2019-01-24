/*
 * Clase pública Cliente, encargada de simular al usuario que 
 * ejecuta la aplicación y lanzar el programa.
 */

public class Cliente 
{
	public static void main(String [] args) 
	{
		 Factoria Creador = new Factoria_MenuCompuesto();
		 
		 /*
		  *  Le pasamos al Creador nuevos objetos donde se almacenará la
		  * información en tiempo de ejecución de nuestro programa. 
		  * 
		  * Por la interfaz de la Factoría, un objeto iMenu es requerido
		  * para instanciar un MenuCompuesto.
		  * 
		  * En este caso, al ser el primer nivel de la jerarquía del
		  * Composite, el objeto iMenu M no lo usará, pero es necesario
		  * pasar un objeto Padre para cumplir con la interfaz de 
		  * la Factoría.
		  * 
		  * */ 
		 
		 iMenu M = Creador.Fabrica(new MenuCompuesto(), new Coleccion_DLC(), new Coleccion_Videojuego(), new Coleccion_Jugador(), new Coleccion_Recompensa(), new Jugador_Videojuego(), new Jugador_Recompensa());
		 M.mostrar();
	}
}
