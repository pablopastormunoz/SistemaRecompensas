import java.util.ArrayList;

import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest2 
{				
    @Test		
    public void Test3() throws Exception 
    {						
    	Coleccion_Videojuego VidJugs = new Coleccion_Videojuego();
    	Dispositivo Disp = Dispositivo.PC;
    	ArrayList<Genero> Generos = new ArrayList<Genero>();
    	Generos.add(Genero.ACCION);
    	Videojuego VidJug = new Videojuego("Test", "Test", Generos, Disp);
    	VidJugs.AñadirItem(VidJug);
    	Videojuego OtroVidJug = VidJugs.getItem(0);
        Assert.assertEquals(VidJug, OtroVidJug);										
    }	

    @Test (expected = Exception.class)	
    public void Test4() throws Exception 
    {						
    	@SuppressWarnings("unused")
		Videojuego VidJug = new Videojuego(null,null,null,null);				
    }	
}