package com.ssm.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class ControllerTest implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView m=new ModelAndView();
		m.addObject("msg","第一个Spring MVC程序");
		m.setViewName("/WEB-INF/jsp/welcome.jsp");
		return m;
	}
}
