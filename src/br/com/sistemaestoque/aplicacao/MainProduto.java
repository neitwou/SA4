package br.com.sistemaestoque.aplicacao;

import java.util.Scanner;

import br.com.sistemaestoque.dao.ProdutoDAO;
import br.com.sistemaestoque.model.Produto;
import br.com.sistemaestoque.model.Usuario;

public class MainProduto {
	
	public static void main(String[] args) {
		
		Scanner texto = new Scanner(System.in);	
		
		String str;
		System.out.println("Produto a vender: ");
		str = texto.nextLine();
		
		String str3;
		System.out.println("Descrição do produto: ");
		str3 = texto.nextLine();
		
		System.out.println("Preço do produto: ");
		int str2 = texto.nextInt();
		
		
		//Adicionar produto
		ProdutoDAO produtoDao = new ProdutoDAO();
		Produto produto = new Produto();
		produto.setNome(str);
		produto.setPreco(str2);
		produto.setDescricao(str3);
		produtoDao.save(produto);
	
		
		//Atualizar PRODUTO
		Produto p1 = new Produto();
		p1.setNome("MonitorAOC");
		p1.setPreco(31);
		p1.setDescricao("Monitor LED AOC");
		p1.setId(15);
		produtoDao.update(p1);
		
		//visualizaçao dos registro TODOS
		for(Produto p : produtoDao.getProdutos()) {
		System.out.println("Produto: "+p.getNome());
		}
	}
}
