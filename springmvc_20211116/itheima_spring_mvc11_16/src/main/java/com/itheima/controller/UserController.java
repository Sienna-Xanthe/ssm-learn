package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/quick23")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            //获得上传文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("E:\\upload\\" + originalFilename));
        }

    }


    @RequestMapping(value = "/quick22")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("E:\\upload\\" + originalFilename));
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId)  {
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent)  {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session)  {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save18(Date date)  {
        System.out.println(date);
    }

    //localhost:8080/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save17(@PathVariable(value = "username") String username)  {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "pxy") String username)  {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save15(@RequestBody List<User> userList) throws JsonProcessingException {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save13(VO vo) throws JsonProcessingException {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save12(String[] strs) throws JsonProcessingException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick11",params = {"username","age"})
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save11(User user) throws JsonProcessingException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick10",params = {"username","age"})
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public void save10(String username,int age) throws JsonProcessingException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick9")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    // 期望SpringMVC自动将User转换成json格式的字符串
    public User save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("kinkrit");
        user.setAge(19);
        return user;
    }

    //回写数据-->json格式返回
    @RequestMapping("/quick8")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public String save8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("aha");
        user.setAge(12);
        //使用json的转换工具将对象转换成json格式字符串的返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    //回写数据方法2
    @RequestMapping("/quick7")
    @ResponseBody //告知SpringMVC框架 不进行视图跳转，直接进行数据响应
    public String save7()  {
        return "回写数据方法2";
    }

    //回写数据方法1
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("回写数据方法1");
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        //设置模型数据
        request.setAttribute("username","第五种方式（不常用）");
        return "success";
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        //设置模型数据
        model.addAttribute("username","第四种方法");
        return "success";
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //设置模型数据
        modelAndView.addObject("username","第三种方法");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(){
        /*
        Model:模型  作用封装数据
        View: 视图  作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","第二种方法");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //请求地址  http://localgost:8080/quick
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running...");
        return "success";
    }
}
