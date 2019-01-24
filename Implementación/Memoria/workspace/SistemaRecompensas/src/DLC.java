/*
 * Clase DLC sencilla.
 */

public class DLC 
{
	private String titDLC, descDLC;
	
	public DLC (String titDLC, String descDLC) {
		this.titDLC = titDLC;
		this.descDLC = descDLC;
	}

	public String getTitulo() 
	{ return titDLC; }

	public String getDescripcion() 
	{ return descDLC; }
}
