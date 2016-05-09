package py.muebles.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.muebles.negocio.model.Producto;
import py.muebles.negocio.model.Usuario;

@Repository
public class UsuarioDAO extends DaoGenerico<Usuario> {

	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
		
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
	
	
}
