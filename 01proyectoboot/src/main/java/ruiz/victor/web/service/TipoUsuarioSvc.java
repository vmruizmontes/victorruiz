package ruiz.victor.web.service;

import ruiz.victor.web.model.TipoUsuario;

public interface TipoUsuarioSvc {

	/*
	 * Listar todos los juegos.
	 */
	public Iterable<TipoUsuario> listar() throws SvcException;

}
