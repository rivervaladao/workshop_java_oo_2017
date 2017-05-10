package util;

import java.util.Collection;
import java.util.HashSet;

import model.Cliente;
import model.Livro;
import model.Pedido;

public enum DataInMemory {
	INSTANCE;
	private static int lastId=0;
	
	private Collection<Livro> livros = new HashSet<>(); 
	private Collection<Pedido> pedidos = new HashSet<>();
	private Collection<Cliente> clientes = new HashSet<>();
	
	public Collection<Livro> getLivros() {
		return livros;
	}
	public Collection<Pedido> getPedidos() {
		return pedidos;
	}
	public Collection<Cliente> getClientes() {
		return clientes;
	}
	public int newId(){
		return ++lastId;
	}
		
}
