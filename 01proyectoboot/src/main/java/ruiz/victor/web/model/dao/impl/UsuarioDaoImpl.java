package ruiz.victor.web.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.model.dao.DaoException;
import ruiz.victor.web.model.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Usuario findByUserPass(String nombre, String pass) throws Exception {
		Usuario res = null;

		try{					
			String hql = "FROM Usuario u WHERE u.nombre=:nombre " +
						 "AND u.pass=:pass";
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql).
					setParameter("nombre", nombre).
					setParameter("pass", pass).
					uniqueResult();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
	@Override
	public Usuario findByUser(String nombre) throws Exception {
		Usuario res = null;

		try{					
			String hql = "FROM Usuario u WHERE u.nombre=:nombre ";
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql).
					setParameter("nombre", nombre).					
					uniqueResult();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() throws DaoException{
		List<Usuario> res = null;
		
		try{					
			String hql = "FROM Usuario";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@Override
	public Usuario delete(Usuario usuario) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(usuario);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		return usuario;
		
	}

	@Override
	public Usuario update(Usuario usuario) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(usuario);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		return usuario;
		
	}
	@Override
	public Usuario create(Usuario usuario) throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(usuario);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		return usuario;
	}
	@Override
	public Usuario findById(int id) throws DaoException {
		Usuario res = null;

		try{					
			String hql = "FROM Usuario u WHERE u.id=:id ";
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql).
					setParameter("id", id).					
					uniqueResult();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}
}
