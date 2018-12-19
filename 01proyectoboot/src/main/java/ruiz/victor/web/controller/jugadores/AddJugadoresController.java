package ruiz.victor.web.controller.jugadores;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



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


import ruiz.victor.web.model.Juego;
import ruiz.victor.web.model.Jugador;
import ruiz.victor.web.service.JuegoSvc;
import ruiz.victor.web.service.JugadorSvc;
import ruiz.victor.web.service.TipoJuegoSvc;


/**
 * Controlador para crear jugadores. Actualmenten o está implementado.
 * @author usuario
 *
 */
@Controller
@RequestMapping(value = "/addjugador")
public class AddJugadoresController {

	private static final String ATT_ITEM = "jugador";
	private static final String ATT_LISTA = "lista";
	private static final String ATT_EXITO = "msg";
	private static final String SUCCESS = "user/inscribir";
	private static final String ERROR = "error";

	@Autowired
	private JugadorSvc svc;

	@Autowired
	private JuegoSvc pSvc;

	@Autowired
	private MessageSource messages;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		// Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// nuevo: simplemente guardar la lista para el select y pasar al form
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Juego juego, @ModelAttribute Jugador jugador, Model model) {
		try {
			
			jugador=new Jugador();
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
	public String execute(@ModelAttribute Juego juego, @ModelAttribute Jugador jugador, Model model, Locale locale) {
		try {
			// Incluir elementos para la selección de nuevo porque vamos hacia el
			// formulario
			model.addAttribute(ATT_LISTA, pSvc.listar());

			svc.guardar(jugador);
			System.out.println("*******IMPRIMIENDO:"+ jugador.getId()+jugador.getJuego()+jugador.getUsuario()+jugador.getFecha());

			model.addAttribute(ATT_EXITO, messages.getMessage("mensaje.exito", null, locale));

			// Limpiar formulario
			model.addAttribute(ATT_ITEM, new Jugador());

			return SUCCESS;
		} catch (Exception e) {
			model.addAttribute(ERROR, e);
			return ERROR;
		}
	}

}
