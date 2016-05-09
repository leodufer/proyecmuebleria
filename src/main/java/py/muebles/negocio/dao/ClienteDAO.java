package py.muebles.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.muebles.negocio.model.Cliente;


@Repository
public class ClienteDAO extends DaoGenerico<Cliente> {
	@PersistenceContext
	private  EntityManager em;

	public ClienteDAO() {
		super(Cliente.class);
		}
	

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}


	
}






