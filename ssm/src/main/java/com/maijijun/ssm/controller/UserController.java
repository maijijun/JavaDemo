package com.maijijun.ssm.controller;

import com.maijijun.ssm.model.User;

import com.maijijun.ssm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
	@RequestMapping("")
	public class UserController {

		@Resource
		private IUserService userService;

		@RequestMapping("/findUser")
		public String findUser(Model model) {
			int id = 1;
			User user = this.userService.findUserById(id);
			model.addAttribute("user", user);
			return "index";
		}
	}
