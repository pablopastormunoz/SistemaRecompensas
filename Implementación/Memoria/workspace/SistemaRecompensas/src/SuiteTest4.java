import org.junit.Assert;

import org.junit.Test;		

public class SuiteTest4 
{				
    @Test		
    public void Test6() throws Exception 
    {						
    	Coleccion_Recompensa Recs = new Coleccion_Recompensa();
    	Dificultad dific = Dificultad.MEDIA;
    	Recompensa Rec = new Recompensa("Test", dific);
    	Recs.AñadirItem(Rec);
    	Recompensa OtroRec = Recs.getItem(0);
        Assert.assertEquals(Rec, OtroRec);										
    }	

    @Test (expected = Exception.class)	
    public void Test7() throws Exception 
    {						
    	@SuppressWarnings("unused")
		Recompensa Rec = new Recompensa(null,null);				
    }	
}