package com.online_store2.online_store2.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_store2.online_store2.Entities.AdminLogin;
import com.online_store2.online_store2.Repositories.AdminRepository;
import com.online_store2.online_store2.Service.AdminService;

@Service
public class AdminLoginServiceimpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public String signup(AdminLogin adminLogin) {
		adminRepository.save(adminLogin)	;
		return "Account has been created";
		}

	@Override
	public String login(String email, String password) {
		AdminLogin adminLogin=adminRepository.findbyemailid(email);
		
		if(adminLogin!=null)
		{
			if(adminLogin.getPassword().equals(password))
		return "you are welcome";
				
				return "Invalid password";
		}
		else
			return "kindly create account";
	}
	
}
