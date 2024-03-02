package com.online_store2.online_store2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_store2.online_store2.Entities.AdminLogin;
import com.online_store2.online_store2.Service.AdminService;

@RestController
@CrossOrigin(origins="http://localhost:4200")

@RequestMapping("/api/adminlogin")
public class AdminLoginController {
	@Autowired
	AdminService adminService;

	@PostMapping("/signup")
	public String signup(@RequestBody AdminLogin adminLogin)
	{
		return adminService.signup(adminLogin);
	}

	@GetMapping("/search/{email}/{password}")
	public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password)
	{
		return ResponseEntity.ok(adminService.login(email, password));
	}
	}

