public interface FactoriaMenu {
 public iMenu FactoryMethod(iMenu Parent);
}

class FactoriaMenu_CR_Jugador implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_CR_Jugador(Parent);
	}
}

class FactoriaMenu_C_Jugador implements FactoriaMenu {
	private Coleccion_Jugador Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_C_Jugador(Coleccion, Parent);
	}
}

class FactoriaMenu_R_Jugador implements FactoriaMenu {
	private Coleccion_Jugador Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_R_Jugador(Coleccion, Parent);
	}
}

class FactoriaMenu_CRUD_Videojuego implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_CRUD_Videojuego(Parent);
	}
}

class FactoriaMenu_C_Videojuego implements FactoriaMenu {
	private Coleccion_Videojuego Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_C_Videojuego(Coleccion, Parent);
	}
}

class FactoriaMenu_R_Videojuego implements FactoriaMenu {
	private Coleccion_Videojuego Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_R_Videojuego(Coleccion, Parent);
	}
}

class FactoriaMenu_U_Videojuego implements FactoriaMenu {
	private Coleccion_Videojuego Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_U_Videojuego(Coleccion, Parent);
	}
}

class FactoriaMenu_D_Videojuego implements FactoriaMenu {
	private Coleccion_Videojuego Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_D_Videojuego(Coleccion, Parent);
	}
}

class FactoriaMenu_CRUD_Recompensa implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_CRUD_Recompensa(Parent);
	}
}

class FactoriaMenu_C_Recompensa implements FactoriaMenu {
	private Coleccion_Recompensa Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_C_Recompensa(Coleccion, Parent);
	}
}

class FactoriaMenu_R_Recompensa implements FactoriaMenu {
	private Coleccion_Recompensa Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_R_Recompensa(Coleccion, Parent);
	}
}

class FactoriaMenu_U_Recompensa implements FactoriaMenu {
	private Coleccion_Recompensa Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_U_Recompensa(Coleccion, Parent);
	}
}

class FactoriaMenu_D_Recompensa implements FactoriaMenu {
	private Coleccion_Recompensa Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_D_Recompensa(Coleccion, Parent);
	}
}

class FactoriaMenu_CR_DLC implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_CR_DLC(Parent);
	}
}

class FactoriaMenu_C_DLC implements FactoriaMenu {
	private Coleccion_DLC Coleccion;
	private Coleccion_Videojuego Col2;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_C_DLC(Coleccion, Col2, Parent);
	}
}

class FactoriaMenu_R_DLC implements FactoriaMenu {
	private Coleccion_DLC Coleccion;
	
	public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_R_DLC(Coleccion, Parent);
	}
}

class FactoriaMenu_NotificarJugador implements FactoriaMenu {
		public iMenu FactoryMethod(iMenu Parent) {
		return new Menu_NotificarJugador(Parent);
	}
}

class FactoriaMenu_NotificarRecompensa implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
	return new Menu_NotificarRecompensa(Parent);
	}
}

class FactoriaMenu_Estadisticas implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
	return new Menu_Estadisticas(Parent);
	}
}

class FactoriaMenu_showJugadoresVideojuego implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
	return new Menu_showJugadoresVideojuego(Parent);
	}
}

class FactoriaMenu_showRecompensasConseguidas implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
	return new Menu_showRecompensasConseguidas(Parent);
	}
}

class FactoriaMenu_showJuegosCompletados implements FactoriaMenu {
	public iMenu FactoryMethod(iMenu Parent) {
	return new Menu_showJuegosCompletados(Parent);
	}
}
