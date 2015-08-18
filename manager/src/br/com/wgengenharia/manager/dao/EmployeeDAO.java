package br.com.wgengenharia.manager.dao;

import br.com.wgengenharia.manager.dao.model.DAOInterface;
import br.com.wgengenharia.manager.model.Employee;

public interface EmployeeDAO extends DAOInterface<Employee, Integer>  {

	public Employee findByEmail(String email);
	
}
