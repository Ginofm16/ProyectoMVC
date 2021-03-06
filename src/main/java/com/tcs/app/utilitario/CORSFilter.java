package com.tcs.app.utilitario;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter{

	/*Esta clase se usara para las pruebas unitarias.*/
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin","*");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		res.setHeader("Access-Control-Allow-Headers","*");
		res.setHeader("Access-Control-Max-Age", "3600");
		chain.doFilter(req, res);
		
	}
	

}
