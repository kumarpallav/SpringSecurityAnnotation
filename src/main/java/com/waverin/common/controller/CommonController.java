package com.waverin.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Kumar Pallav 
 *
 */
@Controller
public class CommonController {
@RequestMapping("index")
protected String index(){
	System.out.println("*****");
	return "common/index";
}
}
