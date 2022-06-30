/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.filter;

//Start of user code (user defined imports)

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.MDC;

//End of user code

/**
 * Description of MDCFilter.
 * 
 * @author NIKITHRA
 */
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@WebFilter(urlPatterns = "/*")
//@Component
public class MDCFilter implements Filter{
	private final Logger logger = Logger.getLogger(MDCFilter.class);
	private ArrayList<String> urlList;
	// Start of user code (user defined attributes for MDCFilter)

	// End of user code
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		logger.debug("Filter Running");

		MDC.put("ip", request.getRemoteAddr() );

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		
		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
	}

}
