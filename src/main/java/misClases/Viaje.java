package misClases;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

public class Viaje {
	
	protected String destino;
	protected String origen;
	protected float costoTotal;
	protected Date fecha;
	protected int maxPasajeros;
	protected boolean finalizado;
	protected Conductor conductor;
	protected Collection<Pasajero> pasajeros = new HashSet<Pasajero>();
	protected Collection<Calificacion> calificaciones = new HashSet<Calificacion>();
	protected float puntaje;
	
	public float getPuntaje() {
		float puntajeTotal = 0;
		for (Calificacion calificacion : calificaciones) {
			puntajeTotal = puntajeTotal + calificacion.getPuntaje();
		}
		puntaje = (puntajeTotal / calificaciones.size());
		return puntaje;
	}
	
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	private long idViaje;
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public float getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMaxPasajeros() {
		return maxPasajeros;
	}
	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Collection<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(Collection<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Collection<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Collection<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void inicializar(float costoTotal, Date fecha, String destino, String origen, int maxPasajeros, Conductor conductor) {
		this.setConductor(conductor);
		this.setCostoTotal(costoTotal);
		this.setDestino(destino);
		this.setFinalizado(false);
		this.setFecha(fecha);
		this.setMaxPasajeros(maxPasajeros);
		this.setOrigen(origen);
	}
	public void finalizar() {
		this.setFinalizado(true);		
	}
	public void agregarCalificacion(Calificacion calificacion) {
		this.calificaciones.add(calificacion);
	}
	public void agregarPasajero(Pasajero pasajero) {
		if (this.getMaxPasajeros() > this.pasajeros.size() ) {
			this.pasajeros.add(pasajero);
			System.out.print("El pasajero se agregó con éxito");
		} else {
			System.out.print("La capacidad esta llena");
		}
	}
	
	public boolean estaFinalizado() {
		return this.finalizado;
	}
	public long getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(long id) {
		this.idViaje = id;
	}

}
