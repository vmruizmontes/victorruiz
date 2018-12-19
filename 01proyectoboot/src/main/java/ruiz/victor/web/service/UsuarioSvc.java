package ruiz.victor.web.service;

import java.util.List;

import ruiz.victor.web.model.Torneo;
import ruiz.victor.web.model.Usuario;

public interface UsuarioSvc {
	
	/**
	 * Buscar usuario concreto para comprobar si existe a la hora de registrarse o logearse
	 * @param usuario
	 * @return
	 * @throws SvcException
	 */
	public Usuario buscarPorNombrePass(Usuario usuario) throws SvcException;
	
	/**
	 * Listar todos los usuarios.
	 * @return
	 * @throws SvcException
	 */
	public List<Usuario> listar() throws SvcException;
	
	/**
	 * Eliminar usuario.
	 * @param nombre
	 * @return
	 * @throws SvcException
	 */
	public Usuario eliminar(String nombre) throws SvcException;
	
	/**
	 * Modificar datos de un usuario
	 * @param usuario
	 * @return
	 * @throws SvcException
	 */
	public Usuario modificar(Usuario usuario) throws SvcException;

	/**
	 * Buscar usuario por nombre
	 * @param nombre
	 * @return
	 * @throws SvcException
	 */
	public Usuario buscarPorNombre(String nombre) throws SvcException;
	
	/**
	 * Crear usuario
	 * @param usuario
	 * @return
	 * @throws SvcException
	 */
	public Usuario crear(Usuario usuario) throws SvcException;

	/**
	 * Buscar usuario por ID
	 * @param id
	 * @return
	 * @throws SvcException
	 */
	public Usuario buscarPorId(int id) throws SvcException;

	

}
