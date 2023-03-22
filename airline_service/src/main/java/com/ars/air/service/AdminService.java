package com.ars.air.service;

import javax.persistence.PersistenceException;

import com.ars.air.entity.Admin;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.AdminDTO;


public interface AdminService {
	void registerAdmin(Admin admin) ;
	boolean loginAdmin(String username,String password);
	AdminDTO getAdminById(int id) throws GlobalException;
    AdminDTO updateAdmin(int id,Admin admin);
	void deleteAdmin(int id) throws PersistenceException;
}


