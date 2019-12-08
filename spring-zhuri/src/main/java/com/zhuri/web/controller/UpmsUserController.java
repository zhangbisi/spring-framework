package com.zhuri.web.controller;

import com.zhuri.web.dao.entity.UpmsUser;
import com.zhuri.web.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :
 * @create : 2019-08-17 18:33
 * @description :
 */
@RestController
@RequestMapping("/upmsUser")
public class UpmsUserController {

    @Autowired
    private UpmsUserService upmsUserService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
		System.out.println("进入首页2");
        return "/user/index.jsp";
    }


	@PostMapping(value = "/create")
    public String create(@RequestBody UpmsUser upmsUser) {
		System.out.println("添加用户数据upmsUser="+upmsUser.toString());
        return "/manage/user/create.jsp";
    }

    @GetMapping(value = "getById")
    public String getByByPrimaryKey(@RequestParam("id")int id){
		UpmsUser user = new UpmsUser();//upmsUserService.selectByPrimaryKey(id);
        return user.toString();
    }
	@GetMapping(value = "getUserList")
    public ModelAndView getUserListView(){
		ModelAndView model = new ModelAndView("/user/index.jsp");
		return model;
	}

}
