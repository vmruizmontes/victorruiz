package ruiz.victor.web.controller.usuario;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.service.JuegoSvc;
import ruiz.victor.web.service.TipoJuegoSvc;
import ruiz.victor.web.service.TipoUsuarioSvc;
import ruiz.victor.web.service.UsuarioSvc;

//Indica que se trata de un controlador
@Controller
public class AdministrarUsuarioController {

	private static final String ATT_LISTA = "lista";
	private static final String SUCCESSUSER = "index";
	private static final String INICIO = "inicio";
	private static final String SUCCESSADMIN = "admin/home";
	private static final String SUCCESS = "user/list";
	private static final String SUCCESS2 = "user/form";
	private static final String SUCCESS3 = "administrarusuarios";
	private static final String SUCCESS4 = "user/update";
	private static final String SUCCESS5 = "admin/form";
	private static final String ERROR = "error";
	private static final String ATT_ITEM = "usuario";
	private static final String SUCCESSUSER2 = "user/home";
	private static final String INSCRIBIR = "user/inscribir";



	// Autoinyección del servicio
	@Autowired
	private UsuarioSvc svc;

	@Autowired
	private TipoUsuarioSvc pSvc;
	

	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
    public String listar(@ModelAttribute Usuario usuario, HttpServletRequest request, Model model){
    	try {
    		
    		model.addAttribute(ATT_LISTA, svc.buscarPorNombre((String) request.getSession().getAttribute("nombre")));
			return SUCCESS4;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value="/inscribir", method=RequestMethod.GET)
    public String inscribir(@ModelAttribute Usuario usuario, HttpServletRequest request, Model model){
    	try {
    		model.addAttribute(ATT_LISTA, pSvc.listar());
			return INSCRIBIR;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
    }

	@RequestMapping(value="/sesion", method=RequestMethod.GET)
    public String borrarsesion(@ModelAttribute Usuario usuario, HttpSession sesion, Model model){
    	try {
    		
    		sesion.removeAttribute("sesionusuario");
			return INICIO;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public String execute(@RequestParam int id, HttpServletRequest request, Model model) {// , HttpServletRequest request) {
		try {
			model.addAttribute(ATT_ITEM, svc.buscarPorId(id));

			// Incluir elementos para la selección porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, pSvc.listar());

			//Usuario usuario = svc.buscarPorId(id);
			
			Usuario usuario  =  (Usuario) request.getSession().getAttribute("sesionusuario");
			
			
			if(usuario.getTipousuario().getRango().equals("user")) {
				return SUCCESS2;
			}
			else if(usuario.getTipousuario().getRango().equals("admin")){
				return SUCCESS5;
			}
			else {
				System.out.println(usuario.getNombre());
				return ERROR;
			}
			
			
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}


	@RequestMapping(value = "/administrarusuarios", method = RequestMethod.GET)
	public String execute(HttpServletRequest request, Model model) {
		try {

			model.addAttribute(ATT_LISTA, svc.listar());
			
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String view(HttpServletRequest request, Model model, Locale locale, HttpServletResponse response) {
		try {
			Usuario usuario = new Usuario();			
			svc.eliminar((String) request.getParameter("nombre"));
			usuario = (Usuario) request.getSession().getAttribute("sesionusuario");
			
			if (usuario.getTipousuario().getRango().equals("admin")) {
				return SUCCESSADMIN;
			}

			else if (usuario.getTipousuario().getRango().equals("user")) {
				return SUCCESSUSER;
			} else {
				return SUCCESS3;
			}

		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}
	
	@RequestMapping(value = "/volver", method = RequestMethod.GET)
	public String volver(HttpServletRequest request, Model model, Locale locale, HttpServletResponse response) {
		try {
			Usuario usuario = new Usuario();
			usuario = (Usuario) request.getSession().getAttribute("sesionusuario");
			
			if (usuario.getTipousuario().getRango().equals("admin")) {
				return SUCCESSADMIN;
			}

			else if (usuario.getTipousuario().getRango().equals("user")) {
				return SUCCESSUSER2;
			} else {
				return SUCCESS3;
			}

		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}

}
