/**
 * 
 */
package com.bestgamesreviews.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marielle Machael Rudolph 
 *
 */
@RestController
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * gérer les rôles user et revoie un taken pour suivre l'utilisateut
	 * @return
	 */
	  @RolesAllowed("USER")
	   @RequestMapping("/*")
	   public String getUser()
	   {
	      return "Welcome User";
	   }

	  /**
		 * gérer les rôles Admin et revoie un taken pour suivre l'utilisateut
		 * @return
		 */
	   @RolesAllowed({"USER","ADMIN"})
	   @RequestMapping("/admin")
	   public String getAdmin()
	   {
	      return "Welcome Admin";
	   }
}
