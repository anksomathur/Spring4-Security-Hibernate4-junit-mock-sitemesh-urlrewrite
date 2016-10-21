package com.apsutil.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apsutil.jsonview.AjaxResponseBody;
import com.apsutil.jsonview.Views;
import com.apsutil.model.User;
import com.fasterxml.jackson.annotation.JsonView;




@Controller
public class TestController {
		@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	    public String homePage(ModelMap model) {
	        model.addAttribute("greeting", "Hi, Welcome to mysite");
	        return "welcome";
	    }
	 
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        System.out.println("Admin page Called");
	        return "admin";
	    }
	    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	    public @ResponseBody String helloWorld() {
	         return "Hello World!";
	    }
	    
	    @JsonView(Views.Public.class)//To filter the views as defined in use object
	    @RequestMapping(value = "/admin/getuserDetails/{id}", method = RequestMethod.GET)
	    public @ResponseBody AjaxResponseBody<User> adminUser(@PathVariable Long id) {
	        User user = getPrincipalUser();
	        System.out.println("Admin User page Called");
	        AjaxResponseBody<User> ajaxResponse= new AjaxResponseBody<>();
	        ajaxResponse.setObj(user);
	        return ajaxResponse;
	    }
	   /* @JsonView(Views.Public.class)//To filter the views as defined in use object
	    @RequestMapping(value = "/getuserDetails/{id}", method = RequestMethod.GET)
	    public @ResponseBody AjaxResponseBody<User> adminUser(@PathVariable Long id) {
	        User user = getPrincipalUser();
	        System.out.println("Admin User page Called");
	        AjaxResponseBody<User> ajaxResponse= new AjaxResponseBody<>();
	        ajaxResponse.setObj(user);
	        return ajaxResponse;
	    }*/
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "dba";
	    }
	   /* @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	    public void calledAdminPage(ModelMap model) {
	       model.addAttribute("user", getPrincipal());
	    	System.out.println("callled Admin");
	    }*/
	 
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        return "login";
	    }
	 
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	    }
	 
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	    private User getPrincipalUser(){
	        User user = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	        	user = (User) ((UserDetails)principal);
	        } else {
	        	user = null;
	        }
	        return user;
	    }
}
