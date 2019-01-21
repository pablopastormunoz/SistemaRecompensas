import java.util.Date;

public interface iJugador {
	public String getNombre();
	public String getApellido();
	public String getNickname();
	public String getEmail();
	public Date getFecha();
}

class Jugador implements iJugador{
	
	private String nomJugador, apellJugador, nickJugador,correoJugador;
	private Date fechJugador;
	
	public Jugador(String nom, String apell, String nick, String correo, Date fecha) {
		nomJugador = nom;
		apellJugador = apell;
		nickJugador = nick;
		correoJugador = correo;
		fechJugador = fecha;
	}
	
	@Override
	public String getNombre() {
		return nomJugador;
	}

	@Override
	public String getApellido() {
		return apellJugador;
	}

	@Override
	public String getNickname() {
		return nickJugador;
	}

	@Override
	public String getEmail() {
		return correoJugador;
	}

	@Override
	public Date getFecha() {
		return fechJugador;
	}
}