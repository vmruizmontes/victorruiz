package ruiz.victor.web.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ruiz.victor.web.model.TipoJuego;

import ruiz.victor.web.model.dao.DaoException;
import ruiz.victor.web.model.dao.TipoJuegoDao;

@Repository
public class TipoJuegoDaoImpl implements TipoJuegoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoJuego> findAll() throws DaoException {		
		List<TipoJuego> res = null;
		
		try{					
			String hql = "FROM TipoJuego";			
			res = sessionFactory.getCurrentSession().createQuery(hql).list();		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
