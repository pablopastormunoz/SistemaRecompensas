import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface iMenu {
	public void display();
}

class MenuPrincipal implements iMenu {

	private List<iMenu> Childs;
	
	public MenuPrincipal() {}
	
	public MenuPrincipal(Coleccion_Jugador coleccion_Jugador, Coleccion_Videojuego coleccion_Videojuego,
			Coleccion_Recompensa coleccion_Recompensa, Coleccion_DLC coleccion_DLC,
			Jugador_Recompensa jugador_Recompensa, Jugador_Videojuego jugador_Videojuego) 
	{
	}

	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  Menú principal");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. CR jugador");
		System.out.print("2. CRUD videojuego");
		System.out.print("3. CRUD recompensa");
		System.out.print("4. CR DLC");
		System.out.print("5. Notificar nuevo jugador de un videojuego");
		System.out.print("6. Notificar obtención de recompensa de un videojuego");
		System.out.println("7. Mostrar estadísticas");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		System.out.print("Introduzca una opción: ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="3" && opt !="4" && opt != "5" && opt!= "6" && opt != "7" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "3":
				Childs.get(3).display();
				break;		
			case "4":
				Childs.get(4).display();
				break;		
			case "5":
				Childs.get(5).display();
				break;		
			case "6":
				Childs.get(6).display();
				break;		
			case "7":
				Childs.get(7).display();
				break;		
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_CR_Jugador implements iMenu {

	private List<iMenu> Childs;
	
	public Menu_CR_Jugador(iMenu parent) {}
	
	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  CR jugador");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. Añadir nuevo jugador");
		System.out.print("2. Consultar datos de un jugador");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		System.out.print("Introduzca una opción: ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_C_Jugador implements iMenu {
	
	private Coleccion_Jugador Coleccion;
	private Command CreaJugador;
	
	public Menu_C_Jugador(Coleccion_Jugador C, iMenu Parent) {
		Coleccion = C;
		CreaJugador = new C_Jugador_Command(Coleccion);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Añadir nuevo jugador");
		System.out.println("-------------------");

		CreaJugador.execute();
		}
}

class Menu_R_Jugador implements iMenu {
	
	private Coleccion_Jugador Coleccion;
	private iMenu Parent;
	private Command MuestraJugador;
	
	public Menu_R_Jugador(Coleccion_Jugador C, iMenu Parent) {
		Coleccion = C;
		MuestraJugador = new R_Jugador_Command(Coleccion);
		this.Parent = Parent;
	}
	
	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Consultar datos de jugador ");
		System.out.println("-------------------");

		MuestraJugador.execute();
		
		System.out.println();
		System.out.println("R. Volver");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion != "R");
		
		switch(opcion) 
		{
			case "R":
				Parent.display();
				break;
		}
	}
}

class Menu_CRUD_Videojuego implements iMenu {

	private List<iMenu> Childs;
	
	public Menu_CRUD_Videojuego(iMenu parent) {}
	
	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  CRUD videojuego");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. Añadir nuevo videojuego");
		System.out.print("2. Editar datos de un videojuego");
		System.out.print("3. Consultar datos de un videojuego");
		System.out.print("4. Eliminar videojuego");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		System.out.print("Introduzca una opción: ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="3" && opt !="4" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "3":
				Childs.get(3).display();
				break;		
			case "4":
				Childs.get(4).display();
				break;		
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_C_Videojuego implements iMenu {
	
	private Coleccion_Videojuego Coleccion;
	private Command CreaVideojuego;
	
	public Menu_C_Videojuego(Coleccion_Videojuego C, iMenu parent) {
		Coleccion = C;
		CreaVideojuego = new C_Videojuego_Command(Coleccion);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Añadir nuevo videojuego");
		System.out.println("-------------------");

		CreaVideojuego.execute();
		}
}

class Menu_R_Videojuego implements iMenu {
	
	private Coleccion_Videojuego Coleccion;
	private iMenu Parent;
	private Command MuestraVideojuego;
	
	public Menu_R_Videojuego(Coleccion_Videojuego C, iMenu parent2) {
		Coleccion = C;
		MuestraVideojuego = new R_Videojuego_Command(Coleccion);
	}
	
	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Consultar datos de videojuego ");
		System.out.println("-------------------");

		MuestraVideojuego.execute();
		
		System.out.println();
		System.out.println("R. Volver");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion != "R");
		
		switch(opcion) 
		{
			case "R":
				Parent.display();
				break;
		}
	}
}

