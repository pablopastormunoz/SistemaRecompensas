import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Clase Jugador_Recompensa con la responsabilidad
 * de almacenar y proteger las relaciones entre
 * objetos de dichas clases.
 */

public class Jugador_Recompensa {
	private HashMap<Recompensa, ArrayList<Jugador>> Jugadores = new HashMap<Recompensa, ArrayList<Jugador>>();
	private HashMap<Jugador, ArrayList<Recompensa>> Recompensas = new HashMap<Jugador, ArrayList<Recompensa>>();
	
	public void asociaJugadorRecompensa(Jugador Jug, Recompensa Rec) 
	{
		if(Jugadores.containsKey(Rec))
		{
			ArrayList<Jugador> Temp = Jugadores.get(Rec);
			Temp.add(Jug);
			Jugadores.replace(Rec, Temp);
		}
		else
		{
			ArrayList<Jugador> New = new ArrayList<Jugador>();
			New.add(Jug);
			Jugadores.put(Rec, New);
		}
		
		if(Recompensas.containsKey(Jug))
		{
			ArrayList<Recompensa> Temp = Recompensas.get(Jug);
			Temp.add(Rec);
			Recompensas.replace(Jug, Temp);
		}
		else
		{
			ArrayList<Recompensa> New = new ArrayList<Recompensa>();
			New.add(Rec);
			Recompensas.put(Jug, New);
		}
	}
	
	public void desasociaJugadorRecompensa(Jugador Jug, Recompensa Rec) 
	{
		if(Jugadores.containsKey(Rec))
		{
			ArrayList<Jugador> Temp = Jugadores.get(Rec);
			if (Temp.contains(Jug))
				Temp.remove(Jug);
		}
		
		if(Recompensas.containsKey(Jug))
		{
			ArrayList<Recompensa> Temp = Recompensas.get(Jug);
			if(Temp.contains(Rec))
				Temp.remove(Rec);
		}
	}
	
	public Iterator<Jugador> getJugadores(Recompensa Rec){
		Iterator<Jugador> Iterador = null;
		
		if(Jugadores.containsKey(Rec))
		{
			ArrayList<Jugador> Lista = Jugadores.get(Rec);
			Iterador = Lista.iterator();
		}
		return Iterador;
	}
	
	public Iterator<Recompensa> getRecompensas(Jugador Jug){
		Iterator<Recompensa> Iterador = null;
		
		if(Recompensas.containsKey(Jug))
		{
			ArrayList<Recompensa> Lista = Recompensas.get(Jug);
			Iterador = Lista.iterator();
		}
		return Iterador;
	}
}