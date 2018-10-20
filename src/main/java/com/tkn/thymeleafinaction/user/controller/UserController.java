package com.tkn.thymeleafinaction.user.controller;

import com.tkn.thymeleafinaction.user.model.User;
import com.tkn.thymeleafinaction.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *  查询所有用户
     * @param model
     * @return
     */
    @GetMapping()
    public ModelAndView getListUser(Model model){
        model.addAttribute("userList",userService.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);

    }
    /**
     *  获取id用户
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView getUserById(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",userService.getUserById(id));
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);


    }

    /**
     *  获取form页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView getform(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);

    }
    /**
     *  添加用户
     * @return
     */
    @PostMapping()
    public ModelAndView addUser(User user){
        userService.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");

    }
    /**
     *  删除用户
     * @return
     */
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,Model model){

        userService.deleteUser(id);
        model.addAttribute("userList",userService.listUser());
        model.addAttribute("title","删除用户");
        return new ModelAndView("users/list","userModel",model);

    }

    /**
     *  修改用户
     * @return
     */
    @GetMapping("modify/{id}")
    public ModelAndView update(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);

    }



}
