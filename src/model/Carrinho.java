package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	
}