class Menu_U_Videojuego implements iMenu {
	
	private Coleccion_Videojuego Coleccion;
	private Command ActualizaVideojuego;
	
	public Menu_U_Videojuego(Coleccion_Videojuego C, iMenu parent) {
		Coleccion = C;
		ActualizaVideojuego = new U_Videojuego_Command(Coleccion);
	}
	
	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Editar datos de videojuego ");
		System.out.println("-------------------");

		ActualizaVideojuego.execute();
		
		System.out.println();
		System.out.println("Acciones disponibles: ");
		
		String opt;
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "S":
				System.out.println("Cambios almacenados");
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_D_Videojuego implements iMenu {
	private iMenu Parent;
	private Coleccion_Videojuego Coleccion;
	private Command BorraVideojuego;
	
	public Menu_D_Videojuego(Coleccion_Videojuego C, iMenu parent2) {
		Coleccion = C;
		BorraVideojuego = new D_Videojuego_Command(Coleccion);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Eliminar videojuego ");
		System.out.println("-------------------");

		BorraVideojuego.execute();
		
		Parent.display();
	
	}
}

class Menu_CRUD_Recompensa implements iMenu {

	private List<iMenu> Childs;
	
	public Menu_CRUD_Recompensa(iMenu parent) {}
	
	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  CRUD recompensa");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. Añadir nueva recompensa");
		System.out.print("2. Editar datos de una recompensa");
		System.out.print("3. Consultar datos de una recompensa");
		System.out.print("4. Eliminar recompensa");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		System.out.print("Introduzca una opción: ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="3" && opt !="4" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "3":
				Childs.get(3).display();
				break;		
			case "4":
				Childs.get(4).display();
				break;		
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_C_Recompensa implements iMenu {
	
	private Coleccion_Recompensa ColeccionRec;
	private Coleccion_Videojuego ColeccionVid;
	private Command CreaRecompensa;
	
	public Menu_C_Recompensa(Coleccion_Recompensa C, iMenu parent) {
		ColeccionRec = C;
		CreaRecompensa = new C_Recompensa_Command(ColeccionRec,ColeccionVid);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Añadir nueva recompensa");
		System.out.println("-------------------");

		CreaRecompensa.execute();
		}
}


class Menu_R_Recompensa implements iMenu {
	
	private Coleccion_Recompensa Coleccion;
	private iMenu Parent;
	private Command MuestraRecompensa;
	
	public Menu_R_Recompensa(Coleccion_Recompensa C, iMenu parent2) {
		Coleccion = C;
		MuestraRecompensa = new R_Recompensa_Command(Coleccion);
	}
	
	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Consultar datos de recompensa ");
		System.out.println("-------------------");

		MuestraRecompensa.execute();
		
		System.out.println();
		System.out.println("R. Volver");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion != "R");
		
		switch(opcion) 
		{
			case "R":
				Parent.display();
				break;
		}
	}
}

class Menu_U_Recompensa implements iMenu {
	
	private Coleccion_Recompensa Coleccion;
	private Command ActualizaRecompensa;
	
	public Menu_U_Recompensa(Coleccion_Recompensa C, iMenu parent) {
		Coleccion = C;
		ActualizaRecompensa = new U_Recompensa_Command(Coleccion);
	}
	
	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Editar datos de recompensa ");
		System.out.println("-------------------");

		ActualizaRecompensa.execute();
		
		System.out.println();
		System.out.println("Acciones disponibles: ");
		
