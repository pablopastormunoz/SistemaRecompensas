import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Enumeraciones correspondientes a el/los género/s,
 * así como el dispositivo compatible, que puede
 * tener un videojuego.
 */

enum Genero {
	ACCION, ADULTOS, AGILIDAD_MENTAL, CASUAL, EDUCATIVO, FAMILIA, LUCHA, FITNESS,
	HORROR, MUSICA_Y_RITMO, GRUPO, PUZZLE, CARRERAS, ROL, SIMULADOR, DEPORTES, ESTRATEGIA, UNICO 
}

enum Dispositivo {
	PS4, PC, XBOX_ONE, XBOX_360, PS_VITA
}

/*
 * Clase Videojuego sencilla que aplica
 * las dos enumeraciones previamente citadas.
 */

public class Videojuego 
{
	private String titJuego, descJuego;
	private List<Genero> GenJuego;
	private Dispositivo dispJuego;
	private List<Recompensa> refsRecompensa = new ArrayList<Recompensa>();
	private List<DLC> refsDLC = new ArrayList<DLC>();
	
	public Videojuego (String titJuego, String descJuego, List<Genero> GenJuego, Dispositivo dispJuego)
	{
		this.titJuego = titJuego;
		this.descJuego = descJuego;
		this.GenJuego = GenJuego;
		this.dispJuego = dispJuego;
	}
	
	public String getTitulo() 
	{ return titJuego; }
	
	public void setTitulo(String titJuego) 
	{ this.titJuego = titJuego; }
	
	public String getDescripcion() 
	{ return descJuego; }
	
	public void setDescripcion(String descJuego) 
	{ this.descJuego = descJuego; }
	
	public List<Genero> getGenero() 
	{ return GenJuego; }
	
	public void setGenero(List<Genero> genJuego) 
	{ GenJuego = genJuego; }
	
	public Dispositivo getDispositivo() 
	{ return dispJuego; }
	
	public void setDispositivo(Dispositivo dispJuego) 
	{ this.dispJuego = dispJuego; }
	
	public void asociaRecompensa(Recompensa Rec) 
	{ refsRecompensa.add(Rec); }
	
	public void desasociaRecompensa(Recompensa Rec) 
	{ refsRecompensa.remove(Rec); }	
	
	public Iterator<Recompensa> getRecompensas() 
	{ return refsRecompensa.iterator(); }
	
	public void asociaDLC(DLC ContDes)
	{ refsDLC.add(ContDes); }
	
	public void desasociaDLC(DLC ContDes) 
	{ refsDLC.remove(ContDes); }	
	
	public Iterator<DLC> getDLCs() 
	{ return refsDLC.iterator(); }
}
