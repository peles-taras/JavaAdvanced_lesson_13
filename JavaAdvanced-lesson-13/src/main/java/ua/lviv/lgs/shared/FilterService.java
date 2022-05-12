package ua.lviv.lgs.shared;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.web.Role;

public class FilterService {

	private static FilterService filterService;

	private FilterService() {
	}

	public static FilterService getFilterService() {
		if (filterService == null) {
			filterService = new FilterService();
		}
		return filterService;
	}

	public void doFilterValidation(ServletRequest req, ServletResponse resp, FilterChain chain, List<Role> role)
			throws IOException, ServletException {
		try {
			HttpSession session = ((HttpServletRequest) req).getSession(true);
			Role userRole = Role.valueOf((String) session.getAttribute("role"));

			if (userRole != null && role.contains(userRole)) {
				chain.doFilter(req, resp);
			} else {
				((HttpServletRequest) req).getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			((HttpServletRequest) req).getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
