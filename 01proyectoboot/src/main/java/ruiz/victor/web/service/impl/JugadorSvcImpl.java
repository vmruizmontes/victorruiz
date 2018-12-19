package ruiz.victor.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ruiz.victor.web.model.Jugador;
import ruiz.victor.web.model.Torneo;
import ruiz.victor.web.model.dao.JugadorDao;
import ruiz.victor.web.service.JugadorSvc;
import ruiz.victor.web.service.SvcException;

@Service
@Transactional
public class JugadorSvcImpl implements JugadorSvc {

	@Autowired
	private JugadorDao dao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

	@Override
	public List<Jugador> listar() throws Exception {
		List<Jugador> res = null;

		try {
			res = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return res;
	}

	@Override
	public void guardar(Jugador jugador) throws Exception {
		try {
			dao.create(jugador);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

}
