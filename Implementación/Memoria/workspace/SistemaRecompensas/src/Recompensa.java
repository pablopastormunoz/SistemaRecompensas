/*
 * Enumeración para determinar el
 * grado de dificultad de la obtención
 * de una recompensa.
 */

enum Dificultad {
	ALTA, MEDIA, BAJA
}

/*
 * Clase Recompensa sencilla que aplica
 * la anterior enumeración citada.
 */

class Recompensa 
{
	private String titRecompensa;
	private Dificultad dificRecompensa;
	
	public Recompensa (String tit, Dificultad dific) {
		titRecompensa = tit;
		dificRecompensa = dific;
	}
	
	public String getTitulo() 
	{ return titRecompensa; }
	
	public void setTitulo(String tit) 
	{ titRecompensa = tit; }

	public Dificultad getDificultad() 
	{ return dificRecompensa; }
	
	public void setDificultad(Dificultad dific) 
	{ dificRecompensa = dific; }
}