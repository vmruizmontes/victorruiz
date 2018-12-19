package ruiz.victor.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ruiz.victor.web.model.Juego;
import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.model.dao.JuegoDao;
import ruiz.victor.web.model.dao.UsuarioDao;
import ruiz.victor.web.service.JuegoSvc;
import ruiz.victor.web.service.SvcException;
import ruiz.victor.web.service.UsuarioSvc;


@Service
@Transactional
public class JuegoSvcImpl implements JuegoSvc{
	
	@Autowired
	private JuegoDao dao;

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

	@Override
	public List<Juego> listar() throws SvcException {
		List<Juego> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}



	@Override
	public Juego crear(Juego juego) throws SvcException {
		try{
			dao.create(juego);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		return juego;
	}



}
