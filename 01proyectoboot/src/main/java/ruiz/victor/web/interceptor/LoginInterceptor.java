package ruiz.victor.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ruiz.victor.web.model.Usuario;

/**
 * Gestionar el acceso a las distintas uri, dependiendo de si hay usuario en la
 * sesión. * 
 * @author VRuiz
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static final String ATT_USER = "sesionusuario";
	private static final String INICIO = "/inicio";
	private static final String LOGIN = "/login";
	private static final String INDEX = "index.jsp";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);

		if (usuario == null) {
			if (!uri.endsWith(INICIO) && !uri.endsWith(LOGIN)) {
				response.sendRedirect(INDEX);
				return false;
			}
		}
		return true;
	}

}
