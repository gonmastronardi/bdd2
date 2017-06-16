/**
 * 
 */
package bd2.Muber.repositories.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bd2.Muber.repositories.BaseRepository;

/**
 * @author Lautaro
 * Implementaci�n de la clase de Repositorio Base
 * Contiene una variable de SessionFactory
 */
public class BaseHibernateRepository implements BaseRepository {

	/* (non-Javadoc)
	 * @see bd2.Muber.repositories.BaseRepository#getSession()
	 */
	protected SessionFactory sessionFactory;
	
	/**
	 * M�todo que le pide la sesi�n actual al sessionFactory y la retorna
	 **/
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
