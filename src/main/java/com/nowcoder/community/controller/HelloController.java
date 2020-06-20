package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayhello()
    {
        return "hello spring";
    }

    @Autowired
    AlphaService alphaService;
    @RequestMapping("/data")
    @ResponseBody
    public String get()
    {
        return alphaService.find();
    }


    //springmvc获得请求的对象
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration=request.getHeaderNames();
        while(enumeration.hasMoreElements())
        {
            String name =enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer=response.getWriter())
        {
            writer.write("<h1>牛客网</h1>");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //springmvc
    //Get请求
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current",required = false,defaultValue = "1") int current,
            @RequestParam(name="limit",required = false,defaultValue = "10") int limit)
    {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }


    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id)
    {
        System.out.println(id);
        return "student";
    }

    //post请求,参数的名字同表单中的名字一致
    @RequestMapping(path="testForm",method=RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name ,String age)
    {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher()
    {
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","黄志高");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return mav;
    }

    //第二种方式推荐使用
    @RequestMapping(path="/school",method = RequestMethod.GET)
    public String getSchool(Model model)
    {
        model.addAttribute("name","黄志高");
        model.addAttribute("age",30);
        return "/demo/view";
    }

    //响应JSON数据(异步请求)
    //JSON对象->JSON字符串->JS对象
    @RequestMapping(path="/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp()
    {
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",2000);
        return emp;
    }
}
