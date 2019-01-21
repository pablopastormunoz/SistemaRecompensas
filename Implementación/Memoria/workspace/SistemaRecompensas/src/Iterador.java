
public interface Iterador {
	public boolean tieneSiguiente();
	public Object siguiente();
}

class Iterador_Jugador implements Iterador
{
	private int pos=0;
	private Jugador[] ListaJugadores;
	
	public Iterador_Jugador (Jugador[] ListaJugadores) {
		this.ListaJugadores = ListaJugadores;
	}
	
	public boolean tieneSiguiente() {
		if (pos >= ListaJugadores.length || ListaJugadores[pos] == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Jugador Jug = ListaJugadores[pos];
		pos += 1;
		return Jug;
	}
}

class Iterador_Videojuego implements Iterador
{
	private int pos=0;
	private Videojuego[] ListaVideojuegos;
	
	public Iterador_Videojuego (Videojuego[] ListaVideojuegos) {
		this.ListaVideojuegos = ListaVideojuegos;
	}
	
	public boolean tieneSiguiente() {
		if (pos >= ListaVideojuegos.length || ListaVideojuegos[pos] == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Videojuego VidJug = ListaVideojuegos[pos];
		pos += 1;
		return VidJug;
	}
}

class Iterador_Recompensa implements Iterador
{
	private int pos=0;
	private Recompensa[] ListaRecompensas;
	
	public Iterador_Recompensa (Recompensa[] ListaRecompensas) {
		this.ListaRecompensas = ListaRecompensas;
	}
	
	public boolean tieneSiguiente() {
		if (pos >= ListaRecompensas.length || ListaRecompensas[pos] == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		Recompensa Rec = ListaRecompensas[pos];
		pos += 1;
		return Rec;
	}
}

class Iterador_DLC implements Iterador
{
	private int pos=0;
	private DLC[] ListaDLCs;
	
	public Iterador_DLC (DLC[] ListaDLCs) {
		this.ListaDLCs = ListaDLCs;
	}
	
	public boolean tieneSiguiente() {
		if (pos >= ListaDLCs.length || ListaDLCs[pos] == null)
			return false;
		else 
			return true;
	}
	
	public Object siguiente() {
		DLC ContDes = ListaDLCs[pos];
		pos += 1;
		return ContDes;
	}
}