package crud;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.Livro;
import util.DataInMemory;

public class LivroCrudTest {
	public static CRUD<Livro> crud = new LivroCRUD();
	
	@Test
	public void test1/*Salvar*/() {
		crud.salvar(new Livro(DataInMemory.INSTANCE.newId()));
		crud.salvar(new Livro(DataInMemory.INSTANCE.newId()));
		crud.salvar(new Livro(DataInMemory.INSTANCE.newId()));

		Assert.assertEquals(DataInMemory.INSTANCE.getLivros().size(),3);
		
		DataInMemory.INSTANCE.getLivros()
		.forEach(e -> Assert.assertNotEquals(e.getCodigo(), 0));
	}

	@Test
	public void test2/*Consultar*/() {
		DataInMemory.INSTANCE
		.getLivros()
		.forEach(e -> 
		   Assert.assertEquals(e,crud.consultar(e.getCodigo()))
		  );
	}

	@Test
	public void test3/*Alterar*/() {
		List<Livro> livros = new ArrayList<>(DataInMemory.INSTANCE.getLivros());
		Livro firstLivro = livros.get(0);
		firstLivro.setAutor("teste");
		firstLivro.setTitulo("teste");
		firstLivro.setPreco(2.0);
		
		crud.alterar(firstLivro);
		Livro crudFirstLivro = crud.consultar(firstLivro.getCodigo());
		
		Assert.assertEquals(firstLivro, crudFirstLivro);
 		
	}
	@Test
	public void test4/*Listar*/() {
		Assert.assertEquals(DataInMemory.INSTANCE.getLivros().size()
				,crud.listar().size());
	}
	@Test
	public void test5/*Remover*/() {
		List<Livro> livros = new ArrayList<>(DataInMemory.INSTANCE.getLivros());
		Livro firstLivro = livros.get(0);
		
		int size = livros.size();
		
		System.out.println("antes "+crud.listar());
		
		crud.remover(firstLivro);
		
		System.out.println("depois "+ crud.listar());
		
		Assert.assertTrue(size > crud.listar().size());
	}


}
