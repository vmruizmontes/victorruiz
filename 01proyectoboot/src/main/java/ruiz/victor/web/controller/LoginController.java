package ruiz.victor.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ruiz.victor.web.model.Usuario;
import ruiz.victor.web.service.UsuarioSvc;

/**
 * Controlador para procesar el login en la web.
 * @author VRuiz
 *
 */
@Controller
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESSUSER = "user/home";
	private static final String SUCCESSADMIN = "admin/home";
	private static final String ERROR = "index2";

	@Autowired
	private UsuarioSvc svc;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String execute2(HttpServletRequest request, Model model, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Datos del formulario
			Usuario usuario = new Usuario();
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setPass(request.getParameter("pass"));

			// Buscar
			usuario = svc.buscarPorNombrePass(usuario);

			if (usuario == null) {
				request.setAttribute("error", "Nombre/Pass incorrecto");
				return ERROR;
			} else {
				// Guardar en la sesi�n
				request.getSession().setAttribute("sesionusuario", usuario);
				if (usuario.getTipousuario().getRango().equals("admin")) {
					return SUCCESSADMIN;
				} else if (usuario.getTipousuario().getRango().equals("user")) {
					return SUCCESSUSER;
				}
				return ERROR;
			}

		} catch (Exception ex) {
			request.setAttribute("error", "Error al conectar.");
			return ERROR;
		}
	}
}
