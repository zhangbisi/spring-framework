package com.zhuri.web.controller;

import com.zhuri.web.dao.entity.UpmsUser;
import com.zhuri.web.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
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


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/manage/user/create.jsp";
    }

    @GetMapping(value = "getById")
    public String getByByPrimaryKey(@RequestParam("id")int id){
		UpmsUser user = upmsUserService.selectByPrimaryKey(id);
        return user.toString();
    }

}
