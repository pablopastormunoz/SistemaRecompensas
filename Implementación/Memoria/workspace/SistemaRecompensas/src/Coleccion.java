
public interface Coleccion {
	public Iterador crearIterador();
}

class Coleccion_Jugador implements Coleccion {

	private int MAX_ITEMS=50;
	private int numItems=0;
	private Jugador[] ListaJugadores;
	
	public Coleccion_Jugador() {
		ListaJugadores = new Jugador[MAX_ITEMS];
	}
	
	public Iterador crearIterador() {
		return new Iterador_Jugador(ListaJugadores);
	}
	
	public void addItem(Jugador Jug){
		if(numItems >= MAX_ITEMS)
			System.err.print("Colección de jugadores llena");
		else
		{
			ListaJugadores[numItems] = Jug;
			numItems += 1;
		}
	}
	
	public int length() {
		return ListaJugadores.length;
	}
	
	public Jugador[] getListaJugadores()
	{
		return ListaJugadores;
	}
}

class Coleccion_Videojuego implements Coleccion {

	private int MAX_ITEMS=50;
	private int numItems=0;
	private Videojuego[] ListaVideojuegos;
	
	public Coleccion_Videojuego() {
		ListaVideojuegos = new Videojuego[MAX_ITEMS];
	}
	
	public Iterador crearIterador() {
		return new Iterador_Videojuego(ListaVideojuegos);
	}
	
	public void addItem(Videojuego VidJug){
		if(numItems >= MAX_ITEMS)
			System.err.print("Colección de videojuegos llena");
		else
		{
			ListaVideojuegos[numItems] = VidJug;
			numItems += 1;
		}
	}
	
	public int length() {
		return ListaVideojuegos.length;
	}
	
	public Videojuego[] getListaVideojuegos()
	{
		return ListaVideojuegos;
	}
}

class Coleccion_Recompensa implements Coleccion {

	private int MAX_ITEMS=50;
	private int numItems=0;
	private Recompensa[] ListaRecompensas;
	
	public Coleccion_Recompensa() {
		ListaRecompensas = new Recompensa[MAX_ITEMS];
	}
	
	public Iterador crearIterador() {
		return new Iterador_Recompensa(ListaRecompensas);
	}
	
	public void addItem(Recompensa Rec){
		if(numItems >= MAX_ITEMS)
			System.err.print("Colección de recompensas llena");
		else
		{
			ListaRecompensas[numItems] = Rec;
			numItems += 1;
		}
	}
	
	public int length() {
		return ListaRecompensas.length;
	}
	
	public Recompensa[] getListaRecompensas()
	{
		return ListaRecompensas;
	}
}

class Coleccion_DLC implements Coleccion {

	private int MAX_ITEMS=50;
	private int numItems=0;
	private DLC[] ListaDLCs;
	
	public Coleccion_DLC() {
		ListaDLCs = new DLC[MAX_ITEMS];
	}
	
	public Iterador crearIterador() {
		return new Iterador_DLC(ListaDLCs);
	}
	
	public void addItem(DLC ContDes){
		if(numItems >= MAX_ITEMS)
			System.err.print("Colección de DLCs llena");
		else
		{
			ListaDLCs[numItems] = ContDes;
			numItems += 1;
		}
	}
	
	public int length() {
		return ListaDLCs.length;
	}
	
	public DLC[] getListaDLCs()
	{
		return ListaDLCs;
	}
}