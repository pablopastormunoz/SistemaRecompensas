enum Dificultad {ALTA, MEDIA, BAJA}

public interface iRecompensa {
	public String getTitulo();
	public String getDificultad();
}

class Recompensa implements iRecompensa {
	private String titRecompensa, dificRecompensa;
	
	public Recompensa (String tit, String dific) {
		titRecompensa = tit;
		dificRecompensa = dific;
	}

	public void setTitulo(String tit) {
		titRecompensa = tit;
	}
	
	public String getTitulo() {
		return titRecompensa;
	}
	
	public void setDificultad(String Dificultad) {
		dificRecompensa = Dificultad;
	}

	public String getDificultad() {
		return dificRecompensa;
	}
}