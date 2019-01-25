import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * Interfaz Command, invocada por los menús hoja
 * de la aplicación, y que aplica sobre los modelos
 * de datos diseñados.
 */

public interface Command 
{
	public void execute();
}

/*
 * Commands concretos para ejecutar
 * órdenes concretas según se soliciten.
 */

class Comando_Crear implements Command 
{
	private Coleccion_DLC DLCs;
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;

	public Comando_Crear(Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs) 
	{
		this.DLCs = DLCs;
		this.VidJugs = VidJugs;
		this.Jugs = Jugs;
		this.Recs = Recs;
	}

	public void execute() 
	{
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione el tipo de objeto a crear: \n");
		System.out.println("0. DLC.");
		System.out.println("1. Videojuego.");
		System.out.println("2. Jugador.");
		System.out.println("3. Recompensa.");
		
		System.out.println("\n4. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2 && opt != 3 && opt != 4);
		
		switch(opt) 
		{
			case 0:
				
				if(VidJugs.TamColeccion() == 0)
					System.out.println("\nNo es posible crear un DLC sin un Videojuego al que asignarlo. Por favor, cree antes un Videojuego.\n");
				else
				{
					System.out.println("\nRellene los valores solicitados:\n");
					String TitDLC, DescDLC;
					
					S.nextLine();
					
					System.out.print("Introduce un Título: ");
					TitDLC = S.nextLine();
					System.out.print("Introduce una Descripción: ");
					DescDLC = S.nextLine();
					System.out.println();
					System.out.println("\nSeleccione un Videojuego al que asociar: \n");
					
					Iterador Iter = VidJugs.crearIterador();
					Integer posicion = 0;
					
					while(Iter.tieneSiguiente())
					{
						Videojuego Temp = (Videojuego) Iter.siguiente();
						System.out.println(posicion + ". "+ Temp.getTitulo());
						posicion++;
					}
					
					do 
					{
						System.out.print("\nSeleccione videojuego: ");
						selector = S.nextInt();
					} while (selector < 0 || selector >= posicion);
					
					DLC New = new DLC(TitDLC,DescDLC);
					DLCs.AñadirItem(New);
					VidJugs.getItem(selector).asociaDLC(New);
					System.out.println("\nNuevo DLC creado.\n");
				}
				
				break;
			case 1:
				
				System.out.println("\nRellene los valores solicitados:\n");
				String TitVidJug, DescVidJug;
				
				S.nextLine();
				System.out.print("Introduce un Título: ");
				TitVidJug = S.nextLine();
				System.out.print("Introduce una Descripción: ");
				DescVidJug = S.nextLine();
				
				Genero [] VectorGeneros = Genero.values();
				
				System.out.println("\nSeleccione dos géneros de videojuego:\n");
				
				for(int i = 0; i < VectorGeneros.length; i++)
					System.out.println(i+ ". " + VectorGeneros[i].toString());
				System.out.println();
				
				List<Genero> ListaGeneros = new ArrayList<Genero>();
				Integer counter=0;
				
				do {
					do {
							System.out.print("Seleccione: ");
							selector = S.nextInt();
						} while(selector < 0 || selector >= VectorGeneros.length);
					ListaGeneros.add(VectorGeneros[selector]);
					counter++;
				} while(counter <2);
				
				Dispositivo [] VectorDispositivos = Dispositivo.values();
				
				System.out.println("\nSeleccione dispositivo de videojuego:\n");
				
				for(int i = 0; i < VectorDispositivos.length; i++)
					System.out.println(i+ ". " + VectorDispositivos[i].toString());
				
				System.out.println();
				
				do {
					System.out.print("Seleccione dispositivo: ");
					selector = S.nextInt();
				} while(selector < 0 || selector >= VectorDispositivos.length);
				
				Dispositivo Disp = VectorDispositivos[selector];
				
				try {
					VidJugs.AñadirItem(new Videojuego(TitVidJug, DescVidJug, ListaGeneros, Disp));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("\nNuevo Videojuego creado.\n");
				
				break;		
			case 2:
				
				System.out.println("\nRellene los valores solicitados:\n");
				String Nom, Apell,Nick,Correo,Fecha;
				
				S.nextLine();
				System.out.print("Introduce un Nombre: ");
				Nom = S.nextLine();
				System.out.print("Introduce Apellidos: ");
				Apell = S.nextLine();
				System.out.print("Introduce Nickname: ");
				Nick = S.nextLine();
				System.out.print("Introduce Correo: ");
				Correo = S.nextLine();
				System.out.print("Introduce Fecha de Nacimiento: ");
				Fecha = S.nextLine();
	
				try {
					Jugs.AñadirItem(new Jugador(Nom,Apell,Nick,Correo,Fecha));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nNuevo Jugador creado.\n");
				
				break;		
			case 3:
				
				if(VidJugs.TamColeccion() == 0)
					System.out.println("\nNo es posible crear una Recompensa sin un Videojuego al que asignarla. Por favor, cree antes un Videojuego.\n");
				else
				{
					System.out.println("\nRellene los valores solicitados:\n");
					String TitRec;
					
					S.nextLine();
					
					System.out.print("Introduce un Título: ");
					TitRec = S.nextLine();

					System.out.println("\nSeleccione dificultad de la recompensa:\n");
					
					Dificultad [] VectorDificultad = Dificultad.values();
					
					for(int i = 0; i < VectorDificultad.length; i++)
						System.out.println(i+ ". " + VectorDificultad[i].toString());
					
					System.out.println();
					
					do {
						System.out.print("Seleccione dificultad: ");
						selector = S.nextInt();
					} while(selector < 0 || selector >= VectorDificultad.length);
					
					Dificultad Dific = VectorDificultad[selector];
					
					System.out.println("\nSeleccione un Videojuego al que asociar: \n");
					
					Iterador Iter = VidJugs.crearIterador();
					Integer posicion = 0;
					
					while(Iter.tieneSiguiente())
					{
						Videojuego Temp = (Videojuego) Iter.siguiente();
						System.out.println(posicion + ". "+ Temp.getTitulo());
						posicion++;
					}
					
					do {
						System.out.print("\nSeleccione videojuego: ");
						selector = S.nextInt();
					} while (selector < 0 || selector >= posicion);
					
					try {
					Recompensa NewRec = new Recompensa(TitRec,Dific);
					Recs.AñadirItem(NewRec);
					VidJugs.getItem(selector).asociaRecompensa(NewRec);	
					}catch(Exception E) {}
					System.out.println("\nNueva Recompensa creada.\n");
				}
				break;		
			case 4: 
				System.out.println("\nOperación cancelada.\n");
				break;		
		}
	}
}

class Comando_Mostrar implements Command 
{
	private Coleccion_DLC DLCs;
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;

	public Comando_Mostrar(Coleccion_DLC DLCs, Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs) 
	{
		this.DLCs = DLCs;
		this.VidJugs = VidJugs;
		this.Jugs = Jugs;
		this.Recs = Recs;
	}

	public void execute() 
	{
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione el tipo de objeto a mostrar: \n");
		System.out.println("0. DLC.");
		System.out.println("1. Videojuego.");
		System.out.println("2. Jugador.");
		System.out.println("3. Recompensa.");
		
		System.out.println("\n4. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2 && opt != 3 && opt != 4);
		
		switch(opt) 
		{
		case 0:
			if(DLCs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para mostrar.\n");
			else
			{
				System.out.println("\nSeleccione un DLC para mostrar sus datos: \n");
				
				Iterador Iter = DLCs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					DLC Temp = (DLC) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione DLC: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				System.out.println("\nDATOS DLC\n");
				System.out.println("Titulo: " + DLCs.getItem(selector).getTitulo());
				System.out.println("Descripcion: " + DLCs.getItem(selector).getDescripcion());
				
				System.out.println("\nConsulta ejecutada con éxito.\n");
			}

			break;
		case 1:
			if(VidJugs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para mostrar.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego para mostrar sus datos: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				System.out.println("\nDATOS VIDEOJUEGO\n");
				System.out.println("Titulo: " + VidJugs.getItem(selector).getTitulo());
				System.out.println("Descripcion: " + VidJugs.getItem(selector).getDescripcion());
				System.out.print("Genero: ");
				
				List<Genero> Gen = VidJugs.getItem(selector).getGenero();
				
					System.out.println(Gen.get(0).toString() + ", " + Gen.get(1).toString());
				
				System.out.println("Dispositivo: " + VidJugs.getItem(selector).getDispositivo());
				
				
				System.out.println("\nConsulta ejecutada con éxito.\n");
			}
			
			break;
		case 2:
			if(Jugs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para mostrar.\n");
			else
			{
				System.out.println("\nSeleccione un Jugador para mostrar sus datos: \n");
				
				Iterador Iter = Jugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Jugador Temp = (Jugador) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getNickname());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Jugador: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				System.out.println("\nDATOS JUGADOR\n");
				System.out.println("Nombre: " + Jugs.getItem(selector).getNombre());
				System.out.println("Apellidos: " + Jugs.getItem(selector).getApellido());
				System.out.println("Nickname: " + Jugs.getItem(selector).getNickname());
				System.out.println("Email: " + Jugs.getItem(selector).getEmail());
				System.out.println("Fecha Nacimiento: " + Jugs.getItem(selector).getFecha());
				
				System.out.println("\nActualización ejecutada con éxito.\n");
			}
			break;
		case 3:
			if(Recs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para mostrar.\n");
			else
			{
				System.out.println("\nSeleccione una Recompensa para mostrar sus datos: \n");
				
				Iterador Iter = Recs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Recompensa Temp = (Recompensa) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Recompensa: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				System.out.println("\nDATOS RECOMPENSA\n");
				System.out.println("Titulo: " + Recs.getItem(selector).getTitulo());
				System.out.println("Dificultad: " + Recs.getItem(selector).getDificultad());
				
				System.out.println("\nConsulta ejecutada con éxito.\n");
			}
			
			break;
		case 4:
			System.out.println("\nOperación cancelada.\n");
			break;
		}
	}
}

class Comando_Actualizar implements Command 
{
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Recompensa Recs;

	public Comando_Actualizar(Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
	}

	public void execute() {
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione el tipo de objeto a actualizar: \n");
		System.out.println("0. Videojuego.");
		System.out.println("1. Recompensa.");
		
		System.out.println("\n2. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2);
		
		switch(opt) 
		{
		case 0:
			if(VidJugs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para actualizar.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego para actualizar sus datos: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				
				System.out.println("\nRellene los valores solicitados:\n");
				
				S.nextLine();
				System.out.print("Introduce un nuevo Título: ");
				VidJugs.getItem(selector).setTitulo(S.nextLine());
				System.out.print("Introduce una nueva Descripción: ");
				VidJugs.getItem(selector).setDescripcion(S.nextLine());
				
				Genero [] VectorGeneros = Genero.values();
				
				System.out.println("\nSeleccione dos géneros de videojuego:\n");
				
				for(int i = 0; i < VectorGeneros.length; i++)
					System.out.println(i+ ". " + VectorGeneros[i].toString());
				System.out.println();
				
				List<Genero> ListaGeneros = new ArrayList<Genero>();
				Integer counter=0, sel;
				
				do {
					do {
							System.out.print("Seleccione: ");
							sel = S.nextInt();
						} while(sel < 0 || sel >= VectorGeneros.length);
					ListaGeneros.add(VectorGeneros[sel]);
					counter++;
				} while(counter <2);
				
				VidJugs.getItem(selector).setGenero(ListaGeneros);
				
				Dispositivo [] VectorDispositivos = Dispositivo.values();
				
				System.out.println("\nSeleccione dispositivo de videojuego:\n");
				
				for(int i = 0; i < VectorDispositivos.length; i++)
					System.out.println(i+ ". " + VectorDispositivos[i].toString());
				
				System.out.println();
				
				do {
					System.out.print("Seleccione dispositivo: ");
					sel = S.nextInt();
				} while(sel < 0 || sel > VectorDispositivos.length);
				
				Dispositivo Disp = VectorDispositivos[sel];
				
				VidJugs.getItem(selector).setDispositivo(Disp);
				
				System.out.println("\nVideojuego actualizado con éxito.\n");
			}

			break;
		case 1:
			if(Recs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para actualizar.\n");
			else
			{
				System.out.println("\nSeleccione una Recompensa para actualizar sus datos: \n");
				
				Iterador Iter = Recs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Recompensa Temp = (Recompensa) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Recompensa: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				System.out.println("\nRellene los valores solicitados:\n");
				
				S.nextLine();
				
				System.out.print("Introduce un nuevo Título: ");
				Recs.getItem(selector).setTitulo(S.nextLine());

				System.out.println("\nSeleccione dificultad de la recompensa:\n");
				
				Dificultad [] VectorDificultad = Dificultad.values();
				
				for(int i = 0; i < VectorDificultad.length; i++)
					System.out.println(i+ ". " + VectorDificultad[i].toString());
				
				System.out.println();
				
				Integer sel;
				
				do {
					System.out.print("Seleccione dificultad: ");
					sel = S.nextInt();
				} while(sel < 0 || sel >= VectorDificultad.length);
				
				Dificultad Dific = VectorDificultad[sel];
				Recs.getItem(selector).setDificultad(Dific);
				
				System.out.println("\nRecompensa actualizada con éxito.\n");
			}
			
			break;
		case 2:
			System.out.println("\nOperación cancelada.\n");
			break;
		}
	}
}

class Comando_Eliminar implements Command 
{	
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Recompensa Recs;
	private Coleccion_DLC DLCs;

	public Comando_Eliminar(Coleccion_Videojuego VidJugs, Coleccion_Recompensa Recs,
			Coleccion_DLC DLCs) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.DLCs = DLCs;
	}

	public void execute() {
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione el tipo de objeto a eliminar: \n");
		System.out.println("0. Videojuego.");
		System.out.println("1. Recompensa.");
		
		System.out.println("\n2. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2);
		
		switch(opt) 
		{
		case 0:
			if(VidJugs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para eliminar.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego para eliminar: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Videojuego Temp = VidJugs.getItem(selector);
				Iterator<DLC> Iter_DLC = Temp.getDLCs();
				
				while(Iter_DLC.hasNext()) {
					DLC dlc = Iter_DLC.next();
					DLCs.QuitarItem(dlc);
				}
				
				Iterator<Recompensa> Iter_Rec = Temp.getRecompensas();
				
				while(Iter_Rec.hasNext()) {
					Recompensa Rec = Iter_Rec.next();
					Recs.QuitarItem(Rec);
				}
				
				VidJugs.QuitarItem(Temp);
				
				System.out.println("\nVideojuego y asociados eliminados con éxito.\n");
			}

			break;
		case 1:
			if(Recs.TamColeccion()==0)
				System.out.println("\nNo hay elementos para eliminar.\n");
			else
			{
				System.out.println("\nSeleccione una Recompensa para eliminar: \n");
				
				Iterador Iter = Recs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Recompensa Temp = (Recompensa) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Recompensa: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Recompensa Temp = Recs.getItem(selector);
				
				for(int i = 0; i < VidJugs.TamColeccion(); i++)
					VidJugs.getItem(i).desasociaRecompensa(Temp);
				
				Recs.QuitarItem(Temp);
				
				System.out.println("\nRecompensa eliminada con éxito.\n");
			}
			
			break;
		case 2:
			System.out.println("\nOperación cancelada.\n");
			break;
		}
	}
}

class Comando_Notificar implements Command 
{	
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	private Coleccion_Recompensa Recs;
	private Jugador_Videojuego Jug_VidJug;
	private Jugador_Recompensa Jug_Rec;

	public Comando_Notificar(Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.Jugs = Jugs;
		this.Jug_VidJug = Jug_VidJug;
		this.Jug_Rec = Jug_Rec;
	}

	public void execute() {
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione qué desea notificar: \n");
		System.out.println("0. Nuevo Jugador de un Videojuego.");
		System.out.println("1. Obtención de Recompensa de un Videojuego.");
		
		System.out.println("\n2. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2);
		
		switch(opt) 
		{
		case 0:
			if(VidJugs.TamColeccion()==0 || Jugs.TamColeccion()==0)
				System.out.println("\nNo hay suficientes elementos para establecer una relación.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Videojuego VidJug = VidJugs.getItem(selector);
				
				System.out.println("\nSeleccione un Jugador: \n");
				
				Iterador Iter_Jug = Jugs.crearIterador();
				Integer pos = 0, sel;
				
				while(Iter_Jug.tieneSiguiente())
				{
					Jugador Temp = (Jugador) Iter_Jug.siguiente();
					System.out.println(pos + ". "+ Temp.getNickname());
					pos++;
				}
				
				do {
					System.out.print("\nSeleccione Jugador: ");
					sel = S.nextInt();
				} while (sel < 0 || sel >= pos);
				
				Jugador Jug = Jugs.getItem(sel);
				
				Jug_VidJug.asociaJugadorVideojuego(Jug, VidJug);
				
				System.out.println("\nEnlace entre Jugador y Videojuego completado con éxito.\n");
			}

			break;
		case 1:
			if(Recs.TamColeccion()==0 || Jugs.TamColeccion()==0)
				System.out.println("\nNo hay suficientes elementos para establecer una relación.\n");
			else
			{
				System.out.println("\nSeleccione una Recompensa: \n");
				
				Iterador Iter = Recs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Recompensa Temp = (Recompensa) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Recompensa: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Recompensa Rec = Recs.getItem(selector);
				
				System.out.println("\nSeleccione un Jugador: \n");
				
				Iterador Iter_Jug = Jugs.crearIterador();
				Integer pos = 0, sel;
				
				while(Iter_Jug.tieneSiguiente())
				{
					Jugador Temp = (Jugador) Iter_Jug.siguiente();
					System.out.println(pos + ". "+ Temp.getNickname());
					pos++;
				}
				
				do {
					System.out.print("\nSeleccione Jugador: ");
					sel = S.nextInt();
				} while (sel < 0 || sel >= pos);
				
				Jugador Jug = Jugs.getItem(sel);
				
				Jug_Rec.asociaJugadorRecompensa(Jug, Rec);
				
				System.out.println("\nEnlace entre Jugador y Recompensa completado con éxito.\n");
			}
			
			break;
		case 2:
			System.out.println("\nOperación cancelada.\n");
			break;
		}
	}
}

class Comando_Estadisticas implements Command 
{	
	private Coleccion_Videojuego VidJugs;
	private Coleccion_Jugador Jugs;
	@SuppressWarnings("unused")
	private Coleccion_Recompensa Recs;
	private Jugador_Videojuego Jug_VidJug;
	private Jugador_Recompensa Jug_Rec;

	public Comando_Estadisticas(Coleccion_Videojuego VidJugs, Coleccion_Jugador Jugs,
			Coleccion_Recompensa Recs, Jugador_Videojuego Jug_VidJug, Jugador_Recompensa Jug_Rec) 
	{
		this.VidJugs = VidJugs;
		this.Recs = Recs;
		this.Jugs = Jugs;
		this.Jug_VidJug = Jug_VidJug;
		this.Jug_Rec = Jug_Rec;
	}

	public void execute() {
		Integer opt, selector;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		
		System.out.println("Seleccione qué estadistica desea ver: \n");
		System.out.println("0. Jugadores por Videojuego.");
		System.out.println("1. Recompensas por Videojuego.");
		System.out.println("2. Jugadores que han completado cada Videojuego.");
		
		System.out.println("\n3. Cancelar.\n");
		
		do {
			System.out.print("Introduzca una opción: ");
			opt = S.nextInt();
		} while (opt != 0 && opt != 1 && opt != 2 && opt != 3);
		
		switch(opt) 
		{
		case 0:
			if(VidJugs.TamColeccion() == 0 || Jugs.TamColeccion() == 0)
				System.out.println("\nNo hay suficientes elementos para realizar la estadística.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Videojuego VidJug = VidJugs.getItem(selector);
				
				Iterator<Jugador> Iter_Jug = Jug_VidJug.getJugadores(VidJug);
				
				
				System.out.println("\nESTADISTICA: JUGADORES POR VIDEOJUEGO (" + VidJug.getTitulo() +")\n");
				
				Integer pos = 0;
				Jugador JugTemp;
				
				if(Iter_Jug!= null)
				{
					while(Iter_Jug.hasNext()) {
						JugTemp = Iter_Jug.next();
						System.out.println(pos + ". " + JugTemp.getNickname());
						pos++;
					}
				}
				System.out.println("\nEstadística ejecutada con éxito.\n");
			}

			break;
		case 1:
			if(VidJugs.TamColeccion() == 0 || Jugs.TamColeccion() == 0)
				System.out.println("\nNo hay suficientes elementos para realizar la estadística.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Videojuego VidJug = VidJugs.getItem(selector);
				
				Iterator<Recompensa> Iter_Rec = VidJug.getRecompensas();
				Recompensa RecTemp;
				
				System.out.println("\nESTADISTICA: RECOMPENSAS POR VIDEOJUEGO (" + VidJug.getTitulo() +")\n");
				
				Integer pos = 0; 
				long CantidadJugadores=Jugs.TamColeccion();
				
				while(Iter_Rec.hasNext()) 
				{
					RecTemp = Iter_Rec.next();
					Iterator<Jugador> Iter_Jug = Jug_Rec.getJugadores(RecTemp);
					long cont = 0;
					
					if(Iter_Jug != null)
					{
						while(Iter_Jug.hasNext())
						{
							Iter_Jug.next();
							cont++;
						}
					}
					
					System.out.println(pos + ". " + RecTemp.getTitulo() + ": " + cont + " jugador/es de " + CantidadJugadores );
					pos++;
				}
				System.out.println("\nEstadística ejecutada con éxito.\n");
			}
			
			break;
		case 2:
			if(VidJugs.TamColeccion() == 0 || Jugs.TamColeccion() == 0)
				System.out.println("\nNo hay suficientes elementos para realizar la estadística.\n");
			else
			{
				System.out.println("\nSeleccione un Videojuego: \n");
				
				Iterador Iter = VidJugs.crearIterador();
				Integer posicion = 0;
				
				while(Iter.tieneSiguiente())
				{
					Videojuego Temp = (Videojuego) Iter.siguiente();
					System.out.println(posicion + ". "+ Temp.getTitulo());
					posicion++;
				}
				
				do {
					System.out.print("\nSeleccione Videojuego: ");
					selector = S.nextInt();
				} while (selector < 0 || selector >= posicion);
				
				Videojuego VidJug = VidJugs.getItem(selector);
				
				System.out.println("\nESTADISTICA: JUGADORES QUE COMPLETARON VIDEOJUEGO (" + VidJug.getTitulo() +")\n");
				
				List<Recompensa> RecompensasVideojuego = new ArrayList<Recompensa>();
				Iterator<Recompensa> Iter_Rec = VidJug.getRecompensas();
				
				if(Iter_Rec != null)
					while(Iter_Rec.hasNext()) 
						RecompensasVideojuego.add(Iter_Rec.next());
				
				List<Jugador> JugadoresJugaronVideojuego = new ArrayList<Jugador>();
				Iterator<Jugador> Iter_Jug = Jug_VidJug.getJugadores(VidJug);
				
				if(Iter_Jug != null)
					while(Iter_Jug.hasNext())
						JugadoresJugaronVideojuego.add(Iter_Jug.next());
				
				List<Jugador> JugadoresCompletaronJuego = new ArrayList<Jugador>();
				
				for(int i = 0; i<JugadoresJugaronVideojuego.size(); i++)
				{
					Iterator<Recompensa> Recs_Jugador = Jug_Rec.getRecompensas(JugadoresJugaronVideojuego.get(i));
					List<Recompensa> ListaRecsJugador = new ArrayList<Recompensa>();
					
					if(Recs_Jugador != null)
						while(Recs_Jugador.hasNext())
							ListaRecsJugador.add(Recs_Jugador.next());
					
					boolean HaCompletado=true;
					
					for(int j = 0; j < RecompensasVideojuego.size(); j++)
					{
						if(!ListaRecsJugador.contains(RecompensasVideojuego.get(j)))
							HaCompletado=false;
					}
					
					if(HaCompletado)
						JugadoresCompletaronJuego.add(JugadoresJugaronVideojuego.get(i));	
				}
			
				for(int k = 0; k < JugadoresCompletaronJuego.size(); k++)
					System.out.println(k + ". " + JugadoresCompletaronJuego.get(k).getNickname());
				
				System.out.println("\nEstadística ejecutada con éxito.\n");
			}
			
			break;
		case 3:
			System.out.println("\nOperación cancelada.\n");
			break;
		}
	}
}