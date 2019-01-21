import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public interface Command {
	public void execute();
}

class C_Jugador_Command implements Command {
	Coleccion_Jugador ListaJugadores;
	
	public C_Jugador_Command (Coleccion_Jugador Coleccion) {
		ListaJugadores = Coleccion;
	}
	
	public void execute() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.print("Introduzca nombre: ");
		String nom = S.nextLine();
		System.out.print("Introduzca apellidos: ");
		String apell = S.nextLine();


		System.out.print("Introduzca nickname: ");
		String nick = S.nextLine();

		System.out.print("Introduzca correo electrónico: ");
		String email = S.nextLine();
		System.out.print("Introduzca fecha de nacimiento: ");
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(S.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jugador Jug = new Jugador(nom, apell, nick, email, fecha);
		System.out.println();
		System.out.println("Acciones disponibles:");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		
		String opt;
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "S":
				ListaJugadores.addItem(Jug);
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class R_Jugador_Command implements Command {
	Coleccion_Jugador ListaJugadores;
	
	public R_Jugador_Command (Coleccion_Jugador Coleccion) {
		ListaJugadores = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione un jugador para mostrar sus datos");
		Iterador_Jugador Iter = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Jugador) Iter.siguiente()).getNickname());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		Jugador Jug = null;
		Iterador_Jugador Otro = new Iterador_Jugador(ListaJugadores.getListaJugadores());
		
		while(cont != opt) {
			Jug = (Jugador) Otro.siguiente();
		}
		
		System.out.println();
		System.out.print("-------------------");
		System.out.print("  Datos: "+ Jug.getNickname());
		System.out.println("-------------------\n");
		System.out.print("1. Nombre y apellidos: " + Jug.getNombre() + " " + Jug.getApellido());
		System.out.print("2. Nickname: " + Jug.getNickname());
		System.out.print("3. Correo electrónico: " + Jug.getEmail());
		System.out.print("4. Fecha de nacimiento: " + Jug.getFecha());
		}
}

class C_Videojuego_Command implements Command {
	Coleccion_Videojuego ListaVideojuegos;
	
	public C_Videojuego_Command (Coleccion_Videojuego Coleccion) {
		ListaVideojuegos = Coleccion;
	}
	
	public void execute() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.print("Introduzca titulo: ");
		String tit = S.nextLine();
		System.out.print("Introduzca descripción: ");
		String desc = S.nextLine();


		System.out.print("Introduzca género: ");
		String gen = S.nextLine();

		System.out.print("Introduzca dispositivo: ");
		String disp = S.nextLine();

		Videojuego VidJug = new Videojuego(tit, desc, gen, disp);
		System.out.println();
		System.out.println("Acciones disponibles:");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		
		String opt;
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextLine();
		} while (opt !="S" && opt != "Q");
		
		switch(opt) 
		{
			case "S":
				ListaVideojuegos.addItem(VidJug);
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class R_Videojuego_Command implements Command {
	Coleccion_Videojuego ListaVideojuegos;
	
	public R_Videojuego_Command (Coleccion_Videojuego Coleccion) {
		ListaVideojuegos = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione un videojuego para mostrar sus datos");
		Iterador_Videojuego Iter = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Videojuego) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego Otro = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont != opt) {
			VidJug = (Videojuego) Otro.siguiente();
		}
		
		System.out.println();
		System.out.print("-------------------");
		System.out.print("  Datos: "+ VidJug.getTitulo());
		System.out.println("-------------------\n");
		System.out.print("1. Título: " + VidJug.getTitulo());
		System.out.print("2. Descripción: " + VidJug.getDescripcion());
		System.out.print("3. Género: " + VidJug.getGenero());
		System.out.print("4. Dispositivo: " + VidJug.getDispositivo());
		}
}

class U_Videojuego_Command implements Command {
	Coleccion_Videojuego ListaVideojuegos;
	
