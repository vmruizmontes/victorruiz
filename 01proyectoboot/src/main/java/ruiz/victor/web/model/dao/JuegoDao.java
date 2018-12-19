package ruiz.victor.web.model.dao;

import java.util.List;

import ruiz.victor.web.model.Juego;

public interface JuegoDao {
	
	/**
	 * Listar todos los juegos
	 * @return
	 */
	public List<Juego> findAll() throws DaoException;
	
	/**
	 * Crear nuevo juego
	 * @param juego
	 * @return
	 * @throws DaoException
	 */
	public Juego create(Juego juego) throws DaoException;
	
	

}
