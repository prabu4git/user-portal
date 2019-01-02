package com.trilogy.project.controller;


import java.security.Principal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {	
	@RequestMapping("/login")	
	public Principal login(Principal user){
		System.out.println("Welcome user"+user.getName());
		return user;
	}
}