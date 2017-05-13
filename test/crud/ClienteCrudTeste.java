package crud;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import model.Cliente;
import model.Livro;
import util.DataInMemory;

public class ClienteCrudTeste {
	CRUD<Cliente> crud = new ClienteCRUD();
	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalvar() {
		crud.salvar(new Cliente(DataInMemory.INSTANCE.newId()));
		crud.salvar(new Cliente(DataInMemory.INSTANCE.newId()));
		crud.salvar(new Cliente(DataInMemory.INSTANCE.newId()));

		Assert.assertEquals(DataInMemory.INSTANCE.getClientes().size(),3);
		
		DataInMemory.INSTANCE.getClientes()
		.forEach(e -> Assert.assertNotEquals(e.getCodigo(), 0));
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		DataInMemory.INSTANCE
		.getClientes()
		.forEach(e -> 
		   Assert.assertEquals(e,crud.consultar(e.getCodigo()))
		  );
	}

}
