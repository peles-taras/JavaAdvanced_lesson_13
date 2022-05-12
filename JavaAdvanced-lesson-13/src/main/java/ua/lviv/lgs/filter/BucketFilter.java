package ua.lviv.lgs.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import ua.lviv.lgs.shared.FilterService;
import ua.lviv.lgs.web.Role;

@WebFilter("/bucket.jsp")
public class BucketFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -5341532700278259570L;

	private FilterService filterService = FilterService.getFilterService();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(Role.USER));
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
