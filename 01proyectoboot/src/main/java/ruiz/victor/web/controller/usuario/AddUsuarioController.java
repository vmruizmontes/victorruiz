package ruiz.victor.web.controller.usuario;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ruiz.victor.web.model.TipoUsuario;
import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.service.TipoUsuarioSvc;
import ruiz.victor.web.service.UsuarioSvc;

/**
 * Controlador para modificar usuarios que redirecciona al HOME dependiendo del
 * rango de usuario. * 
 * @author VRuiz
 *
 */
@Controller
@RequestMapping(value = "/addusuario")
public class AddUsuarioController {

	private static final String ATT_ITEM = "usuario";
	private static final String ATT_LISTA = "lista";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "admin/home";
	private static final String SUCCESS2 = "user/home";
	private static final String ERROR = "error";

	@Autowired
	private UsuarioSvc svc;

	@Autowired
	private TipoUsuarioSvc pSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		// Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// nuevo: simplemente guardar la lista para el select y pasar al form
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Usuario usuario, Model model) {
		try {
			// Incluir elementos para la selección
			model.addAttribute(ATT_LISTA, pSvc.listar());
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String execute(@ModelAttribute Usuario usuario, HttpServletRequest request, HttpSession sesion, Model model,
			Locale locale) {
		try {
			// Incluir elementos para la selección de nuevo porque vamos hacia el formulario			
			model.addAttribute(ATT_LISTA, pSvc.listar());
			
			if (usuario.getId() == null) {				
				List<TipoUsuario> tipo1 = (List<TipoUsuario>) pSvc.listar();
				usuario.setTipousuario(tipo1.get(1));
				svc.crear(usuario);
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito", null, locale));

				// Limpiar formulario
				model.addAttribute(ATT_ITEM, new Usuario());
				return SUCCESS;
			} else {
				svc.modificar(usuario);
				model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito", null, locale));

				// Limpiar formulario
				model.addAttribute(ATT_ITEM, new Usuario());
				Usuario usuario2 = (Usuario) sesion.getAttribute("sesionusuario");
				if (usuario2.getTipousuario().getRango().equals("user")) {
					request.getSession().setAttribute("sesionusuario", usuario);
					return SUCCESS2;
				} else if (usuario2.getTipousuario().getRango().equals("admin")) {
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
		return SUCCESS;
	}
}
