import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest6 
{				
    @Test		
    public void Test9() throws Exception 
    {						
    	DLC Dlc = new DLC("Test", "Test");
    	Coleccion_DLC ColDLCs = new Coleccion_DLC();
    	ColDLCs.AñadirItem(Dlc);
        Assert.assertTrue(ColDLCs.TamColeccion()==1);
        ColDLCs.QuitarItem(Dlc);
        Assert.assertTrue(ColDLCs.TamColeccion()==0);        						
    }	
}