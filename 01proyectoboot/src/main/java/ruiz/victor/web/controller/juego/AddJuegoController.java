package ruiz.victor.web.controller.juego;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ruiz.victor.web.model.Juego;

import ruiz.victor.web.service.JuegoSvc;
import ruiz.victor.web.service.TipoJuegoSvc;

/**
 * Controlador para la creación de juegos. En GET crea el formulario vacio y en
 * POST envía los datos de los juegos nuevos * 
 * @author VRuiz
 *
 */
@Controller
@RequestMapping(value = "/addjuego")
public class AddJuegoController {

	private static final String ATT_ITEM = "juego";
	private static final String ATT_LISTA = "lista";
	private static final String ATT_EXITO = "msg";
	private static final String SUCCESS = "game/form";
	private static final String ERROR = "error";

	@Autowired
	private JuegoSvc svc;

	@Autowired
	private TipoJuegoSvc pSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

	}

	// nuevo: simplemente guardar la lista para el select y pasar al form
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Juego juego, Model model) {
		try {

			// Incluir elementos para la selección
			model.addAttribute(ATT_LISTA, pSvc.listar());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}

	// guardar: almacenar el producto, también se vuelve a cargar la lista para el
	// select ya que se vuelve al formulario
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@ModelAttribute Juego juego, Model model, Locale locale) {
		try {
			// Incluir elementos para la selección de nuevo porque vamos hacia el
			// formulario
			model.addAttribute(ATT_LISTA, pSvc.listar());

			svc.crear(juego);

			model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito", null, locale));

			// Limpiar formulario
			model.addAttribute(ATT_ITEM, new Juego());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}

}
