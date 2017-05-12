/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.clasesDAO.ViajeDAO;

/**
 * @author GM
 *
 */
public class ViajeDAOImpl implements ViajeDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bd2.Muber.model.clasesDAO.ViajeDAO#getAllViajesAbiertos(org.hibernate.
	 * Session)
	 */
	@Override
	@Transactional
	public List<String> getAllViajesAbiertos(Session session) {
		Query query = session.createQuery(
				"SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.finalizado = '0' ");
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

	@Override
	public void createViaje(Session session, Viaje viaje) {

		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(viaje);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public List<Viaje> getById(Session session, long idViaje) {
		Query query = session.createQuery("FROM Viaje V WHERE V.idViaje = :id ");
		query.setParameter("id", idViaje);
		@SuppressWarnings("unchecked")
		List<Viaje> list = query.list();
		return list;
	}

	@Override
	public void updateViaje(Session session, Viaje viaje) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(viaje);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