		String opt;
		do {
			System.out.println("S. Guardar cambios");
			System.out.println("Q. Salir");
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "S":
				System.out.println("Cambios almacenados");
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_D_Recompensa implements iMenu {
	private iMenu Parent;
	private Coleccion_Recompensa Coleccion;
	private Command BorraRecompensa;
	
	public Menu_D_Recompensa(Coleccion_Recompensa C, iMenu parent2) {
		Coleccion = C;
		BorraRecompensa = new D_Recompensa_Command(Coleccion);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Eliminar recompensa ");
		System.out.println("-------------------");

		BorraRecompensa.execute();
		
		Parent.display();
	
	}
}

class Menu_CR_DLC implements iMenu {

	private List<iMenu> Childs;
	
	public Menu_CR_DLC(iMenu parent) {}
	
	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  CR DLC");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. Añadir nuevo DLC");
		System.out.print("2. Consultar datos de un DLC");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		System.out.print("Introduzca una opción: ");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_C_DLC implements iMenu {
	
	private Coleccion_DLC Coleccion;
	private Coleccion_Videojuego Col2;
	private Command CreaDLC;
	
	public Menu_C_DLC(Coleccion_DLC C, Coleccion_Videojuego ColV, iMenu parent) {
		Coleccion = C;
		Col2=ColV;
		CreaDLC = new C_DLC_Command(Coleccion, Col2);
	}
	
	public void display() 
	{
		System.out.print("-------------------");
		System.out.print("  Añadir nuevo DLC");
		System.out.println("-------------------");

		CreaDLC.execute();
	}
}

class Menu_R_DLC implements iMenu {
	
	private Coleccion_DLC Coleccion;
	private iMenu Parent;
	private Command MuestraDLC;
	
	public Menu_R_DLC(Coleccion_DLC C, iMenu Parent) {
		Coleccion = C;
		MuestraDLC = new R_DLC_Command(Coleccion);
	}

	public void display() 
	{
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Consultar datos de DLC ");
		System.out.println("-------------------");

		MuestraDLC.execute();
		
		System.out.println();
		System.out.println("R. Volver");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion != "R");
		
		switch(opcion) 
		{
			case "R":
				Parent.display();
				break;
		}
	}
}

class Menu_NotificarJugador implements iMenu {
	private Jugador_Videojuego Enlaces;
	private Coleccion_Jugador ListaJugadores;
	private Coleccion_Videojuego ListaVideojuegos;
	
	public Menu_NotificarJugador(iMenu parent) {
		
	}

	public void display() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Notificar Jugador de Videojuego ");
		System.out.println("-------------------");

