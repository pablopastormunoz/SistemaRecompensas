import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Clase Jugador_Videojuego con la responsabilidad
 * de almacenar y proteger las relaciones entre
 * objetos de dichas clases.
 */

public class Jugador_Videojuego {
	private HashMap<Videojuego, ArrayList<Jugador>> Jugadores = new HashMap<Videojuego, ArrayList<Jugador>>();
	private HashMap<Jugador, ArrayList<Videojuego>> Videojuegos = new HashMap<Jugador, ArrayList<Videojuego>>();
	
	public void asociaJugadorVideojuego(Jugador Jug, Videojuego VidJug) 
	{
		if(Jugadores.containsKey(VidJug))
		{
			ArrayList<Jugador> Temp = Jugadores.get(VidJug);
			Temp.add(Jug);
			Jugadores.replace(VidJug, Temp);
		}
		else
		{
			ArrayList<Jugador> New = new ArrayList<Jugador>();
			New.add(Jug);
			Jugadores.put(VidJug, New);
		}
		
		if(Videojuegos.containsKey(Jug))
		{
			ArrayList<Videojuego> Temp = Videojuegos.get(Jug);
			Temp.add(VidJug);
			Videojuegos.replace(Jug, Temp);
		}
		else
		{
			ArrayList<Videojuego> New = new ArrayList<Videojuego>();
			New.add(VidJug);
			Videojuegos.put(Jug, New);
		}
	}
	
	public void desasociaJugadorVideojuego(Jugador Jug, Videojuego VidJug) 
	{
		if(Jugadores.containsKey(VidJug))
		{
			ArrayList<Jugador> Temp = Jugadores.get(VidJug);
			if (Temp.contains(Jug))
				Temp.remove(Jug);
		}
		
		if(Videojuegos.containsKey(Jug))
		{
			ArrayList<Videojuego> Temp = Videojuegos.get(Jug);
			if(Temp.contains(VidJug))
				Temp.remove(VidJug);
		}
	}
	
	public Iterator<Jugador> getJugadores(Videojuego VidJug){
		Iterator<Jugador> Iterador = null;
		
		if(Jugadores.containsKey(VidJug))
		{
			ArrayList<Jugador> Lista = Jugadores.get(VidJug);
			Iterador = Lista.iterator();
		}
		return Iterador;
	}
	
	public Iterator<Videojuego> getVideojuegos(Jugador Jug){
		Iterator<Videojuego> Iterador = null;
		
		if(Videojuegos.containsKey(Jug))
		{
			ArrayList<Videojuego> Lista = Videojuegos.get(Jug);
			Iterador = Lista.iterator();
		}
		return Iterador;
	}
}
