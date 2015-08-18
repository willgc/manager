package br.com.wgengenharia.manager.business;

import javax.persistence.EntityManager;

import br.com.wgengenharia.manager.dao.ClientDAO;
import br.com.wgengenharia.manager.dao.ClientDAOImpl;
import br.com.wgengenharia.manager.model.Client;

public class ClientBO implements ClientDAO {

	private ClientDAO clientDAO;
	
	public ClientBO(EntityManager em) {
		clientDAO = new ClientDAOImpl(em);
	}
	
	@Override
	public void insert(Client client) {
		clientDAO.insert(client);
	}

	@Override
	public void update(Client client) {
		clientDAO.update(client);
	}

	@Override
	public void delete(Client client) {
		clientDAO.delete(client);
	}

	@Override
	public Client findById(Integer id) {
		return clientDAO.findById(id);
	}

}