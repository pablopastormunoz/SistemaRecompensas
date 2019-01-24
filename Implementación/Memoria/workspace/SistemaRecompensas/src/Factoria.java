/*
 * Interfaz Factoría, encargada de la instanciación
 * de los objetos iMenu.
 */

public interface Factoria 
{
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec);
}

/*
 * Factorías concretas para cada tipo de
 * menú previamente modelado.
 */

class Factoria_MenuCompuesto implements Factoria {
	
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuCompuesto(DLCs, VidJugs, Jugs, Recs, Jug_VidJug, Jug_Rec);
	}
}

class Factoria_MenuCrear implements Factoria {

	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuCrear(Padre, DLCs, VidJugs, Jugs, Recs);
	}
}

class Factoria_MenuMostrar implements Factoria {

	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuMostrar(Padre, DLCs, VidJugs, Jugs, Recs);
	}
}

class Factoria_MenuActualizar implements Factoria {
	
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuActualizar(Padre, VidJugs, Recs);
	}
}

class Factoria_MenuEliminar implements Factoria {
	
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuEliminar(Padre, VidJugs, Recs, DLCs, Jug_VidJug, Jug_Rec);
	}
}

class Factoria_MenuNotificar implements Factoria {
	
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuNotificar(Padre, VidJugs, Recs, Jugs, Jug_VidJug, Jug_Rec) ;
	}
}

class Factoria_MenuEstadisticas implements Factoria {
	
	public iMenu Fabrica(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs, Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec)
	{
		return new MenuEstadisticas(Padre, VidJugs, Recs, Jugs, Jug_VidJug, Jug_Rec) ;
	}
}