package com.gsafety.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

public class HelloWorldExample extends HttpServlet {
	private static final long serialVersionUID = -6593274907821061823L;
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + "用户信息" + "</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<a href=\"../helloworld.html\">");
		out.println("<img src=\"../images/code.gif\" height=24 "
				+ "width=24 align=right border=0 alt=\"view code\"></a>");
		out.println("<a href=\"../index.html\">");
		out.println("<img src=\"../images/return.gif\" height=24 "
				+ "width=24 align=right border=0 alt=\"return\"></a>");
		out.println("<h1>" + "用户信息" + "</h1>");
		Assertion assertion = (Assertion) request.getSession().getAttribute(
				AbstractCasFilter.CONST_CAS_ASSERTION);
		if (null != assertion) {
			out.println(" Log | ValidFromDate =:"
					+ assertion.getValidFromDate() + "<br>");
			out.println(" Log | ValidUntilDate =:"
					+ assertion.getValidUntilDate() + "<br>");
			Map<Object, Object> attMap = assertion.getAttributes();
			out.println(" Log | getAttributes Map size = " + attMap.size()
			+ "<br>");
			for (Entry<Object, Object> entry : attMap.entrySet()) {
				out.println("     | " + entry.getKey() + "=:"
						+ entry.getValue() + "<br>");
			}
			AttributePrincipal principal = assertion.getPrincipal();
			// AttributePrincipal principal = (AttributePrincipal) request
			// .getUserPrincipal();
			String username = null;
			out.print(" Log | UserName:");
			if (null != principal) {
				username = principal.getName();
				out.println("<span style='color:red;'>" + username
						+ "</span><br>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

}
