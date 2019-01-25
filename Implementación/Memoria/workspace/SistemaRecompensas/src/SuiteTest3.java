import java.util.ArrayList;
import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest3 {				

    @Test
    public void Test5() throws Exception 
    {						
		Coleccion_Videojuego VidJugs = new Coleccion_Videojuego();
		Dispositivo Disp = Dispositivo.PC;
		ArrayList<Genero> Generos = new ArrayList<Genero>();
		Generos.add(Genero.ACCION);
		Videojuego VidJug = new Videojuego("Test", "Test", Generos, Disp);
		
		Coleccion_Recompensa ColRec = new Coleccion_Recompensa();
		Dificultad dific = Dificultad.ALTA;
		ColRec.AñadirItem(new Recompensa("Test", dific));
		
		Coleccion_DLC ColDLCs = new Coleccion_DLC();
		ColDLCs.AñadirItem(new DLC("Test", "Test"));
		
		VidJug.asociaDLC(ColDLCs.getItem(0));
		VidJug.asociaRecompensa(ColRec.getItem(0));
		
		VidJugs.AñadirItem(VidJug);
		VidJugs.QuitarItem(VidJugs.getItem(0));
		
		ColDLCs.QuitarItem(ColDLCs.getItem(0));
		ColRec.QuitarItem(ColRec.getItem(0));
		
		Assert.assertTrue(ColDLCs.TamColeccion()==0);
		Assert.assertTrue(ColRec.TamColeccion()==0);
		Assert.assertTrue(VidJugs.TamColeccion()==0);
    }	
}