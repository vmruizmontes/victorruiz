package ruiz.victor.web.model.dao;

import java.util.List;

import ruiz.victor.web.model.Usuario;

public interface UsuarioDao {

	/**
	 * Buscar usuario concreto para comprobar si existe a la hora de registrarse o
	 * logearse
	 * 
	 * @param nombre
	 * @param pass
	 * @return
	 * @throws DaoException
	 * @throws Exception
	 */
	public Usuario findByUserPass(String nombre, String pass) throws DaoException, Exception;

	/**
	 * Listar todos los usuarios.
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<Usuario> findAll() throws DaoException;

	/**
	 * Eliminar usuario
	 * 
	 * @param usuario
	 * @return
	 * @throws DaoException
	 */
	public Usuario delete(Usuario usuario) throws DaoException;

	/**
	 * Modificar usuario
	 * 
	 * @param usuario
	 * @return
	 * @throws DaoException
	 */
	public Usuario update(Usuario usuario) throws DaoException;

	/**
	 * Buscar usuario por su nombre
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	public Usuario findByUser(String nombre) throws Exception;

	/**
	 * Crear usuario
	 * 
	 * @param usuario
	 * @return
	 * @throws DaoException
	 */
	public Usuario create(Usuario usuario) throws DaoException;

	/**
	 * Buscar usuario por id
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public Usuario findById(int id) throws DaoException;

}
