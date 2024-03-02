package com.online_store2.online_store2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.online_store2.online_store2.Entities.AdminLogin;

public interface AdminRepository extends JpaRepository<AdminLogin, Long>
{

@Query(value="select * from Admin_login ul where ul.email =(:query)", nativeQuery=true)

AdminLogin findbyemailid(String query);



}
