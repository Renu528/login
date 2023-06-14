package com.avengers.bus.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/dashboard")
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		// Allow access to login and logout pages without authentication
		if (path.equals("/login") || path.equals("/logout")) {
			chain.doFilter(request, response);
			return;
		}

		// Check if user is authenticated
		if (httpRequest.getSession().getAttribute("authenticatedUser") != null) {
			// User is authenticated, allow access to requested page
			chain.doFilter(request, response);
		} else {
			// User is not authenticated, redirect to login page
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
		}
	}

	@Override
	public void destroy() {
		// Cleanup resources, if needed
	}
}
