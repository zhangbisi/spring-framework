package com.zhuri.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :
 * @create : 2019-08-17 18:33
 * @description :
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping(value = "getUserInfo")
    public ModelAndView getUserListView(){
		ModelAndView model = new ModelAndView("/user/index.jsp");
		return model;
	}

}
