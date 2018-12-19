package ruiz.victor.web.service;

import ruiz.victor.web.model.Juego;

public interface JuegoSvc {
	


	/**
	 * Buscar todos 
	 * @return lista de coincidencias
	 * @throws SvcException error al buscar
	 * @throws Exception 
	 */
	public Iterable<Juego> listar() throws SvcException, Exception;

	public Juego crear(Juego juego) throws SvcException;

}
