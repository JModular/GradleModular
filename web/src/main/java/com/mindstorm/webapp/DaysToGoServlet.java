package com.mindstorm.webapp;

import java.io.IOException;
import javax.servlet.http.*;

import com.android.utils.JDateUtils;


public class DaysToGoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(JDateUtils.daysToNewYear() + " days remaining in this year. Learn Gradle now!");
	}
}
