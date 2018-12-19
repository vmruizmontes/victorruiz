package ruiz.victor.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.service.UsuarioSvc;



/**
 * Controlador para crear Torneo. Actualmente no está implementado.
 * @author VRuiz
 *
 */
@Controller
public class CrearTorneoController {
		
	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "modificaruser";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private UsuarioSvc svc;	

	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/creartorneo", method=RequestMethod.GET)
    public String execute(HttpServletRequest request, Model model){
    	try {
    		
    		model.addAttribute(ATT_LISTA, svc.buscarPorNombre((String) request.getSession().getAttribute("nombre")));
			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
