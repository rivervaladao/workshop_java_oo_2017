package crud;

import java.util.Collection;

public interface CRUD <E> {
	
	E consultar(final int id);
	
	void alterar(final E objeto);
	
	void salvar(final E objeto);
	
	void remover (final E objeto);
	
	Collection<E> listar();

}