package com.hanul.app.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hanul.app.command.AnCommand;
import com.hanul.app.command.AnJoinCommand;
import com.hanul.app.command.AnLoginCommand;

@Controller
public class AnController {

	AnCommand command;

	@RequestMapping(value = "/anLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String anLogin(HttpServletRequest req, Model model) {
		System.out.println("anLogin()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String member_id = (String) req.getParameter("member_id");
		String password = (String) req.getParameter("password");

		System.out.println(member_id);
		System.out.println(password);

		model.addAttribute("member_id", member_id);
		model.addAttribute("password", password);

		command = new AnLoginCommand();
		command.execute(model);

		return "anLogin";
	}

	@RequestMapping(value = "/anJoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String anJoin(HttpServletRequest req, Model model) {
		System.out.println("anJoin()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String member_id = (String) req.getParameter("member_id");
		String password = (String) req.getParameter("password");
		String name = (String) req.getParameter("name");
		String phone = (String) req.getParameter("phone");
		String email = (String) req.getParameter("email");

		System.out.println(member_id);
		System.out.println(password);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);

		model.addAttribute("member_id", member_id);
		model.addAttribute("password", password);
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);

		command = new AnJoinCommand();
		command.execute(model);

		return "anJoin";
	}

}
