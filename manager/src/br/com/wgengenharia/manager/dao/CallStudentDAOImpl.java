package br.com.wgengenharia.manager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wgengenharia.manager.dao.model.DAOImpl;
import br.com.wgengenharia.manager.model.Branch;
import br.com.wgengenharia.manager.model.CallStudent;

public class CallStudentDAOImpl extends DAOImpl<CallStudent, Integer> implements CallStudentDAO{

	public CallStudentDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<CallStudent> listByBranch(Branch branch) {
		TypedQuery<CallStudent> query = em.createQuery("from CallStudent o where o.branch = :branch", CallStudent.class);
		query.setParameter("branch", branch);
    return query.getResultList();
	}

}
