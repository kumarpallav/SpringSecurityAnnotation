package com.waverin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author Kumar Pallav
 *
 */
@Controller
public class AdminController {
	@RequestMapping("login")
	protected String login(){
		return "admin/login";
	} 

}
