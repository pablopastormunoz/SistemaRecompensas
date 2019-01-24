import java.util.List;

/*
 * Interfaz Iterador que aplica sobre las 
 * colecciones previamente modeladas.
 */

public interface Iterador {
	public boolean tieneSiguiente();
	public Object siguiente();
}

/*
 * Iteradores concretos que serán creados por
 * las colecciones concretas cuando se requieran.
 */

class Iterator_DLC implements Iterador
{
	private Integer posicion = 0;
	private List<DLC> ListaDLCs;
	
	public Iterator_DLC (List<DLC> ListaDLCs) {
		this.ListaDLCs = ListaDLCs;
	}
	
	public boolean tieneSiguiente() {
		if (posicion >= ListaDLCs.size() || ListaDLCs.get(posicion) == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		DLC ContDes = ListaDLCs.get(posicion);
		posicion = posicion + 1;
		return ContDes;
	}
}

class Iterator_Videojuego implements Iterador
{
	private Integer posicion = 0;
	private List<Videojuego> ListaVideojuegos;
	
	public Iterator_Videojuego (List<Videojuego> ListaVideojuegos) {
		this.ListaVideojuegos = ListaVideojuegos;
	}
	
	public boolean tieneSiguiente() {
		if (posicion >= ListaVideojuegos.size() || ListaVideojuegos.get(posicion) == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Videojuego VidJug = ListaVideojuegos.get(posicion);
		posicion = posicion + 1;
		return VidJug;
	}
}

class Iterator_Jugador implements Iterador
{
	private Integer posicion = 0;
	private List<Jugador> ListaJugadores;
	
	public Iterator_Jugador (List<Jugador> ListaJugadores) {
		this.ListaJugadores = ListaJugadores;
	}
	
	public boolean tieneSiguiente() {
		if (posicion >= ListaJugadores.size() || ListaJugadores.get(posicion) == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Jugador Jug = ListaJugadores.get(posicion);
		posicion = posicion + 1;
		return Jug;
	}
}

class Iterator_Recompensa implements Iterador
{
	private Integer posicion = 0;
	private List<Recompensa> ListaRecompensas;
	
	public Iterator_Recompensa (List<Recompensa> ListaRecompensas) {
		this.ListaRecompensas = ListaRecompensas;
	}
	
	public boolean tieneSiguiente() {
		if (posicion >= ListaRecompensas.size() || ListaRecompensas.get(posicion) == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Recompensa Rec = ListaRecompensas.get(posicion);
		posicion = posicion + 1;
		return Rec;
	}
}
