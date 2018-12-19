package ruiz.victor.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.model.dao.UsuarioDao;
import ruiz.victor.web.service.SvcException;
import ruiz.victor.web.service.UsuarioSvc;


@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc{
	
	@Autowired
	private UsuarioDao dao;

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Usuario modificar(Usuario usuario) throws SvcException {
		try {
			dao.update(usuario);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return usuario;
	}

	@Override
	public Usuario buscarPorNombrePass(Usuario usuario) throws SvcException {
		Usuario res = null;
		try {
			res = dao.findByUserPass(usuario.getNombre(), usuario.getPass());
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return res;
	}
	
	@Override
	public Usuario buscarPorNombre(String nombre) throws SvcException {
		Usuario res = null;
		try {
			res = dao.findByUser(nombre);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return res;
	}

	@Override
	public List<Usuario> listar() throws SvcException {
		List<Usuario> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Usuario eliminar(String nombre) throws SvcException {
		Usuario usuario = new Usuario();
		try{
			
			usuario = buscarPorNombre(nombre);
			dao.delete(usuario);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		return usuario;
	}

	@Override
	public Usuario crear(Usuario usuario) throws SvcException {		
		try{
			dao.create(usuario);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		return usuario;
	}
	
	@Override
	public Usuario buscarPorId(int id) throws SvcException {
		Usuario res = null;
		try {
			res = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return res;
	}



}
