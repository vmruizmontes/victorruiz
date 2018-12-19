package ruiz.victor.web.model.dao;

import java.util.List;


import ruiz.victor.web.model.TipoJuego;

public interface TipoJuegoDao {
	
	/**
	 * Listar todos los juegos
	 * @return
	 */
	public List<TipoJuego> findAll() throws DaoException;

}
