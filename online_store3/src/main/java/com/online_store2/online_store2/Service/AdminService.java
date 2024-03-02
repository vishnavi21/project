package com.online_store2.online_store2.Service;

import com.online_store2.online_store2.Entities.AdminLogin;

public interface AdminService {
	String signup(AdminLogin adminLogin);
	String login(String email, String password);
}
