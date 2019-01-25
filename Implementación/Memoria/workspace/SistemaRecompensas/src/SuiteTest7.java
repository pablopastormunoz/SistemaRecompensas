import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest7 
{				
    @Test		
    public void Test10() throws Exception 
    {						
    	Jugador_Videojuego Jug_VidJug = new Jugador_Videojuego();
    	
    	ArrayList<Genero> Gen = new ArrayList<Genero>();
    	Gen.add(Genero.ACCION);
    	Dispositivo disp = Dispositivo.PC;
    	Videojuego VidJug = new Videojuego("Test", "Test", Gen, disp);
    	
    	Jugador Jug = new Jugador("Test","Test","Test","Test","Test");
    	
    	Jug_VidJug.asociaJugadorVideojuego(Jug, VidJug);
    	Iterator<Jugador> Iter = Jug_VidJug.getJugadores(VidJug);
    	
    	ArrayList<Jugador> ListaJugadores = new ArrayList<Jugador>();
    	
    	if(Iter != null)
			while(Iter.hasNext())
				ListaJugadores.add(Iter.next());
    	
    	Assert.assertTrue(ListaJugadores.contains(Jug));
    }	
}