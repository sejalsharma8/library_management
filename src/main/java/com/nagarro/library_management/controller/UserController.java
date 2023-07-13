package com.nagarro.library_management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.library_management.model.User;
import com.nagarro.library_management.services.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest req,Model model) {
		String msg="";
		boolean success=false;
		
		HttpSession session=req.getSession();
		User userFromDB=null;
		if (username.length() < 5 || username.length() > 50) {
            msg = "Username must be between 2 to 50 characters";
            model.addAttribute("msg", msg);
            model.addAttribute("success", false);
            return "login";
}
	    if (password.length() < 5 || password.length() > 50) {
	    	msg = "Password must be between 2 to 20 characters";
	    	model.addAttribute("msg", msg);
	    	model.addAttribute("success", false);
	    	return "login";
}
		//user not exist
		try {
			userFromDB=userValidator.userNotExist(username);
		}catch(Exception e) {
			msg=e.getMessage();
			model.addAttribute("msg", msg);
			model.addAttribute("success", success);
			return "login";
		}
		
		//check password
		try {
			userValidator.passwordMismatch(password,userFromDB.getUserPassword());
		}catch(Exception e) {
			msg=e.getMessage();
			model.addAttribute("msg", msg);
			model.addAttribute("success", success);
			return "login";
		}
		session.setAttribute("user", userFromDB);
		//return "redirect:/welcome";
		return "editBook";
	}

}
