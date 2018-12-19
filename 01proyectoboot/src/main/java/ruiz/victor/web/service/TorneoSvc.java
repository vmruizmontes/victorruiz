package ruiz.victor.web.service;

import java.util.List;

import ruiz.victor.web.model.Torneo;

public interface TorneoSvc {
	
	
	/*
	 * Listar todos los torneos.
	 */
	public List<Torneo> listar ();
	
	/*
	 * guardar usuario.
	 */
	public Torneo guardar(Torneo torneo);
	
	/*
	 * Modificar datos de un torneo
	 */
	public Torneo modificar(int id);

}
