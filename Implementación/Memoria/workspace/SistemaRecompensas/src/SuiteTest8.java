import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest8 
{				
    @Test		
    public void Test11() throws Exception 
    {						
    	Jugador_Recompensa Jug_Rec = new Jugador_Recompensa();
    	
    	Dificultad dif = Dificultad.ALTA;
    	Recompensa Rec = new Recompensa("Test", dif);
    	
    	Jugador Jug = new Jugador("Test","Test","Test","Test","Test");
    	
    	Jug_Rec.asociaJugadorRecompensa(Jug, Rec);
    	Iterator<Jugador> Iter = Jug_Rec.getJugadores(Rec);
    	
    	ArrayList<Jugador> ListaJugadores = new ArrayList<Jugador>();
    	
    	if(Iter != null)
			while(Iter.hasNext())
				ListaJugadores.add(Iter.next());
    	
    	Assert.assertTrue(ListaJugadores.contains(Jug));
    }	
}