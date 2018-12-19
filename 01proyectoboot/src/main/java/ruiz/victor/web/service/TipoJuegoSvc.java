package ruiz.victor.web.service;

import ruiz.victor.web.model.TipoJuego;

public interface TipoJuegoSvc {

	/*
	 * Listar todos los juegos.
	 */
	public Iterable<TipoJuego> listar() throws SvcException;

}
