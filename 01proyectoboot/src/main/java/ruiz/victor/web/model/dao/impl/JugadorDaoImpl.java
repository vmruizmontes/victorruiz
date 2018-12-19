package ruiz.victor.web.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ruiz.victor.web.model.Jugador;
import ruiz.victor.web.model.dao.DaoException;
import ruiz.victor.web.model.dao.JugadorDao;

@Repository
public class JugadorDaoImpl implements JugadorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> findAll() throws DaoException {
		List<Jugador> res = null;

		try {
			String hql = "FROM Jugador";
			res = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return res;
	}

	@Override
	public void create(Jugador jugador) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(jugador);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
}