	public U_Videojuego_Command (Coleccion_Videojuego Coleccion) {
		ListaVideojuegos = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione un videojuego para editar");
		Iterador_Videojuego Iter = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Videojuego) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego Otro = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont != opt) {
			VidJug = (Videojuego) Otro.siguiente();
		}
		
		System.out.println();
		
		System.out.print("Introduzca titulo: ");
		String tit = S.nextLine();
		VidJug.setTitulo(tit);
		System.out.print("Introduzca descripción: ");
		String desc = S.nextLine();
		VidJug.setDescripcion(desc);
		System.out.print("Introduzca género: ");
		String gen = S.nextLine();
		VidJug.setGenero(gen);
		System.out.print("Introduzca dispositivo: ");
		String disp = S.nextLine();
		VidJug.setDispositivo(disp);
		}
}

class D_Videojuego_Command implements Command {
	Coleccion_Videojuego ListaVideojuegos;
	
	public D_Videojuego_Command (Coleccion_Videojuego Coleccion) {
		ListaVideojuegos = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione un videojuego para eliminar");
		Iterador_Videojuego Iter = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Videojuego) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt();
		
		System.out.println("¿Seguro desea eliminar el videojuego?, se borrarán todas las recompensas asociadas. ");
		System.out.println("Y. Sí");
		System.out.println("N. No");
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="Y" && opcion != "N");
		
		switch(opcion) 
		{
			case "Y":
				Videojuego[] Lista = ListaVideojuegos.getListaVideojuegos();
				for(int i = opt; i<Lista.length-1;i++)
					Lista[i]=Lista[i+1];
				break;
			case "N":
				System.out.println("Eliminación cancelada");
				break;		
		}
	}
}

class C_Recompensa_Command implements Command {
	Coleccion_Recompensa ListaRecompensas;
	Coleccion_Videojuego ListaVideojuegos;
	
	public C_Recompensa_Command (Coleccion_Recompensa Coleccion, Coleccion_Videojuego Col) {
		ListaRecompensas = Coleccion;
		ListaVideojuegos = Col;
	}
	
	public void execute() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.print("Introduzca titulo: ");
		String tit = S.nextLine();
		System.out.print("Introduzca dificultad: ");
		String dif = S.nextLine();

		System.out.println("Seleccione un videojuego para editar");
		Iterador_Videojuego Iter = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Recompensa) Iter.siguiente()).getTitulo());
		}

		int opt = S.nextInt(), cont = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego Otro = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont != opt) {
			VidJug = (Videojuego) Otro.siguiente();
		}
		
		Recompensa Rec = new Recompensa(tit, dif);

		System.out.println();
		System.out.println("Acciones disponibles:");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="S" && opcion != "Q");
		
		switch(opcion) 
		{
			case "S":
				ListaRecompensas.addItem(Rec);
				VidJug.asociaRecompensa(Rec);
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class R_Recompensa_Command implements Command {
	Coleccion_Recompensa ListaRecompensas;
	
	public R_Recompensa_Command (Coleccion_Recompensa Coleccion) {
		ListaRecompensas = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione uns recompensa para mostrar sus datos");
		Iterador_Recompensa Iter = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Recompensa) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		Recompensa Rec = null;
		Iterador_Recompensa Otro = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		while(cont != opt) {
			Rec = (Recompensa) Otro.siguiente();
		}
		
		System.out.println();
		System.out.print("-------------------");
		System.out.print("  Datos: "+ Rec.getTitulo());
		System.out.println("-------------------\n");
		System.out.print("1. Título: " + Rec.getTitulo());
		System.out.print("2. Descripción: " + Rec.getDificultad());
		}
}

class U_Recompensa_Command implements Command {
	Coleccion_Recompensa ListaRecompensas;
	
	public U_Recompensa_Command (Coleccion_Recompensa Coleccion) {
		ListaRecompensas = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione una recompensa para editar");
		Iterador_Recompensa Iter = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Recompensa) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		Recompensa Rec = null;
		Iterador_Recompensa Otro = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
		
		while(cont != opt) {
			Rec = (Recompensa) Otro.siguiente();
		}
		
