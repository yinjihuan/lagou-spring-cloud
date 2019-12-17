package org.spring.cloud.multiple.demo.webpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 路由控制器，只负责页面路由
 * @author yinjihuan
 *
 */
@Controller
public class RouteController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
