import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Interfaz iMenu para la arquitectura en árbol 
 * que distingue al Composite.
 */

public interface iMenu 
{
	public void mostrar();
}

/*
 * Clase que representa al menú compuesto de más objetos iMenu (sus opciones)
 * dentro de la arquitectura en árbol del Composite.
 */

class MenuCompuesto implements iMenu {

	private List<iMenu> Opciones = new ArrayList<iMenu>();
	
	private Coleccion_DLC DLCs;
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	private Jugador_Videojuego Jug_VidJug;
	private Jugador_Recompensa Jug_Rec;

	public MenuCompuesto() {}
	
	public MenuCompuesto(Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.DLCs = DLCs;
		this.VidJugs = VidJugs;
		this.Jugs = Jugs;
		this.Recs = Recs;
		this.Jug_VidJug = Jug_VidJug;
		this.Jug_Rec = Jug_Rec;
		
		Factoria Creador = new Factoria_MenuCrear();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
		Creador = new Factoria_MenuMostrar();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
		Creador = new Factoria_MenuActualizar();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
		Creador = new Factoria_MenuEliminar();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
		Creador = new Factoria_MenuNotificar();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
		Creador = new Factoria_MenuEstadisticas();
		AñadirOpcion(Creador.Fabrica(this, this.DLCs, this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec));
	}

	public void AñadirOpcion(iMenu opcion) {
		Opciones.add(opcion);
	}
	
	public void QuitarOpcion(iMenu opcion) {
		Opciones.remove(opcion);
	}
	
	public iMenu GetOpcion(Integer posicion) {
		return Opciones.get(posicion);
	}
	
	public void mostrar() {
		Integer opt;
		
		System.out.println("---------------------------------");
		System.out.println("  Sistema de Recompensas 18/19   ");
		System.out.println("---------------------------------\n");
		System.out.println("Seleccione qué desea hacer:\n");
		System.out.println("0. Crear un objeto.");
		System.out.println("1. Mostrar datos de un objeto.");
		System.out.println("2. Actualizar un objeto.");
		System.out.println("3. Eliminar un objeto.");
		System.out.println("4. Realizar una notificación.");
		System.out.println("5. Mostrar una estadística.\n");

		System.out.println("6. Cerrar el programa.\n");

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2 && opt != 3 && opt != 4 && opt!= 5 && opt != 6);
		
		switch(opt) 
		{
			case 0:
				Opciones.get(0).mostrar();
				break;
			case 1:
				Opciones.get(1).mostrar();
				break;			
			case 2:
				Opciones.get(2).mostrar();
				break;		
			case 3:
				Opciones.get(3).mostrar();
				break;		
			case 4:
				Opciones.get(4).mostrar();
				break;		
			case 5:
				Opciones.get(5).mostrar();
				break;			
			case 6:
				System.out.println("\nHasta luego.");
				System.exit(0);
				break;		
		}
	}
}

/*
 * Conjunto de clases que representan a los menús hoja del Composite.
 * En total, seis menús hoja, uno para cada acción concreta.
 */

class MenuCrear implements iMenu 
{
	private Coleccion_DLC DLCs;
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	
	private iMenu Padre;
	private Command Comando_Crear;

	public MenuCrear(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs) 
	{
		this.DLCs = DLCs;
		this.VidJugs = VidJugs;
		this.Jugs = Jugs;
		this.Recs = Recs;
		
		this.Padre = Padre;
		Comando_Crear = new Comando_Crear(this.DLCs, this.VidJugs, this.Jugs, this.Recs);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println("   Menú de creación de objetos   ");
		System.out.println("---------------------------------\n");
		
		Comando_Crear.execute();
		Padre.mostrar();
	}
}

class MenuMostrar implements iMenu 
{
	private Coleccion_DLC DLCs;
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	
	private iMenu Padre;
	private Command Comando_Mostrar;

	public MenuMostrar(iMenu Padre, Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs) 
	{
		this.DLCs = DLCs;
		this.VidJugs = VidJugs;
		this.Jugs = Jugs;
		this.Recs = Recs;
		
		this.Padre = Padre;
		Comando_Mostrar = new Comando_Mostrar(this.DLCs, this.VidJugs, this.Jugs, this.Recs);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println("   Menú de mostrado de objetos   ");
		System.out.println("---------------------------------\n");
		
		Comando_Mostrar.execute();
		Padre.mostrar();
	}
}


class MenuActualizar implements iMenu 
{
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Recompensa Recs;
	
	private iMenu Padre;
	private Command Comando_Actualizar;

	public MenuActualizar(iMenu Padre, Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		
		this.Padre = Padre;
		Comando_Actualizar = new Comando_Actualizar(this.VidJugs, this.Recs);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println("  Menú de actualizado de objetos  ");
		System.out.println("---------------------------------\n");
		
		Comando_Actualizar.execute();
		Padre.mostrar();
	}
}

class MenuEliminar implements iMenu 
{
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Recompensa Recs;
	private Coleccion_DLC DLCs;
	
	private iMenu Padre;
	private Command Comando_Eliminar;

	public MenuEliminar(iMenu Padre, Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs, Coleccion_DLC DLCs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.DLCs = DLCs;
		
		this.Padre = Padre;
		Comando_Eliminar = new Comando_Eliminar(this.VidJugs, this.Recs, this.DLCs);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println(" Menú de eliminación de objetos   ");
		System.out.println("---------------------------------\n");
		
		Comando_Eliminar.execute();
		Padre.mostrar();
	}
}

class MenuNotificar implements iMenu 
{
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	private Jugador_Videojuego Jug_VidJug;
	private Jugador_Recompensa Jug_Rec;
	
	private iMenu Padre;
	private Command Comando_Notificar;

	public MenuNotificar(iMenu Padre, Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs, Coleccion_Jugador Jugs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.Jugs = Jugs;
		this.Jug_VidJug = Jug_VidJug;
		this.Jug_Rec = Jug_Rec;
		
		this.Padre = Padre;
		Comando_Notificar = new Comando_Notificar(this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println("     Menú de notificaciones    ");
		System.out.println("---------------------------------\n");
		
		Comando_Notificar.execute();
		Padre.mostrar();
	}
}

class MenuEstadisticas implements iMenu 
{
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	private Jugador_Videojuego Jug_VidJug;
	private Jugador_Recompensa Jug_Rec;
	
	private iMenu Padre;
	private Command Comando_Estadisticas;

	public MenuEstadisticas(iMenu Padre, Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs, Coleccion_Jugador Jugs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.Jugs = Jugs;
		this.Jug_VidJug = Jug_VidJug;
		this.Jug_Rec = Jug_Rec;
		
		this.Padre = Padre;
		Comando_Estadisticas = new Comando_Estadisticas(this.VidJugs, this.Jugs, this.Recs, this.Jug_VidJug, this.Jug_Rec);
	}

	public void mostrar() 
	{
		System.out.println("\n---------------------------------");
		System.out.println("      Menú de estadísticas    ");
		System.out.println("---------------------------------\n");
		
		Comando_Estadisticas.execute();
		Padre.mostrar();
	}
}
