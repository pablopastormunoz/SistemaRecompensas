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
					String correo, String fecha) 
	{
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