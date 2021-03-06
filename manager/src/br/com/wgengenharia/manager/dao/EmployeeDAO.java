package br.com.wgengenharia.manager.dao;

import java.util.List;

import br.com.wgengenharia.manager.dao.model.DAOInterface;
import br.com.wgengenharia.manager.model.Branch;
import br.com.wgengenharia.manager.model.Company;
import br.com.wgengenharia.manager.model.Employee;

public interface EmployeeDAO extends DAOInterface<Employee, Integer>  {

	public Employee findByEmail(String email);
	
	public List<Employee> listByCompany(Company company);
	
	public List<Employee> listByCompanyAndBranch(Company company,Branch branch);
	
}
