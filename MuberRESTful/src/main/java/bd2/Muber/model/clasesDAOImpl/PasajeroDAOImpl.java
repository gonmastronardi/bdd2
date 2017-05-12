/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.model.clasesDAO.PasajeroDAO;
import bd2.Muber.model.clasesDTO.PasajeroDTO;
import bd2.Muber.model.Pasajero;

/**
 * @author GM
 *
 */
public class PasajeroDAOImpl implements PasajeroDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see bd2.Muber.model.clasesDAO.PasajeroDAO#getAllPasajeros(org.hibernate.
	 * Session)
	 */

	public PasajeroDAOImpl() {
	}

	@Override
	@Transactional
	public List<Pasajero> getAllPasajeros(Session session) {
		Query query = session.createQuery("FROM Pasajero P");
		@SuppressWarnings("unchecked")
		List<Pasajero> list = query.list();
		return list;
	}

	public List<PasajeroDTO> getAllPasajerosAsPasajeroDTO(Session session) {
		List<PasajeroDTO> pasajeroDTOs = new ArrayList<PasajeroDTO>();
		for (Pasajero pasajero : getAllPasajeros(session)) {
			pasajeroDTOs.add(constructPasajeroDTO(pasajero));
		}

		return pasajeroDTOs;
	}

	private PasajeroDTO constructPasajeroDTO(Pasajero pasajero) {
		PasajeroDTO pasajeroDTO = new PasajeroDTO();
		pasajeroDTO.setNombre(pasajero.getNombre());
		pasajeroDTO.setFechaIngreso(pasajero.getfechaIngreso());
		pasajeroDTO.setCredito(pasajero.getCredito());
		return pasajeroDTO;
	}

	@Override
	public List<Pasajero> getById(Session session, long idPasajero) {
		Query query = session.createQuery("FROM Pasajero P WHERE P.idUsuario = :id ");
		query.setParameter("id", idPasajero);
		@SuppressWarnings("unchecked")
		List<Pasajero> list = query.list();
		return list;
		
	}

	@Override
	public void updatePasajero(Session session, Pasajero pasajero) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(pasajero);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
