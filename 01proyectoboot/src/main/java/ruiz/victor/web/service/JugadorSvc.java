package ruiz.victor.web.service;

import java.util.List;

import ruiz.victor.web.model.Jugador;
import ruiz.victor.web.model.Torneo;

public interface JugadorSvc {
	
	/*
	 * Listar todos los jugadores.
	 */
	public List<Jugador> listar () throws SvcException, Exception;
	
	/*
	 * guardar jugador.
	 */
	public void guardar(Jugador jugador) throws SvcException, Exception;
	
	/*
	 * eliminar jugador
	 */
	public void eliminar(int id);

}
