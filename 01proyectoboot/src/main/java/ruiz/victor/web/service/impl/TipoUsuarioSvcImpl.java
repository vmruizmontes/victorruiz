package ruiz.victor.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ruiz.victor.web.model.TipoUsuario;
import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.model.dao.TipoUsuarioDao;
import ruiz.victor.web.model.dao.UsuarioDao;
import ruiz.victor.web.service.SvcException;
import ruiz.victor.web.service.TipoUsuarioSvc;
import ruiz.victor.web.service.UsuarioSvc;


@Service
@Transactional
public class TipoUsuarioSvcImpl implements TipoUsuarioSvc{
	
	@Autowired
	private TipoUsuarioDao dao;


	@Override
	public List<TipoUsuario> listar() throws SvcException {
		List<TipoUsuario> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}






}
