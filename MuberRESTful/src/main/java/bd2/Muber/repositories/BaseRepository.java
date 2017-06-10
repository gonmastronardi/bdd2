/**
 * 
 */
package bd2.Muber.repositories;

import org.hibernate.Session;

/**
 * @author Lautaro
 * Interface utilizada para representar al repositorio base del cual extienden todos los dem�s
 * Define un m�todo para obtener la sesi�n y que pueda utilizarse desde todos los repositorios
 */
public interface BaseRepository {
	
	Session getSession();

}
