package br.com.sistemaestoque.aplicacao;

import br.com.sistemaestoque.dao.ProdutoDAO;
import br.com.sistemaestoque.model.Produto;

public class MainProduto {
	
	public static void main(String[] args) {
		

	//Adicionar produto
	ProdutoDAO produtoDao = new ProdutoDAO();
	Produto produto = new Produto();
	produto.setNome("Relogio Orient");
	produto.setPreco(150);
	produto.setDescricao("Prata a prova d'agua");
	produtoDao.save(produto);
	
	}
}
