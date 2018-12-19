package ruiz.victor.web.model.dao;

import java.util.List;

import ruiz.victor.web.model.Torneo;

public interface TorneoDao {

	/**
	 * Listar torneos
	 * 
	 * @return
	 */
	public List<Torneo> findAll();

	/**
	 * Guardar torneo
	 * 
	 * @param torneo
	 * @return
	 */
	public Torneo save(Torneo torneo);

	/**
	 * modificar datos del torneo
	 * 
	 * @param id
	 * @return
	 */
	public Torneo update(int id);

	/**
	 * Eliminar torneo
	 * 
	 * @param id
	 * @return
	 */
	public Torneo delete(int id);

}
