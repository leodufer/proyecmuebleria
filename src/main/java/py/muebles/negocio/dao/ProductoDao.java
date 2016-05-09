package py.muebles.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.muebles.negocio.model.Producto;

@Repository
public class ProductoDao extends DaoGenerico<Producto> {

	@PersistenceContext
	private EntityManager em;
	
	public ProductoDao() {
		
		super(Producto.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
	
	
}