		System.out.println();
		
		System.out.print("Introduzca titulo: ");
		String tit = S.nextLine();
		Rec.setTitulo(tit);
		System.out.print("Introduzca dificultad: ");
		String dif = S.nextLine();
		Rec.setDificultad(dif);
		}
}

class D_Recompensa_Command implements Command {
	Coleccion_Recompensa ListaRecompensas;
	
	public D_Recompensa_Command (Coleccion_Recompensa Coleccion) {
		ListaRecompensas = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione una recompensa para eliminar");
		Iterador_Recompensa Iter = new Iterador_Recompensa(ListaRecompensas.getListaRecompensas());
	
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Recompensa) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt();
		
		System.out.println("¿Seguro desea eliminar la recompensa?");
		System.out.println("Y. Sí");
		System.out.println("N. No");
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="Y" && opcion != "N");
		
		switch(opcion) 
		{
			case "Y":
				Recompensa[] Lista = ListaRecompensas.getListaRecompensas();
				for(int i = opt; i<Lista.length-1;i++)
					Lista[i]=Lista[i+1];
				break;
			case "N":
				System.out.println("Eliminación cancelada");
				break;		
		}
	}
}

class C_DLC_Command implements Command {
	Coleccion_DLC ListaDLCs;
	Coleccion_Videojuego ListaVideojuegos;
	
	public C_DLC_Command (Coleccion_DLC Coleccion, Coleccion_Videojuego Col) {
		ListaDLCs = Coleccion;
		ListaVideojuegos = Col;
	}
	
	public void execute() {
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.print("Introduzca titulo: ");
		String tit = S.nextLine();
		System.out.print("Introduzca descripción: ");
		String desc = S.nextLine();

		System.out.println("Seleccione un videojuego para editar");
		Iterador_Videojuego Iter = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((Videojuego) Iter.siguiente()).getTitulo());
		}

		int opt = S.nextInt(), cont = 0;
		Videojuego VidJug = null;
		Iterador_Videojuego Otro = new Iterador_Videojuego(ListaVideojuegos.getListaVideojuegos());
		
		while(cont != opt) {
			VidJug = (Videojuego) Otro.siguiente();
		}
		
		DLC ContDes = new DLC(tit, desc);

		System.out.println();
		System.out.println("Acciones disponibles:");
		System.out.println("S. Guardar cambios");
		System.out.println("Q. Salir");
		
		String opcion;
		do {
			System.out.print("Introduzca una opción: ");
			opcion = S.nextLine();
		} while (opcion !="S" && opcion != "Q");
		
		switch(opcion) 
		{
			case "S":
				ListaDLCs.addItem(ContDes);
				VidJug.asociaDLC(ContDes);
				break;
			case "Q":
				System.exit(0);
				break;		
		}
	}
}

class R_DLC_Command implements Command {
	Coleccion_DLC ListaDLCs;
	
	public R_DLC_Command (Coleccion_DLC Coleccion) {
		ListaDLCs = Coleccion;
	}
	
	public void execute() {
		System.out.println("Seleccione uns recompensa para mostrar sus datos");
		Iterador_DLC Iter = new Iterador_DLC(ListaDLCs.getListaDLCs());
		
		int pos = 0;
		while(Iter.tieneSiguiente()) {
			System.out.println(pos+". "+ ((DLC) Iter.siguiente()).getTitulo());
		}
		

		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		int opt = S.nextInt(), cont = 0;
		DLC ContDes = null;
		Iterador_DLC Otro = new Iterador_DLC(ListaDLCs.getListaDLCs());
		
		while(cont != opt) {
			ContDes = (DLC) Otro.siguiente();
		}
		
		System.out.println();
		System.out.print("-------------------");
		System.out.print("  Datos: "+ ContDes.getTitulo());
		System.out.println("-------------------\n");
		System.out.print("1. Título: " + ContDes.getTitulo());
		System.out.print("2. Descripción: " + ContDes.getDescripcion());
		}
}
