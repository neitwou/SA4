package br.com.sistemaestoque.aplicacao;

import br.com.sistemaestoque.dao.UsuarioDAO;
import br.com.sistemaestoque.model.Usuario;

public class MainUsuario {
	
	public static void main(String[] args) {
		//Adicionar usuario
		UsuarioDAO contatoDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("Arthur");
		usuario.setSenha("arthur1021");
		contatoDao.save(usuario);

	}

}
