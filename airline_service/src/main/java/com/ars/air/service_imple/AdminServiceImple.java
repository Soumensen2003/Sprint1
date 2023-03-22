package com.ars.air.service_imple;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars.air.dao.AdminDao;
import com.ars.air.daoimple.AdminDaoImple;
import com.ars.air.entity.Admin;
import com.ars.air.exception.GlobalException;
import com.ars.air.model.AdminDTO;
import com.ars.air.service.AdminService;



public class AdminServiceImple implements AdminService{
	AdminDao aDao=new AdminDaoImple();
	@Override
	public void registerAdmin(Admin admin) {
		aDao.registerAdmin(admin);
		
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		
		return aDao.loginAdmin(userName, password);
	}
	//method for get admin  in service layer
			@Override
			public AdminDTO getAdminById(int id) {
				Admin admin	=aDao.getAdminById(id);
				if(admin!=null)
				{
					
					return new ModelMapper().map(admin, AdminDTO.class); //converting entity to DTO
				}
					throw new GlobalException("Admin details does not exist!!");
			}
			//method for delete admin  in service layer
			@Override
			public void deleteAdmin(int id) throws PersistenceException {
				
				aDao.deleteAdmin(id);
				
			}
			//method for update admin  in service layer
			@Override
			public AdminDTO updateAdmin(int id, Admin admin) {
				Admin a=aDao.updateAdmin(id, admin);
				
				return new ModelMapper().map(a, AdminDTO.class); //converting entity to DTO
			}

}
