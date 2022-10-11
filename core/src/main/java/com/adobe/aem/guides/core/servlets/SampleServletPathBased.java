package com.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(immediate = true,
			service = Servlet.class,
			property = {
					"sling.servlet.extention=txt",
					"sling.servlet.paths=/bin/osgi",
					"sling.servlet.paths=/bin/foo",
					"sling.servlet.method=get"
			}
		)


public class SampleServletPathBased extends SlingSafeMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.write("this is my path based  servlet");
	}

}
