import org.junit.Assert;
import org.junit.Test;		

public class SuiteTest1 
{				
    @Test		
    public void Test1() throws Exception 
    {						
    	Coleccion_Jugador Jugs = new Coleccion_Jugador();
    	Jugador Jug = new Jugador("Test", "Test", "Test", "Test","Test");
    	Jugs.AñadirItem(Jug);
    	Jugador OtroJug = Jugs.getItem(0);
        Assert.assertEquals(Jug, OtroJug);										
    }	

    @Test (expected = Exception.class)	
    public void Test2() throws Exception 
    {						
    	@SuppressWarnings("unused")
		Jugador Jug = new Jugador(null,null,null,null,null);				
    }	
}