		System.out.println("Seleccione un jugador al que notificar");
		Iterador_Jugador IterJug = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		int pos = 0;
		while(IterJug.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Jugador) IterJug.siguiente()).getNombre());
		}
		int opt = S.nextInt(), cont = 0;
		Jugador Jug = null;
		Iterador_Jugador IterJug2 = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		while(cont != opt) {
			Jug = (Jugador) IterJug2.siguiente();
		}
		
		System.out.println("Seleccione un videojuego");
		Iterador_Videojuego IterVidJug = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int posi = 0;
		while(IterVidJug.tieneSiguiente()) {
			System.out.println(posi+". "+ ((Videojuego) IterVidJug.siguiente()).getTitulo());
		}
		
		int opt2 = S.nextInt(), cont2 = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego IterVidJug2 = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont2 != opt2) {
			VidJug = (Videojuego) IterVidJug2.siguiente();
		}
		
		String opcion;
		do {
			System.out.println("S. Guardar cambios");
			System.out.println("Q. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="S" && opcion != "Q");
		
		switch(opcion) 
		{
			case "S":
				Enlaces.asociaJugadorVideojuego(Jug, VidJug);
				System.out.println("Cambios almacenados");
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_NotificarRecompensa implements iMenu {
	private Jugador_Recompensa Enlaces;
	private Coleccion_Jugador ListaJugadores;
	private Coleccion_Recompensa ListaRecompensas;
	
	public Menu_NotificarRecompensa(iMenu parent) {
		// TODO Auto-generated constructor stub
	}

	public void display() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Notificar Recompensa de Jugador en Videojuego ");
		System.out.println("-------------------");

		System.out.println("Seleccione un jugador al que notificar");
		Iterador_Jugador IterJug = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		int pos = 0;
		while(IterJug.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Jugador) IterJug.siguiente()).getNombre());
		}
		int opt = S.nextInt(), cont = 0;
		Jugador Jug = null;
		Iterador_Jugador IterJug2 = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		while(cont != opt) {
			Jug = (Jugador) IterJug2.siguiente();
		}
		
		System.out.println("Seleccione una recompensa");
		Iterador_Recompensa IterRec = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		int posi = 0;
		while(IterRec.tieneSiguiente()) {
			System.out.println(posi+". "+ ((Recompensa) IterRec.siguiente()).getTitulo());
		}
		
		int opt2 = S.nextInt(), cont2 = 0;
		Recompensa Rec = null;
		Iterador_Recompensa IterRec2 = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		while(cont2 != opt2) {
			Rec = (Recompensa) IterRec2.siguiente();
		}
		
		String opcion;
		do {
			System.out.println("S. Guardar cambios");
			System.out.println("Q. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="S" && opcion != "Q");
		
		switch(opcion) 
		{
			case "S":
				Enlaces.asociaJugadorRecompensa(Jug, Rec);
				System.out.println("Cambios almacenados");
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_Estadisticas implements iMenu {

	private List<iMenu> Childs;
	
	public Menu_Estadisticas(iMenu parent) {}
	
	public void AddChild(iMenu Child) {
		Childs.add(Child);
	}
	
	public void RemoveChild(iMenu Child) {
		Childs.remove(Child);
	}
	
	public iMenu GetChild(Integer index) {
		return Childs.get(index);
	}
	
	public void display() {
		String opt;
		System.out.print("-------------------");
		System.out.print("  Estadisticas ");
		System.out.println("-------------------");
		System.out.println("Acciones disponibles:");
		System.out.print("1. Consultar jugadores por videojuego");
		System.out.print("2. Consultar estadísticas de las recompensas por videojuego");
		System.out.print("3. Consultar jugadores que han completado cada videojuego");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt != "1" && opt != "2" && opt !="3" && opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "1":
				Childs.get(1).display();
				break;
			case "2":
				Childs.get(2).display();
				break;			
			case "3":
				Childs.get(3).display();
				break;		
			case "S":
				System.out.println("Todo está almacenado en memoria");
				display();
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class Menu_showJugadoresVideojuego implements iMenu {
	private Jugador_Videojuego Enlaces;
	private Coleccion_Videojuego ListaVideojuegos;
	
	public Menu_showJugadoresVideojuego(iMenu parent) {
		// TODO Auto-generated constructor stub
	}

	public void display() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		System.out.print("-------------------");
		System.out.print("  Consultar Jugadores por Videojuego ");
		System.out.println("-------------------");
		
		System.out.println("Seleccione un videojuego");
		Iterador_Videojuego IterVidJug = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int posi = 0;
		while(IterVidJug.tieneSiguiente()) {
			System.out.println(posi+". "+ ((Videojuego) IterVidJug.siguiente()).getTitulo());
		}
		
		int opt2 = S.nextInt(), cont2 = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego IterVidJug2 = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont2 != opt2) {
			VidJug = (Videojuego) IterVidJug2.siguiente();
		}
		
		System.out.print("-------------------");
		System.out.print("  Jugadores con Videojuego "+ VidJug.getTitulo());
		System.out.println("-------------------");
		
		Map<Videojuego,List<Jugador>> Contenedor = Enlaces.getJugadores();
		List<Jugador> Jugs;
		if(Contenedor.containsKey(VidJug))
		{
			Jugs = Contenedor.get(VidJug);
			for(int i =0; i < Jugs.size(); i++)
				System.out.println(i+". "+Jugs.get(i).getNickname());
		}
		
		String opcion;
		do {
			System.out.println("Q. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion != "Q");
		
		switch(opcion) 
		{
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

// Pendiente de diseñar

class Menu_showRecompensasConseguidas implements iMenu {

	public Menu_showRecompensasConseguidas(iMenu parent) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}

//Pendiente de diseñar

class Menu_showJuegosCompletados implements iMenu {

	public Menu_showJuegosCompletados(iMenu parent) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
