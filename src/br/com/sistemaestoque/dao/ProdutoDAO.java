package br.com.sistemaestoque.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.sistemaestoque.factory.ConnectionFactory;
import br.com.sistemaestoque.model.Produto;
import br.com.sistemaestoque.model.Usuario;

public class ProdutoDAO {
	
	//CRUD (CREATE, READ, UPDATE E DELETE)
	
	//ADD PRODUTO
	public void save(Produto produto) {
		
		String sql = "INSERT INTO produto(nome, preco, descricao) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//criamos uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//valor esperado pela query
			pstm.setString(1, produto.getNome());
			pstm.setInt(2, produto.getPreco());
			pstm.setString(3, produto.getDescricao());
			
			//executar a query
			pstm.execute();
			System.out.println("Produto salvo com sucesso!");
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
	
	//LISTAR PRODUTO
	public List<Produto> getProdutos(){
		
		String sql = "SELECT * FROM produto";
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Produto produto = new Produto();
				
				produto.setId(rset.getInt("id"));
				produto.setNome(rset.getString("nome"));
				produto.setPreco(rset.getInt("preco"));
				produto.setDescricao(rset.getString("descricao"));
				
				produtos.add(produto);
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
			
			return produtos;
	}

	//ATUALIZAR PRODUTO
	public void update(Produto produto) {
		String sql = "UPDATE produto SET nome = ?, preco = ?, descricao = ?"+"WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//cria conexao
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//add os valores para atualizar
			pstm.setString(1, produto.getNome());
			pstm.setInt(2, produto.getPreco());
			pstm.setString(3, produto.getDescricao());
			//id do registro pra atualizar
			pstm.setInt(4, produto.getId());
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
