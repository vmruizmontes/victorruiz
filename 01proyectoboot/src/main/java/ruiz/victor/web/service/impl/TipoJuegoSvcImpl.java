package ruiz.victor.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ruiz.victor.web.model.TipoJuego;
import ruiz.victor.web.model.dao.TipoJuegoDao;
import ruiz.victor.web.service.SvcException;
import ruiz.victor.web.service.TipoJuegoSvc;

@Service
@Transactional
public class TipoJuegoSvcImpl implements TipoJuegoSvc{
	
	@Autowired
	private TipoJuegoDao dao;
	
	@Override
	public Iterable<TipoJuego> listar() throws SvcException {
		Iterable<TipoJuego> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
