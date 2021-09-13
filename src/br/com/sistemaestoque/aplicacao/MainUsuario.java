package br.com.sistemaestoque.aplicacao;

import java.util.Scanner;

import br.com.sistemaestoque.dao.UsuarioDAO;
import br.com.sistemaestoque.model.Usuario;

public class MainUsuario {
	
	public static void main(String[] args) {
		
		Scanner texto = new Scanner(System.in);		
		String str;
		System.out.println("Crie seu login: ");
		str = texto.nextLine();
		String str2;
		System.out.println("Crie sua senha: ");
		str2 = texto.nextLine();
		
		//Adicionar usuario
		UsuarioDAO contatoDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin(str);
		usuario.setSenha(str2);
		contatoDao.save(usuario);

	}

}
