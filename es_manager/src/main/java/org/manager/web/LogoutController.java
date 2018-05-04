package org.manager.web;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	 @RequestMapping("/logout")
	  public String logOut(HttpSession session) {
	        Subject subject = SecurityUtils.getSubject();
	        subject.logout();
	        return "redirect:/login.jsp";
	    }
}
