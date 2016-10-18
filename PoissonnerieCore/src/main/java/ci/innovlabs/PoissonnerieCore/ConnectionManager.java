package ci.innovlabs.PoissonnerieCore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {
	private static ConnectionManager INSTANCE = null;
	private EntityManager em;
	
	private ConnectionManager(){
		init();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		em.close();
	}
	
	private void init(){
		EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("PoissonneriePU");
        em = emf.createEntityManager();
	}
	
	public static EntityManager getInstance() {
		if(INSTANCE == null){
			INSTANCE = new ConnectionManager();
		}
		
		return INSTANCE.em;
	}
}
