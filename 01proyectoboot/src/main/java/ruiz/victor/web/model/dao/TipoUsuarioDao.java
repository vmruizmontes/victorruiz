package ruiz.victor.web.model.dao;

import java.util.List;

import ruiz.victor.web.model.TipoUsuario;


public interface TipoUsuarioDao {
	
	/*
	 * Listar todos los usuarios.
	 */
	public List<TipoUsuario> findAll() throws DaoException;
	

	
}
