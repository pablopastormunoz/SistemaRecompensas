/*
 * Clase Jugador sencilla.
 */

class Jugador 
{
	private String nomJugador, 
				   apellJugador, 
				   nickJugador,
				   correoJugador, 
				   fechJugador;
	
	public Jugador(String nom, String apell, String nick, 
					String correo, String fecha) throws Exception 
	{
		if(nom.isEmpty() || apell.isEmpty() || nick.isEmpty() || correo.isEmpty() || fecha.isEmpty())
			throw new Exception("Ningun campo del jugador puede estar vacio");
		nomJugador = nom;
		apellJugador = apell;
		nickJugador = nick;
		correoJugador = correo;
		fechJugador = fecha;
	}
	
	public String getNombre() 
	{ return nomJugador; }

	public String getApellido() 
	{ return apellJugador; }

	public String getNickname() 
	{ return nickJugador; }

	public String getEmail() 
	{ return correoJugador; }

	public String getFecha() 
	{ return fechJugador; }
}