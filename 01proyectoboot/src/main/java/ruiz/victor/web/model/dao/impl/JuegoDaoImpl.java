package ruiz.victor.web.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ruiz.victor.web.model.Juego;

import ruiz.victor.web.model.dao.DaoException;
import ruiz.victor.web.model.dao.JuegoDao;

@Repository
public class JuegoDaoImpl implements JuegoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Juego> findAll() throws DaoException {
		List<Juego> res = null;

		try {
			String hql = "FROM Juego";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public Juego create(Juego juego) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(juego);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}
}
