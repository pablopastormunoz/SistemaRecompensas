import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

enum GenJuego{	ACCION, ADULTOS, AVENTURA,ARCADE, 
				AGILIDADMENTAL, CASUAL, EDUCATIVO, FAMILIA, 
				LUCHA, FITNESS, HORROR, MUSICAYRITMO, GRUPO, 
				PUZZLE, CARRERAS, ROL, SHOOTER, SIMULADOR, 
				DEPORTES, ESTRATEGIA, UNICO
			}

enum Dispositivo { PS4, PSVITA, Xbox360, XboxOne, PC }

public interface PlayableContent {
	public String getTitulo();
	public String getDescripcion();
}

interface iDLC extends PlayableContent {}

class DLC implements iDLC {
	private String titDLC, descDLC;
	
	public DLC (String tit, String desc) {
		titDLC = tit;
		descDLC = desc;
	}

	public String getTitulo() {
		return titDLC;
	}

	public String getDescripcion() {
		return descDLC;
	}
}

interface iVideojuego extends PlayableContent{
	public String getGenero();
	public String getDispositivo();
}

class Videojuego implements iVideojuego {

	private String titJuego, descJuego;
	private String GenJuego;
	private String dispJuego;
	private List<iRecompensa> refsRecompensa = new ArrayList<iRecompensa>();
	private List<iDLC> refsDLC = new ArrayList<iDLC>();
	
	public Videojuego (String tit, String desc, String gen, String disp) {
		titJuego = tit;
		descJuego = desc;
		GenJuego = gen;
		dispJuego = disp;
	}
	
	public String getTitulo() {
		return titJuego;
	}

	public void setTitulo(String Tit) {
		titJuego = Tit;
	}

	public void setDescripcion(String Desc) {
		descJuego = Desc;
	}
	
	public String getDescripcion() {
		return descJuego;
	}
	
	public void setGenero (String Gen) {
		GenJuego = Gen;
	}
	
	public String getGenero() {
		return GenJuego;
	}

	public void setDispositivo(String Dispo) {
		dispJuego = Dispo;
	}
	
	public String getDispositivo() {
		return dispJuego;
	}
	
	public void asociaRecompensa (iRecompensa Rec) {
		refsRecompensa.add(Rec);
	}
	
	public void desasociaRecompensa (iRecompensa Rec) {
		refsRecompensa.remove(Rec);
	}
	
	public Iterator<iRecompensa> getRecompensas () {
		return refsRecompensa.iterator();
	}
	
	public void asociaDLC (iDLC ContDes) {
		refsDLC.add(ContDes);
	}
	
	public void desasociaDLC (iDLC ContDes) {
		refsDLC.remove(ContDes);
	}
	
	public Iterator<iDLC> getDLCs () {
		return refsDLC.iterator();
	}
}

class Jugador_Recompensa {
	private Map<Recompensa,List<Jugador>> Jugadores = new HashMap<Recompensa,List<Jugador>>();
	private Map<Jugador,List<Recompensa>> Recompensas = new HashMap<Jugador,List<Recompensa>>();
	
	public void asociaJugadorRecompensa (Jugador Jug, Recompensa Rec) {
		if(Jugadores.containsKey(Rec))
		{
			Jugadores.get(Rec).add(Jug);
		} else {
			Jugadores.put(Rec, new ArrayList<Jugador>());
		}
		if(Recompensas.containsKey(Jug))
		{
			Recompensas.get(Jug).add(Rec);
		} else {
			Recompensas.put(Jug, new ArrayList<Recompensa>());
		}
	}
	
	public void desasociaJugadorRecompensa (Jugador Jug, Recompensa Rec) {
		if(Jugadores.containsKey(Rec))
			Jugadores.get(Rec).remove(Jug);
		if(Recompensas.containsKey(Jug))
			Recompensas.get(Jug).add(Rec);
	}
	
	public Map<Recompensa,List<Jugador>> getJugadores() {
		return Jugadores;
	}
	
	public Map<Jugador,List<Recompensa>> getRecompensas() {
		return Recompensas;
	}
}

class Jugador_Videojuego {
	private Map<Videojuego,List<Jugador>> Jugadores = new HashMap<Videojuego,List<Jugador>>();
	private Map<Jugador,List<Videojuego>> Videojuegos = new HashMap<Jugador,List<Videojuego>>();
	
	public void asociaJugadorVideojuego (Jugador Jug, Videojuego VidJug) {
		if(Jugadores.containsKey(VidJug))
		{
			Jugadores.get(VidJug).add(Jug);
		} else {
			Jugadores.put(VidJug, new ArrayList<Jugador>());
		}
		if(Videojuegos.containsKey(Jug))
		{
			Videojuegos.get(Jug).add(VidJug);
		} else {
			Videojuegos.put(Jug, new ArrayList<Videojuego>());
		}
	}
	
	public void desasociaJugadorVideojuego (Jugador Jug, Videojuego VidJug) {
		if(Jugadores.containsKey(VidJug))
			Jugadores.get(VidJug).remove(Jug);
		if(Videojuegos.containsKey(Jug))
			Videojuegos.get(Jug).add(VidJug);
	}
	
	public Map<Videojuego,List<Jugador>> getJugadores() {
		return Jugadores;
	}
	
	public Map<Jugador,List<Videojuego>> getVideojuegos() {
		return Videojuegos;
	}
}