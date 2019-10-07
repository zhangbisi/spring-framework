package com.wisdom.annotation.upms.controller;


import com.wisdom.annotation.upms.dao.model.UpmsLog;
import com.wisdom.annotation.upms.service.UpmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 日志controller
 *
 */
@Controller
@RequestMapping("/manage/log")
public class UpmsLogController {

    @Autowired
    private UpmsLogService upmsLogService;

    @RequestMapping(value = "/index", method = GET)
    public String index() {
        return "/manage/log/index.jsp";
    }

    @RequestMapping(value = "/list", method = GET)
    @ResponseBody
    public Object getUpmsLogBy(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        UpmsLog row = upmsLogService.selectByPrimaryKey("11");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("row", row);
        return result;
    }


    @RequestMapping(value = "/delete/{ids}", method = GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String id) {
        int count = upmsLogService.removeByPrimaryKey(id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }

}