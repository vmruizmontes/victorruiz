package ruiz.victor.web.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ruiz.victor.web.model.TipoJuego;
import ruiz.victor.web.model.TipoUsuario;
import ruiz.victor.web.model.dao.DaoException;
import ruiz.victor.web.model.dao.TipoJuegoDao;
import ruiz.victor.web.model.dao.TipoUsuarioDao;

@Repository
public class TipoUsuarioDaoImpl implements TipoUsuarioDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoUsuario> findAll() throws DaoException {		
		List<TipoUsuario> res = null;
		
		try{					
			String hql = "FROM TipoUsuario";			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
