package com.fbt.talentex.user.service.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView welcome(HttpSession session, ModelAndView model,
			HttpServletRequest request) throws IOException {
		model = new ModelAndView("index");
		return model;
	}

}
