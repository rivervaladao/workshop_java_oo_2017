package crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.Livro;
import util.DataInMemory;

public class LivroCRUD implements CRUD<Livro> {
	private Collection<Livro> livros;

	public LivroCRUD() {
		livros = DataInMemory.INSTANCE.getLivros();
	}

	@Override
	public Livro consultar(int id) {
		  return livros.stream() 
				  .filter(e -> e.getCodigo() == id)
				  .findFirst()
				  .orElseThrow(()-> new RuntimeException("Livro não encontrado"));
		 
	}

	@Override
	public void alterar(Livro objeto) {
		Livro livro = consultar(objeto.getCodigo());
		livro.setAutor(objeto.getAutor());
		livro.setDescricao(objeto.getDescricao());
		livro.setImagem(objeto.getImagem());
		livro.setPreco(objeto.getPreco());
		livro.setTitulo(objeto.getTitulo());
	}

	@Override
	public void salvar(Livro objeto) {
		livros.add(objeto);
	}

	@Override
	public void remover(Livro objeto) {
		//livros.removeIf( e -> e.getCodigo() == objeto.getCodigo());
				
		for (Iterator<Livro> it = livros.iterator(); it.hasNext();) {
			Livro l = it.next();
			if (l.getCodigo() == objeto.getCodigo()) {
				it.remove();
			}
		}
		
	}

	@Override
	public Collection<Livro> listar() {
		return livros;
	}

}
