package ruiz.victor.web.model.dao;

import java.util.List;

import ruiz.victor.web.model.Jugador;
import ruiz.victor.web.model.Torneo;

public interface JugadorDao {

	/**
	 * Listar todos los jugadores.
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Jugador> findAll() throws DaoException;

	/**
	 * Guardar nuevo jugador
	 * 
	 * @param jugador
	 * @throws DaoException
	 */
	public void create(Jugador jugador) throws DaoException;

	/**
	 * Eliminar jugador
	 * 
	 * @param id
	 */
	public void delete(int id);

}
