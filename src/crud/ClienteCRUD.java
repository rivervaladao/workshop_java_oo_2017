package crud;

import java.util.Collection;
import java.util.Iterator;

import model.Cliente;
import util.DataInMemory;

public class ClienteCRUD implements CRUD<Cliente> {
	Collection<Cliente>  clientes;
	
	public ClienteCRUD(){
		clientes = DataInMemory.INSTANCE.getClientes();
	}

	@Override
	public Cliente consultar(int id) {
		for (Cliente cliente : clientes) {
			if(cliente.getCodigo() == id){
				return cliente;
			}
		}
		return null;
	}

	@Override
	public void alterar(Cliente objeto) {
		Cliente cliente = consultar(objeto.getCodigo());
		cliente.setBairro(objeto.getBairro());
		cliente.setCep(objeto.getCep());
		//...
	}

	@Override
	public void salvar(Cliente objeto) {
		clientes.add(objeto);
		
	}

	@Override
	public void remover(Cliente objeto) {
		Iterator<Cliente> iterator = clientes.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(objeto)){
				iterator.remove();
			}
		}
		
	}

	@Override
	public Collection<Cliente> listar() {
		return clientes;
	}

}
