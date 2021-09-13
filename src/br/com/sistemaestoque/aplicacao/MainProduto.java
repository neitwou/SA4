package br.com.sistemaestoque.aplicacao;

import java.util.Scanner;

import br.com.sistemaestoque.dao.ProdutoDAO;
import br.com.sistemaestoque.model.Produto;

public class MainProduto {
	
	public static void main(String[] args) {
		
		Scanner texto = new Scanner(System.in);	
		
		String str;
		System.out.println("Produto a vender: ");
		str = texto.nextLine();
		
		String str3;
		System.out.println("Descri��o do produto: ");
		str3 = texto.nextLine();
		
		System.out.println("Pre�o do produto: ");
		int str2 = texto.nextInt();



	//Adicionar produto
	ProdutoDAO produtoDao = new ProdutoDAO();
	Produto produto = new Produto();
	produto.setNome(str);
	produto.setPreco(str2);
	produto.setDescricao(str3);
	produtoDao.save(produto);
	
	}
}
