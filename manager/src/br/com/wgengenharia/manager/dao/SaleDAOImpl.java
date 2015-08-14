package br.com.wgengenharia.manager.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wgengenharia.manager.dao.model.DAOImpl;
import br.com.wgengenharia.manager.model.Sale;

public class SaleDAOImpl extends DAOImpl<Sale, Integer> implements SaleDAO{

	public SaleDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Sale> listSalesDay(Calendar day) {
		TypedQuery<Sale> query = em.createQuery("from Sale s where s.date like :day ", Sale.class);
		query.setParameter("day", day);
    return query.getResultList();
	}
}
