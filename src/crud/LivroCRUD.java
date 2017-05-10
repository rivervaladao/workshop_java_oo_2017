package crud;

import java.util.Collection;
import java.util.Iterator;

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
		System.out.println("antes "+ livros);
		boolean removed = false; 
				//livros.removeIf( e -> e.getCodigo() == objeto.getCodigo());
		for(Iterator<Livro> it =  livros.iterator(); it.hasNext();){
			Livro l = it.next(); 
			if(l.getCodigo() == objeto.getCodigo()){
				System.out.println(l);
				it.remove();
				removed = true;
			}
		}
		System.out.println("removed : "+ removed);
		System.out.println("depois "+ livros);		
	}

	@Override
	public Collection<Livro> listar() {
		return livros;
	}

}
