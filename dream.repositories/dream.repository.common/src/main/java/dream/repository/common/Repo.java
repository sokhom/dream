/***
 * @author ngounphanny
 * 
 */
package dream.repository.common;

import java.util.List;

public interface Repo<T> {
	T add(T t);
	void remove(T t);
	T edit(T t);
	List<T> getAll();
	T getById(int id); 
}
