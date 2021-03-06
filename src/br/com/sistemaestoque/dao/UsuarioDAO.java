package br.com.sistemaestoque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.sistemaestoque.factory.ConnectionFactory;
import br.com.sistemaestoque.model.Usuario;

public class UsuarioDAO {
	
	//CRUD (CREATE, READ, UPDATE E DELETE)
	
	//ADD USUARIO
	public void save(Usuario usuario) {
		
		String sql = "INSERT INTO usuario(login, senha) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//criamos uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//valor esperado pela query
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());

			
			//executar a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			//fechar as conexoes
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//ATUALIZAR USUARIO
	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET login = ?, senha = ?"+"WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria conexao
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//add os valores para atualizar
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			//id do registro pra atualizar
			pstm.setInt(3, usuario.getId());
			//executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//LISTAR USUARIO
	public List<Usuario> getUsuarios(){
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id"));
				usuario.setLogin(rset.getString("login"));
				usuario.setSenha(rset.getString("senha"));
				
				usuarios.add(usuario);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return usuarios;

	}
	
	//DELETAR USUARIO
	public void deleteById(int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria conexao
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//add os valores para atualizar
			pstm.setInt(1, id);
			//executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
