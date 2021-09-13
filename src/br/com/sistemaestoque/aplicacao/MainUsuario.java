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
		
		//Atualizar usuario
		Usuario u1 = new Usuario();
		u1.setLogin("Marcio");
		u1.setSenha("505050");
		u1.setId(13);
		contatoDao.update(u1);

		//visualizaçao dos registro TODOS
		for(Usuario u : contatoDao.getUsuarios()) {
			System.out.println("Usuario: "+u.getLogin());
		}
	}

}
