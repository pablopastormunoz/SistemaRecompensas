import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest5 
{				
    @Test		
    public void Test8() throws Exception 
    {						
    	Dificultad dific = Dificultad.ALTA;
    	Recompensa Rec = new Recompensa("Test", dific);
    	Coleccion_Recompensa ColRec = new Coleccion_Recompensa();
    	ColRec.AñadirItem(Rec);
        Assert.assertTrue(ColRec.TamColeccion()==1);
        ColRec.QuitarItem(Rec);
        Assert.assertTrue(ColRec.TamColeccion()==0);        						
    }	
}