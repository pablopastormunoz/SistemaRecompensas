import java.util.ArrayList;
import java.util.List;

/*
 * Interfaz Coleccion, que modela las colecciones necesarias
 * sobre las que opera un Iterador.
 */

public interface Coleccion 
{
	public Integer TamColeccion();
	public Iterador crearIterador();
}

/*
 * Colecciones concretas y sus métodos para los diferentes 
 * tipos de datos que se han modelado.
 */

class Coleccion_DLC implements Coleccion {
	private List<DLC> ListaDLCs = new ArrayList<DLC>();

	public void AñadirItem(DLC ContDes) {
		ListaDLCs.add(ContDes);	
	}

	public void QuitarItem(DLC ContDes) {
		ListaDLCs.remove(ContDes);
	}
	
	public Integer posicionDe(DLC ContDes) {
		return ListaDLCs.indexOf(ContDes);
	}

	public DLC getItem(Integer posicion) {
		return ListaDLCs.get(posicion);
	}

	public Integer TamColeccion() {
		return ListaDLCs.size();
	}

	public Iterador crearIterador() {
		return new Iterator_DLC(ListaDLCs);
	}
}

class Coleccion_Videojuego implements Coleccion {
	private List<Videojuego> ListaVideojuegos = new ArrayList<Videojuego>();

	public void AñadirItem(Videojuego VidJug) {
		ListaVideojuegos.add(VidJug);	
	}

	public void QuitarItem(Videojuego VidJug) {
		ListaVideojuegos.remove(VidJug);
	}
	
	public Integer posicionDe(Videojuego VidJug) {
		return ListaVideojuegos.indexOf(VidJug);
	}

	public Videojuego getItem(Integer posicion) {
		return ListaVideojuegos.get(posicion);
	}

	public Integer TamColeccion() {
		return ListaVideojuegos.size();
	}

	public Iterador crearIterador() {
		return new Iterator_Videojuego(ListaVideojuegos);
	}
}

class Coleccion_Jugador implements Coleccion {
	private List<Jugador> ListaJugadores = new ArrayList<Jugador>();

	public void AñadirItem(Jugador Jug) {
		ListaJugadores.add(Jug);	
	}

	public void QuitarItem(Jugador Jug) {
		ListaJugadores.remove(Jug);
	}
	
	public Integer posicionDe(Jugador Jug) {
		return ListaJugadores.indexOf(Jug);
	}

	public Jugador getItem(Integer posicion) {
		return ListaJugadores.get(posicion);
	}

	public Integer TamColeccion() {
		return ListaJugadores.size();
	}

	public Iterador crearIterador() {
		return new Iterator_Jugador(ListaJugadores);
	}
}

class Coleccion_Recompensa implements Coleccion {
	private List<Recompensa> ListaRecompensas = new ArrayList<Recompensa>();

	public void AñadirItem(Recompensa Rec) {
		ListaRecompensas.add(Rec);	
	}

	public void QuitarItem(Recompensa Rec) {
		ListaRecompensas.remove(Rec);
	}
	
	public Integer posicionDe(Recompensa Rec) {
		return ListaRecompensas.indexOf(Rec);
	}

	public Recompensa getItem(Integer posicion) {
		return ListaRecompensas.get(posicion);
	}

	public Integer TamColeccion() {
		return ListaRecompensas.size();
	}

	public Iterador crearIterador() {
		return new Iterator_Recompensa(ListaRecompensas);
	}
}